package de.tenniskoenig.backend.controller;

import de.tenniskoenig.backend.BackendApplicationTests;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class HighscoreTest extends BackendApplicationTests {

    @Test
    public void getHighscore() {
        given().auth().oauth2(accessToken)
                .get("/api/highscore")
                .then().statusCode(200);
    }
}
