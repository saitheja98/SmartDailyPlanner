package mini_projects.SmartDailyPlanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class DailyTipFetcher {
    public static String fetchTip() {
        try {
            // This is a fake API simulation
            String fakeJson = "{\"tip\": \"Stay motivated and keep going!\"}";
            JSONObject obj = new JSONObject(fakeJson);
            return obj.getString("tip");

            // For real API use, you'd uncomment this part:
            /*
            URL url = new URL("https://api.example.com/dailytip");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();
            JSONObject obj = new JSONObject(content.toString());
            return obj.getString("tip");
            */

        } catch (Exception e) {
            return "Stay positive and keep learning!";
        }
    }
}
