package testcases;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import steps.APISteps;

@RunWith(SerenityRunner.class)
public class GetUserTest extends BaseTest{
	
	@Steps
	APISteps api;
	
	@Title("Getting the user details")
	@Test
	public void getUserTest() {
		api.sendGetRequestForUser("1");
		api.validateStatusCodeToBe(200);
		api.verifyResponseBody("firstName", "Rahul");
	}

}
