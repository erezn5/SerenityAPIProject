package testcases;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import steps.APISteps;

@RunWith(SerenityRunner.class)
public class DeleteUserTest extends BaseTest{
	
	@Steps
	APISteps api;
	
	@Title("Deleting user")
	@Test
	public void deleteUserTest() {
		api.sendDeleteRequestForUser("2");
		api.validateStatusCodeToBe(200);
		
	}
}
