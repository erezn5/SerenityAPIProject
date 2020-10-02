package steps;

import java.util.HashMap;

import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences.PRINT_SCALING;
import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import jnr.ffi.Struct.int16_t;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class APISteps {
	
	private Response response;
	
	@Step("Send Get Request for user id: {0}")
	public void sendGetRequestForUser(String userId) {
		response = SerenityRest.given().when().log().all().get(userId);
		response.prettyPrint();
		//New Code Added
	}
	
	@Step("Send Post Request for user created with email: {0}, firstname{1} and lastname {2}")
	public void sendPOSTRequest(String email, String firstName, String lastName) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("firstName", firstName);
		map.put("lastName", lastName);

		Response response = SerenityRest.given()
				.contentType(ContentType.JSON).log().all()
				.body(map).log().all().post();
		response.prettyPrint();
		System.out.println("Status code is: " + response.getStatusCode());
	}
	
	@Step("Send Delete Request for user id: {0}")
	public void sendDeleteRequestForUser(String userId) {
		response = SerenityRest.given().when().delete(userId);
		response.prettyPrint();
	}
	
	@Step("Validate status code to be {0}")
	public void validateStatusCodeToBe(int code) {
		
		response.then().statusCode(code);
	}
	
	@Step("Verify response body for key {0} and value {1}")
	public void verifyResponseBody(String key, String value) {
		response.then().body(key, Matchers.equalTo(value));
	}

}
