import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Senderr {

    // Static helper method to send a FoodRating to Supabase
    public static void sendRating(FoodRating rating) {
        try {
            // Replace with your Supabase project URL and table name
            String projectUrl = "https://doynzenmggeezeebfrpf.supabase.co/rest/v1/fiefie";
            String apiKey = "sb_publishable_HIior5dtS-X_ClhEwQ85jA_QNl5wbHQ";

            // Convert the object to JSON
            String json = "[{"
                    + "\"user_id\":" + rating.user_id + ","
                    + "\"user_name\":\"" + rating.user_name + "\","
                    + "\"food_name\":\"" + rating.food_name + "\","
                    + "\"rating\":" + rating.rating + ","
                    + "\"distance\":" + rating.distance + ","
                    + "\"open_time\":" + rating.open_time + ","
                    + "\"close_time\":" + rating.close_time
                    + "}]";

            // Open HTTP connection
            URL url = new URL(projectUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("apikey", apiKey);
            con.setRequestProperty("Authorization", "Bearer " + apiKey);
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            // Write JSON to request body
            try (OutputStream os = con.getOutputStream()) {
                os.write(json.getBytes("utf-8"));
            }

            int status = con.getResponseCode();
            System.out.println("HTTP Status: " + status); // 201 = created

            con.disconnect();
        } catch (Exception e) {
            System.out.println("Failed to send rating:");
            e.printStackTrace();
        }
    }
}