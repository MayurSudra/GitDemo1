package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prerak.automation.framework.Driver;

public class SampleObjects {
	
	@FindBy(xpath = "//input[@id='firstName']")
	public static WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	public static WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='username']")
	public static WebElement txtEmail;
	
	@FindBy(xpath = "//input[@name='Passwd']")
	public static WebElement txtPassword;
	
	@FindBy(xpath = "//input[@name='ConfirmPasswd']")
	public static WebElement txtconPassword;	

	
	@FindBy(xpath = "//span[@class='CwaK9']")
	public static WebElement btnSignUp;
	
	static {

		PageFactory.initElements(Driver.driver, SampleObjects.class);
	}
}
