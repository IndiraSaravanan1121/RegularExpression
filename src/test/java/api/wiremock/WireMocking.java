package api.wiremock;

import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.*;

import com.github.tomakehurst.wiremock.*;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class WireMocking {
	
	private static final int PORT = 8080;
	private static final String HOST = "localhost";	
	private static WireMockServer server = new WireMockServer(PORT);
	
	@BeforeClass
	public static void setup() {
		
		ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
		mockResponse.withStatus(200);		
		
		server.start();
		WireMock.configureFor(HOST, PORT);
		WireMock.stubFor(WireMock.get("/get/users/2")
		.willReturn(mockResponse));
		}
	
	@Test
	void testGetWiremock() throws URISyntaxException {
		RestAssured.given()
		.when()
		.get(new URI("http://localhost:8080/get/users/2"))
		.then()
		.assertThat()
		.statusCode(200);
	}
	
	@AfterClass
	void tearDown() {
		if(null != server && server.isRunning()) {
			server.shutdownServer();
		}
	}
}
