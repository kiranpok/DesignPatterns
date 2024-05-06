package Assignment21_Facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnector {
    public String getJsonFromApi(String apiUrl) throws Exception {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                return content.toString();
            } finally {
                con.disconnect();
            }
        } catch (IOException e) {
            throw new IOException("Failed to get JSON from API: " + e.getMessage());
        }
    }

    public String extractAttributeFromJson(String json, String attribute) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);

        for (Object key : jsonObject.keySet()) {
            if (key.toString().equals(attribute)) {
                return jsonObject.get(key.toString()).toString();
            }
        }

        throw new IllegalArgumentException("Attribute \"" + attribute + "\" not found.");
    }
}
