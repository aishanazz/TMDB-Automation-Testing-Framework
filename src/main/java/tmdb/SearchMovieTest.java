package tmdb;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SearchMovieTest {

    @Test(priority = 0)
    public void searchMovieThreeIdiots() {
        given()
                .when()
                .queryParam("api_key", "8dde48da411a7993668563ab06b893a1")
                .queryParam("query", "three Idiots")
                .get("https://api.themoviedb.org/3/search/movie")
                .then()
                .assertThat()
                .statusCode(200)
                .body("results[0].original_title", is("3 Idiots"))
                .log().all();

    }
    @Test(priority = 1)
    public void searchName() {
        given()
                .when()
                .queryParam("api_key", "8dde48da411a7993668563ab06b893a1")
                .queryParam("query", "salman khan")
                .get("https://api.themoviedb.org/3/search/movie")
                .then()
                .assertThat()
                .statusCode(200)
                .body("results[0].original_title", is("Salman Khan Radio"))
                .log().all();
    }

    }






