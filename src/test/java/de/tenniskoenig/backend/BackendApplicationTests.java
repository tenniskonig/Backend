package de.tenniskoenig.backend;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.requestContentType;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BackendApplicationTests {
	@LocalServerPort
	private int port;

	String accessToken;
	Logger logger = Logger.getLogger(BackendApplicationTests.class.getName());

	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
	}


	@Test
	public void authFail() throws JSONException {
		boolean temp = login("sven.haala", "jwtpss");
		assertEquals(temp, false);
	}

	@Test
	public void authSuccess() throws JSONException {
		boolean temp = login("sven.haala", "jwtpass");
		assertEquals(temp, true);
	}


	private boolean login(String username, String password) {
		logger.info("Port is: "+ port);
		logger.info("Getting OAuth Token from server - {}"+ RestAssured.baseURI);
		Response response =
				given().auth().preemptive().basic("tennisClientID", "KADFgni46agPQ")
                .formParam("grant_type", "password")
				.formParam("username", username)
				.formParam("password", password)
				.formParam("scope", "read").when()
				.post("/oauth/token");

		JSONObject jsonObject = null;
		try {
			if(response.getStatusCode()==200){
				jsonObject = new JSONObject(response.getBody().asString());
				accessToken = jsonObject.get("access_token").toString();
				logger.info("Oauth Token for " + username + " is " + accessToken);
				return true;
			}
			if(response.getStatusCode()==400)
			{
				return false;
			}
		} catch (JSONException e) {

		}
		return false;
	}
}


