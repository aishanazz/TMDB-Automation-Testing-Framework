package tmdb;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BitclassAuth {

    @Test(priority = 0)
    public void otpGenerate() {
        String payload = "{\n" +
                "   \"phone\": \"8660189341\",\n" +
                "   \"country_code\": \"+91\",\n" +
                "   \"attempt_count\": 0\n" +
                "}";
        given()
                .baseUri("https://staging-graviton.bitclassdev.com")
                .contentType("application/json").body(payload)
                .when()
                .post("v1/auth/generate-otp")
                .then()
                .statusCode(200)
                .log()
                .all().extract().response();
    }

    @Test(priority = 1)
    public void otpLogin() {
        String payload = "{\n" +
                "   \"phone\": \"8660189341\",\n" +
                "   \"country_code\": \"+91\",\n" +
                "   \"otp\": \"1971\"\n" +
                "}";
        given()
                .baseUri("https://staging-graviton.bitclassdev.com")
                .contentType("application/json").body(payload)
                .when()
                .post("v1/auth/login")
                .then()
                .statusCode(200)
                .log()
                .all().extract().response();
    }


}
