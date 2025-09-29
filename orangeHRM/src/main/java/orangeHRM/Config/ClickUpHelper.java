package orangeHRM.Config;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class ClickUpHelper {
	
    private static final String CLICKUP_API_TOKEN = "SEU_TOKEN_AQUI";

    public static void uploadScreenshot(Path screenshotPath, String CLICKUP_TASK_ID) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.clickup.com/api/v2/task/" + CLICKUP_TASK_ID + "/attachment"))
                .header("Authorization", CLICKUP_API_TOKEN)
                .header("Content-Type", "multipart/form-data")
                .POST(HttpRequest.BodyPublishers.ofFile(screenshotPath))
                .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Upload ClickUp: " + response.statusCode() + " - " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

