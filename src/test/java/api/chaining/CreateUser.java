package api.chaining;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.utils.Tokens;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

public class CreateUser implements Tokens {
	
	public ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("config");
		return routes;
	}

	@Test
	void test_createUser(ITestContext context) {
		
		String post_url = getURL().getString("GoRest_Post_Url");
		String get_url = getURL().getString("GoRest_Get_url");

		Faker faker = new Faker();

		JSONObject data = new JSONObject();

		data.put("name", faker.name().fullName());
		data.put("gender", "female");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");


		int id = given()
				.header("Authorization", "Bearer " + bearerToken)
				.contentType("application/json")
				.body(data.toString())

	    .when()
	    .post(post_url)
        .jsonPath().getInt("id");
		
		context.setAttribute("user_id", id);
		context.setAttribute("get_url", get_url);	
	}

}
