package rough;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class FirstTest {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost:8080";
		RestAssured.basePath ="/api/users/";
	}
	@Ignore
	@Title("Sending Get request test")
	@Test
	public void testGetRequest() {
		Response response = SerenityRest.given().when().log().all().get("4");
		response.prettyPrint();
		response.then().statusCode(200);
		response.then().body("firstName", Matchers.equalTo("Chris"));
	}
	
	@Title("Sending Post request test")
	@Test
	public void testPostRequest() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "danny@user.com");
		map.put("firstName", "Danny");
		map.put("lastName", "Rop");

		Response response = SerenityRest.given()
				.contentType(ContentType.JSON)
				.body(map).log().all().post();
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
	
	@Ignore
	@Title("Sending Delete request test")
	@Test
	public void testDeleteRequest() {
		Response response = SerenityRest.given().when().delete("10");
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		response.then().statusCode(200);
				
	}
	

}
