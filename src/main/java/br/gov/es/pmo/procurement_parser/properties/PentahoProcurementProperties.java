package br.gov.es.pmo.procurement_parser.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "pentaho-bi")
public class PentahoProcurementProperties {
    private String baseUrl;
    private String userId;
    private String password;
    private String yearsPath;
    private String yearsDataAccessId;
    private String organizationsPath;
    private String organizationsDataAccessId;
    private String processesPath;
    private String processesDataAccessId;
    private String procurementPath;
    private String procurementDataAccessId;

    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String value) { baseUrl = value; }
    public String getUserId() { return userId; }
    public void setUserId(String value) { userId = value; }
    public String getPassword() { return password; }
    public void setPassword(String value) { password = value; }
    public String getYearsPath() { return yearsPath; }
    public void setYearsPath(String value) { yearsPath = value; }
    public String getYearsDataAccessId() { return yearsDataAccessId; }
    public void setYearsDataAccessId(String value) { yearsDataAccessId = value; }
    public String getOrganizationsPath() { return organizationsPath; }
    public void setOrganizationsPath(String value) { organizationsPath = value; }
    public String getOrganizationsDataAccessId() { return organizationsDataAccessId; }
    public void setOrganizationsDataAccessId(String value) { organizationsDataAccessId = value; }
    public String getProcessesPath() { return processesPath; }
    public void setProcessesPath(String value) { processesPath = value; }
    public String getProcessesDataAccessId() { return processesDataAccessId; }
    public void setProcessesDataAccessId(String value) { processesDataAccessId = value; }
    public String getProcurementPath() { return procurementPath; }
    public void setProcurementPath(String value) { procurementPath = value; }
    public String getProcurementDataAccessId() { return procurementDataAccessId; }
    public void setProcurementDataAccessId(String value) { procurementDataAccessId = value; }
}
