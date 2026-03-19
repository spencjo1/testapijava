import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class TestAPIJava {
    public static void main(String[] args) throws Exception {
        // REST API URL
        String apiUrl = "https://doynzenmggeezeebfrpf.supabase.co/rest/v1/fiefie?select=*";

        // Your publishable key
        String apiKey = "sb_publishable_HIior5dtS-X_ClhEwQ85jA_QNl5wbHQ";

        // Open connection
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        // Add required headers for Supabase
        con.setRequestProperty("apikey", apiKey);
        con.setRequestProperty("Authorization", "Bearer " + apiKey);

        // Get response
        int status = con.getResponseCode();
        System.out.println("HTTP Status: " + status);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();

        System.out.println("Response from Supabase: " + content.toString());
    }
}

