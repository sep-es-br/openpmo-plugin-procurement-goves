package br.gov.es.pmo.procurement_parser.service;
import br.gov.es.pmo.procurement_core.model.*; import br.gov.es.pmo.procurement_parser.model.PentahoQueryResponse; import br.gov.es.pmo.procurement_parser.properties.PentahoProcurementProperties;
import org.springframework.core.env.Environment; import org.springframework.http.HttpHeaders; import org.springframework.stereotype.Component; import org.springframework.util.StringUtils; import org.springframework.web.reactive.function.client.WebClient;
import java.util.List; import java.util.stream.Collectors;
@Component public class PentahoProcurementProvider implements IProcurementProvider {
 private static final String ENDPOINT="/pentaho/plugin/cda/api/doQuery";
 private final PentahoProcurementProperties props; private final Environment env; private final WebClient client;
 public PentahoProcurementProvider(PentahoProcurementProperties p,Environment e){props=p;env=e;client=WebClient.builder().baseUrl(p.getBaseUrl()).build();}
 public List<Long> getYears(){return query(props.getYearsPath(),props.getYearsDataAccessId(),null).getResultset().stream().map(r->Long.valueOf(v(r,0))).collect(Collectors.toList());}
 public List<ProcurementOrganizationDto> getOrganizations(Long year){return query(props.getOrganizationsPath(),props.getOrganizationsDataAccessId(),new String[][]{{"paramp_ano",year.toString()}}).getResultset().stream().map(r->new ProcurementOrganizationDto(v(r,0),v(r,0))).collect(Collectors.toList());}
 public List<ProcurementDto> getProcurements(Long year,ProcurementOrganizationDto o){return query(props.getProcessesPath(),props.getProcessesDataAccessId(),new String[][]{{"paramp_ano",year.toString()},{"paramp_orgao",o.getIdentifier()}}).getResultset().stream().map(r->map(r,year,o.getName())).collect(Collectors.toList());}
 public ProcurementDto getProcurement(Long id){return query(props.getProcurementPath(),props.getProcurementDataAccessId(),new String[][]{{"paramcod_lic",id.toString()}}).getResultset().stream().findFirst().map(this::detail).orElse(null);}
 private ProcurementDto map(List<Object> r,Long year,String org){ProcurementDto d=new ProcurementDto();d.setProcessId(Long.valueOf(v(r,0)));d.setObject(v(r,1));d.setProcessNumber(v(r,2));d.setProtocol(v(r,2));d.setModality(v(r,3));d.setStatus(v(r,4));d.setYear(year);d.setOrganizationName(org);return d;}
 private ProcurementDto detail(List<Object> r){ProcurementDto d=new ProcurementDto();d.setProcessId(Long.valueOf(v(r,0)));d.setOrganizationName(v(r,1));d.setObject(v(r,2));d.setProcessNumber(v(r,3));d.setProtocol(v(r,3));d.setModality(v(r,4));d.setStatus(v(r,5));d.setYear(Long.valueOf(v(r,6)));return d;}
 private PentahoQueryResponse query(String path,String access,String[][] params){credentials();return client.get().uri(b->{b.path(ENDPOINT).queryParam("path",path).queryParam("dataAccessId",access);if(params!=null)for(String[]p:params)b.queryParam(p[0],p[1]);return b.build();}).headers(this::auth).retrieve().bodyToMono(PentahoQueryResponse.class).block();}
 private void auth(HttpHeaders h){h.setBasicAuth(user(),password());} private void credentials(){if(!StringUtils.hasText(user())||!StringUtils.hasText(password()))throw new IllegalStateException("Credenciais do Pentaho nao configuradas");}
 private String user(){return StringUtils.hasText(props.getUserId())?props.getUserId():env.getProperty("pentahoBI.userId");} private String password(){return StringUtils.hasText(props.getPassword())?props.getPassword():env.getProperty("pentahoBI.password");}
 private static String v(List<Object> r,int i){Object x=r.get(i);return x==null?null:String.valueOf(x);}
}
