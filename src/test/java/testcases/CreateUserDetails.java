package testcases;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import steps.APISteps;

//@Concurrent(threads = "4x")
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(".\\src\\test\\resources\\testdata\\users.csv")
public class CreateUserDetails extends BaseTest {
	
	
	private String email;
	private String firstName;
	private String lastName;
	
	public void setEmail(String email) {
		this.email = email;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Steps
	APISteps api;
	
	
	@Title("Creating Multiple users test")
	@Test
	public void createUserTest() {
		api.sendPOSTRequest(email, firstName, lastName);
		api.validateStatusCodeToBe(201);
	}

}
