package page.actions;

import com.prerak.automation.framework.BasePageActions;

import page.objects.SampleObjects;

public class SampleActions extends BasePageActions {

	public static void FirstName_action()	
	{

	    clear(SampleObjects.txtFirstName, "clear txtFirstName");
		sendkeys(SampleObjects.txtFirstName, "Anand","writing first name");
		waiting(200);
		clear(SampleObjects.txtLastName, "clear lastname");
		sendkeys(SampleObjects.txtLastName, "shukla","writing last name");
		waiting(200);
	}

	public static void Email_action() {

		clear(SampleObjects.txtEmail, "clear txtEmail");
		sendkeys(SampleObjects.txtEmail, "Anand.shukla6548", "writing Email");
		waiting(200);
	}

	public static void Password_action() {

		sendkeys(SampleObjects.txtPassword, "Anand@123", "writing password");
		waiting(200);
	}
	
	public static void conPassword_action() {

		sendkeys(SampleObjects.txtconPassword, "Anand@123", "writing confirm password");
		waiting(200);
	}


	public static void facebookSignUp_action() {

		click(SampleObjects.btnSignUp, "click on signup");
	}

}
