package Assignment21_Facade;

public class ApiFacade {
    private ApiConnector apiConnector;

    public ApiFacade(ApiConnector apiConnector) {
        this.apiConnector = apiConnector;
    }

    public String getAttributeValueFromJson(String urlString, String attributeName) throws Exception {
        String json = apiConnector.getJsonFromApi(urlString);

        return apiConnector.extractAttributeFromJson(json, attributeName);
    };
}
