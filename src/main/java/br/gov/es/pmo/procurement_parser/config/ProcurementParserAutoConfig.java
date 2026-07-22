package br.gov.es.pmo.procurement_parser.config;
import br.gov.es.pmo.procurement_parser.properties.PentahoProcurementProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties; import org.springframework.context.annotation.ComponentScan; import org.springframework.context.annotation.Configuration; import org.springframework.context.annotation.PropertySource;
@Configuration @ComponentScan("br.gov.es.pmo.procurement_parser") @EnableConfigurationProperties(PentahoProcurementProperties.class) @PropertySource("classpath:procurement-parser.properties")
public class ProcurementParserAutoConfig {}
