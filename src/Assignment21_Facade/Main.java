package Assignment21_Facade;

public class Main {
    public static void main(String[] args) {
        ApiConnector apiConnector = new ApiConnector();
        ApiFacade apiFacade = new ApiFacade(apiConnector);

        String urlString = "https://api.chucknorris.io/jokes/random";
        //String urlString =  "https://api.fxratesapi.com/latest";
        try {
            System.out.println(apiFacade.getAttributeValueFromJson(urlString, "value"));
            //System.out.println(apiFacade.getAttributeValueFromJson(urlString, "rates"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
