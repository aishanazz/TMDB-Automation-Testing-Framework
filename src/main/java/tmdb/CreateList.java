package tmdb;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateList {

    @Test(priority = 0)
    public void createMovieList() {
        String payload = "{\n" +
                "  \"name\": \"This is my awesome test list.\",\n" +
                "  \"description\": \"Just an awesome list dawg.\",\n" +
                "  \"language\": \"en\"\n" +
                "}";
        given()
                .baseUri("https://api.themoviedb.org")
                .contentType("application/json").body(payload)
                .when().queryParam("session_id", "9078f551bfb19d83403ca9880bf6a5a16444a5f3")
                .queryParam("api_key","8dde48da411a7993668563ab06b893a1")
                .post("3/list")
                .then()
                .statusCode(201)
                .log()
                .all().extract().response();
    }
}