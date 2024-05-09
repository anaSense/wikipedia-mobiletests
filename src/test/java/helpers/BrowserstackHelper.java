package helpers;

import config.BrowserstackAuthConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static helpers.ConstantsHelper.APP_NAME;
import static helpers.ConstantsHelper.APP_URL;
import static io.restassured.RestAssured.given;

public class BrowserstackHelper {
    static BrowserstackAuthConfig browserstackConfig = ConfigFactory.create(BrowserstackAuthConfig.class,
            System.getProperties());

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(browserstackConfig.userName(), browserstackConfig.accessKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }

    public static String uploadApp() {
        String url = "https://api-cloud.browserstack.com/app-automate/upload";
        Map<String, Object> dataBody = new HashMap<>();
        dataBody.put("url", APP_URL + APP_NAME);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("data", dataBody);

        Response response = given()
                .header("Authorization", "Basic " + Base64.getEncoder().encodeToString((browserstackConfig.userName()
                        + ":" + browserstackConfig.accessKey()).getBytes()))
                .body(requestBody)
                .contentType(ContentType.JSON)
                .post(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().response();
        return response.jsonPath().getString("app_url");
    }
}
