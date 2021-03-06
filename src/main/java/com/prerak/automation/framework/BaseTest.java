package com.prerak.automation.framework;

import java.io.File;
import java.lang.reflect.Method;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {

	public String configFilePath;
	public static ReadPropertiesFile property;
	public static String NameOfModule;
	public static String url;
	public static WebDriver driver;
	public static String reportDirPath;
	public static String screenshotDirPath;
	
	public static ExtentReports report;
	public static String report_date;
	public static ExtentTest extentTest;
	public static WebDriverWait wait;
	
	@Parameters({ "moduleName" })
	@BeforeSuite
	public void setup(String moduleName) throws Exception {

		System.out.println("xml name is " + moduleName);

		configFilePath = new File("config/config.properties").getAbsolutePath();
		System.out.println("config file path is " + configFilePath);

		property = new ReadPropertiesFile(configFilePath);

		NameOfModule = StringUtils.substringBefore(moduleName, ".");
		System.out.println("module is " + NameOfModule);
		
		url = property.getProperty(NameOfModule);
		String browser = property.getProperty("browser");
		
		report_date = BasePageActions.currentTime();
		System.out.println("report_date "+report_date);
		
		screenshotDirPath = new File("./screenshot/" + NameOfModule + "/").getAbsolutePath();
		
		reportDirPath =  new File("./report/" + NameOfModule + "/").getAbsolutePath();
		System.out.println("reportDirPath "+reportDirPath);
		
		
		report = Reports.getReports(reportDirPath+"/");
		report.addSystemInfo("Environment", url);
		
		driver = Driver.getDriver(browser);
		driver.get(url);
		System.out.println("url is "+ url);	
		
		wait = new WebDriverWait(driver, 3);
	}
	
	
	@BeforeClass
	public void beforeclass() {
		
		String className = this.getClass().getSimpleName();
		System.out.println("className "+className);		
	}
	
	
	@BeforeMethod
	public void nameBefore(Method method) {
		
		extentTest = report
				.startTest(
						method.getName(),
						method.getAnnotation(org.testng.annotations.Test.class)
								.description())
				.assignCategory(
						method.getAnnotation(org.testng.annotations.Test.class)
								.groups())
				.assignAuthor("Mayur");		
		
		System.out.println("You are in method "+method.getName());
		
	}
	
	
	@AfterMethod
	public void afterMethod(Method method) {
		report.endTest(extentTest);
		report.flush();
	}
	
	
	@AfterSuite
	public void tearDown() throws Exception{
		
		driver.quit();
	}

}