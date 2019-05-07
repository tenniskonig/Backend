package de.tenniskoenig.backend.controller;

import com.jayway.restassured.response.Response;
import de.tenniskoenig.backend.BackendApplicationTests;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PlayerTest extends BackendApplicationTests {

    @Test
    public void playerAll() {
        given().auth().oauth2(accessToken)
                .get("/api/player")
                .then().statusCode(200);
    }

    @Test
    public void playerId() {
        given().auth().oauth2(accessToken)
                .get("/api/player/id/1")
                .then().statusCode(200);
    }

    Response player;

    @Test
    public void player() {
        player = given().auth().oauth2(accessToken)
                .get("/api/player/name/sven.haala");
        assertEquals(player.getStatusCode(), 200);
    }
}
