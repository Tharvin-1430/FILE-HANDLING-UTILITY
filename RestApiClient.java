import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class RestApiClient {
    public static void main(String[] args) {
        try {
            String apiUrl = "https://api.example.com/weather"; // Replace with actual API URL
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            conn.disconnect();
            JSONObject jsonResponse = new JSONObject(sb.toString());
            System.out.println("Weather Data: " + jsonResponse.toString(2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}