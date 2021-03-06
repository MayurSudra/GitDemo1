package tests;

import org.testng.annotations.Test;

import page.actions.SampleActions;

public class SampleTest extends SampleActions {

	@Test(priority = 1, enabled = true)
	public static void facebookName() {

		FirstName_action();
	}

	@Test(priority = 2, enabled = true)
	public static void facebookMobileNumber() {

		Email_action();
	}

	@Test(priority = 3, enabled = true)
	public static void facebookSPassword() {

		Password_action();
	}
	
	@Test(priority = 4, enabled = true)
	public static void facebookconpassword() {

		conPassword_action();		
	}

	@Test(priority = 5, enabled = true)
	public static void facebookSignUp() {

		facebookSignUp_action();
	}

}
