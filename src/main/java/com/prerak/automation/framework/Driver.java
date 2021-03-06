package com.prerak.automation.framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

	public static WebDriver driver;

	public static WebDriver getDriver(String Browsertype) throws Exception {

		if (Browsertype.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverWindow/chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.manage().window().setSize(new Dimension(1366, 768));
			Dimension dim = driver.manage().window().getSize();
			System.out.println(dim);
			driver.manage().window().maximize();
			return driver;

		} else if (Browsertype.equalsIgnoreCase("chromeHeadless")) {

			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverWindow/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--no-sandbox");
			// options.addArguments("--disable-setuid-sandbox");
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.manage().window().setSize(new Dimension(1366, 768));
			Dimension dim = driver.manage().window().getSize();
			System.out.println(dim);
			driver.manage().window().maximize();
			return driver;

		} else if (Browsertype.equalsIgnoreCase("Firefox")) {

			FirefoxOptions firefoxOptions = new FirefoxOptions();

			firefoxOptions.addArguments("window-size=1366x768");
			driver = new FirefoxDriver(firefoxOptions);
			Dimension dim = driver.manage().window().getSize();
			System.out.println(dim);
			return driver;

		} else {
			throw new Exception("Invalid driver type " + Browsertype + "!");
		}
			
	}

}
