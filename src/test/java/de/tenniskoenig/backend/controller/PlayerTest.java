package de.tenniskoenig.backend.controller;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import de.tenniskoenig.backend.BackendApplicationTests;
import de.tenniskoenig.backend.domain.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlayerTest extends BackendApplicationTests {


    @Test
    public void playerAll() {
        given().auth().oauth2(accessToken)
                .get("/api/player")
                .then().statusCode(200);
    }

    private String vorname = "Marvin";
    private String nachname = "Kubik";

    @Test
    public void playerId() {
        Response player = given().auth().oauth2(accessToken)
                .get("/api/player/id/1");
        assertEquals(player.getStatusCode(), 200);
        User user = player.as(User.class);
        assertEquals(user.getId().intValue(), 1);
    }

    @Test
    public void player() {
        Response player = given().auth().oauth2(accessToken)
                .get("/api/player/name/sven.haala");
        assertEquals(player.getStatusCode(), 200);
        User user = player.as(User.class);
        assertEquals(user.getUsername(), "sven.haala");
    }

    private JSONObject getUser() throws JSONException {
        JSONObject requestParams = new JSONObject();
        requestParams.put("firstName", vorname);
        requestParams.put("lastName", nachname);

        requestParams.put("password", "test");
        requestParams.put("geschlechtw", true);
        requestParams.put("admin", false);
        return requestParams;
    }


    @Test
    public void createUser() throws JSONException {
        RequestSpecification request = given().auth().oauth2(accessToken);
        request.header("Content-Type", "application/json");
        request.body(getUser().toString());
        Response response = request.post("/api/player");
        assertEquals(response.statusCode(), 200);
        User user = response.getBody().as(User.class);
        assertEquals(user.getUsername(), vorname.toLowerCase() + "." + nachname.toLowerCase());
        assertEquals(user.getFirstName(), vorname);
    }

    @Test
    public void doubleUsername() throws JSONException {
        RequestSpecification request = given().auth().oauth2(accessToken);
        request.header("Content-Type", "application/json");
        request.body(getUser().toString());
        Response response = request.post("/api/player");
        assertEquals(response.statusCode(), 200);
        User user = response.getBody().as(User.class);
        assertEquals(user.getUsername(), vorname.toLowerCase() + "." + nachname.toLowerCase() + 1);
        assertEquals(user.getFirstName(), vorname);
    }
}
