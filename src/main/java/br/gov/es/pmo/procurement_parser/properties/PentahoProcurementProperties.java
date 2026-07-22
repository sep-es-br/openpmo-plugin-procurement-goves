package br.gov.es.pmo.procurement_parser.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "pentaho-bi")
public class PentahoProcurementProperties {
    private String baseUrl;
    private String userId;
    private String password;
    private int maxInMemorySize = 16777216;
    private String procurementYearsPath;
    private String procurementYearsDataAccessId;
    private String procurementOrganizationsPath;
    private String procurementOrganizationsDataAccessId;
    private String procurementProcessesPath;
    private String procurementProcessesDataAccessId;
    private String procurementDetailPath;
    private String procurementDetailDataAccessId;

    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String value) { baseUrl = value; }
    public String getUserId() { return userId; }
    public void setUserId(String value) { userId = value; }
    public String getPassword() { return password; }
    public void setPassword(String value) { password = value; }
    public int getMaxInMemorySize() { return maxInMemorySize; }
    public void setMaxInMemorySize(int value) { maxInMemorySize = value; }
    public String getProcurementYearsPath() { return procurementYearsPath; }
    public void setProcurementYearsPath(String value) { procurementYearsPath = value; }
    public String getProcurementYearsDataAccessId() { return procurementYearsDataAccessId; }
    public void setProcurementYearsDataAccessId(String value) { procurementYearsDataAccessId = value; }
    public String getProcurementOrganizationsPath() { return procurementOrganizationsPath; }
    public void setProcurementOrganizationsPath(String value) { procurementOrganizationsPath = value; }
    public String getProcurementOrganizationsDataAccessId() { return procurementOrganizationsDataAccessId; }
    public void setProcurementOrganizationsDataAccessId(String value) { procurementOrganizationsDataAccessId = value; }
    public String getProcurementProcessesPath() { return procurementProcessesPath; }
    public void setProcurementProcessesPath(String value) { procurementProcessesPath = value; }
    public String getProcurementProcessesDataAccessId() { return procurementProcessesDataAccessId; }
    public void setProcurementProcessesDataAccessId(String value) { procurementProcessesDataAccessId = value; }
    public String getProcurementDetailPath() { return procurementDetailPath; }
    public void setProcurementDetailPath(String value) { procurementDetailPath = value; }
    public String getProcurementDetailDataAccessId() { return procurementDetailDataAccessId; }
    public void setProcurementDetailDataAccessId(String value) { procurementDetailDataAccessId = value; }
}
