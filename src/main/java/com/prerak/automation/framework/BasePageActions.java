package com.prerak.automation.framework;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;

public class BasePageActions extends BaseTest {

	public static void click(WebElement element, String description) {

		try {
			waiting(300);
			waitForPageLoadComplete();

			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOf(element));

			highlightElement(element);
			JavascriptExecutor Executor = ((JavascriptExecutor) driver);
			Executor.executeScript("arguments[0].click();", element);
			extentTest.log(LogStatus.PASS, description);
//			System.out.println("click done by javascript");

		} catch (NoSuchElementException e) {

			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			takeScreenshot(description);
			extentTest.log(LogStatus.FAIL, description);

		} catch (StaleElementReferenceException e) {

			try {

				System.out.println("StaleElementReferenceException block");
				waiting(1000);
				wait.until(ExpectedConditions.stalenessOf(element));
				JavascriptExecutor Executor = ((JavascriptExecutor) driver);
				Executor.executeScript("arguments[0].click();", element);
				extentTest.log(LogStatus.PASS, description);
				System.out.println("click done by javascript");

			} catch (Exception e2) {

				try {

					JavascriptExecutor Executor = ((JavascriptExecutor) driver);
					Executor.executeScript("arguments[0].click();", element);
					extentTest.log(LogStatus.PASS, description);
//					System.out.println("click done by javascript");

				} catch (Exception e3) {

					try {

						element.click();
						System.out.println("click done by selenium");
						extentTest.log(LogStatus.PASS, description);

					} catch (Exception e4) {

						extentTest.log(LogStatus.FAIL, "Action is not perfomed " + description);
						takeScreenshot(description);
						System.out.println("Action not perfomed" + description);
						e4.getMessage();

					}
				}
			}
		} catch (Exception e) {

			try {

				JavascriptExecutor Executor = ((JavascriptExecutor) driver);
				Executor.executeScript("arguments[0].click();", element);
				extentTest.log(LogStatus.PASS, description);
//				System.out.println("click done by javascript");

			} catch (Exception e2) {

				try {

					element.click();
					extentTest.log(LogStatus.PASS, description);
					System.out.println("click done by selenium");

				} catch (Exception e3) {

					System.out.println("Action not perfomed" + description);
					e3.getMessage();
					extentTest.log(LogStatus.FAIL, description);
					takeScreenshot(description);

				}
			}
		}

	}

	public static void click(List<WebElement> elements, int index, String description) {

		try {
			waiting(300);
			waitForPageLoadComplete();
			wait.until(ExpectedConditions.elementToBeClickable(elements.get(index)));
			wait.until(ExpectedConditions.visibilityOf(elements.get(index)));

			highlightElement(elements.get(index));
			JavascriptExecutor Executor = ((JavascriptExecutor) driver);
			Executor.executeScript("arguments[0].click();", elements.get(index));
			extentTest.log(LogStatus.PASS, description);
//			System.out.println("click done by javascript");

		} catch (NoSuchElementException e) {

			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			takeScreenshot(description);
			extentTest.log(LogStatus.FAIL, description);

		} catch (StaleElementReferenceException e) {

			try {

				System.out.println("StaleElementReferenceException block");
				waiting(1000);
				wait.until(ExpectedConditions.stalenessOf(elements.get(index)));
				JavascriptExecutor Executor = ((JavascriptExecutor) driver);
				Executor.executeScript("arguments[0].click();", elements.get(index));
				extentTest.log(LogStatus.PASS, description);
				System.out.println("click done by javascript");

			} catch (Exception e2) {

				try {

					JavascriptExecutor Executor = ((JavascriptExecutor) driver);
					Executor.executeScript("arguments[0].click();", elements.get(index));
					extentTest.log(LogStatus.PASS, description);
//					System.out.println("click done by javascript");

				} catch (Exception e3) {

					try {

						elements.get(index).click();
						System.out.println("click done by selenium");
						extentTest.log(LogStatus.PASS, description);

					} catch (Exception e4) {

						extentTest.log(LogStatus.FAIL, "Action is not perfomed " + description);
						takeScreenshot(description);
						System.out.println("Action not perfomed" + description);
						e4.getMessage();

					}
				}
			}
		} catch (Exception e) {

			try {

				JavascriptExecutor Executor = ((JavascriptExecutor) driver);
				Executor.executeScript("arguments[0].click();", elements.get(index));
				extentTest.log(LogStatus.PASS, description);
//				System.out.println("click done by javascript");

			} catch (Exception e2) {

				try {

					elements.get(index).click();
					extentTest.log(LogStatus.PASS, description);
					System.out.println("click done by selenium");

				} catch (Exception e3) {

					System.out.println("Action not perfomed" + description);
					e3.getMessage();
					extentTest.log(LogStatus.FAIL, description);
					takeScreenshot(description);

				}
			}
		}

	}

	public static void sendkeys(WebElement element, String value, String description) {

		try {

			waiting(300);
			waitForPageLoadComplete();
			element.sendKeys(value);
			extentTest.log(LogStatus.PASS, description);

		} catch (NoSuchElementException e) {

			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + element + " - " + description);
			takeScreenshot(description);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println("element not found :  " + element + " - " + description);
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);

		}
	}

	public static void sendkeys(List<WebElement> elements, int index, String value, String description) {

		try {

			waiting(300);
			waitForPageLoadComplete();
			elements.get(index).sendKeys(value);
			extentTest.log(LogStatus.PASS, description);

		} catch (NoSuchElementException e) {

			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + elements + " - " + description);
			takeScreenshot(description);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println("element not found :  " + elements + " - " + description);
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);
		}
	}

	public static void clear(WebElement element, String description) {
		try {

			waiting(300);
			waitForPageLoadComplete();
			highlightElement(element);
			element.clear();
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {

			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + element + description);
			takeScreenshot(description);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found" + element + description);
			takeScreenshot(description);
		}
	}

	public static void selectByIndexDropDown(WebElement element, int selectIndex, String description) {
		try {

			waiting(300);
			waitForPageLoadComplete();
			highlightElement(element);
			element.isEnabled();
			Select select = new Select(element);
			select.selectByIndex(selectIndex);
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + element + description);
			takeScreenshot(description);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);
		}
	}
	
	public static void selectByValueDropDown(WebElement element, String selectValue, String description) {
		try {

			waiting(300);
			waitForPageLoadComplete();
			highlightElement(element);
			element.isEnabled();
			Select select = new Select(element);
			select.selectByValue(selectValue);
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + element + description);
			takeScreenshot(description);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);
		}
	}

	// some get methotds

	public static String getText(WebElement element, String description) {

		String text = null;
		try {
			text = element.getText();
			extentTest.log(LogStatus.PASS, description);

		} catch (NoSuchElementException e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);

		} catch (StaleElementReferenceException e) {

			try {
				System.out.println("StaleElementReferenceException");
				waiting(1000);
				wait.until(ExpectedConditions.stalenessOf(element));
				text = element.getText();

				extentTest.log(LogStatus.PASS, description);
			} catch (Exception e1) {
				extentTest.log(LogStatus.FAIL, description);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);

		}
		return text;
	}

	public static String getText(List<WebElement> elements, int index, String description) {

		String text = null;
		try {
			text = elements.get(index).getText();
			extentTest.log(LogStatus.PASS, description);

		} catch (NoSuchElementException e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);

		} catch (StaleElementReferenceException e) {

			try {
				System.out.println("StaleElementReferenceException");
				waiting(1000);
				wait.until(ExpectedConditions.stalenessOf(elements.get(index)));
				text = elements.get(index).getText();

				extentTest.log(LogStatus.PASS, description);
			} catch (Exception e1) {
				extentTest.log(LogStatus.FAIL, description);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);

		}
		return text;
	}

	public static String getAttribute(WebElement element, String attribute, String description) {

		String value = null;

		try {
			value = element.getAttribute(attribute);
			System.out.println("stored text is " + value);
			extentTest.log(LogStatus.PASS, description);

		} catch (NoSuchElementException e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found" + element + description);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
		}
		return value;
	}

	public static int getElementSize(List<WebElement> elements, String description) {
		int size = 0;

		try {
			System.out.println("element size is  " + elements.size());
			size = elements.size();
		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);
		}
		return size;
	}

	// Verify methods

	public static void verifyText(WebElement element, String value, String description) {

		try {

			waiting(300);
			waitForPageLoadComplete();

			wait.until(ExpectedConditions.visibilityOf(element));

			highlightElement(element);

			String actual = element.getText().trim();

			if (actual.equalsIgnoreCase(value)) {
				extentTest.log(LogStatus.PASS, description);

			} else {
				extentTest.log(LogStatus.FAIL, description);
				System.out.println("text not matched :  " + description);
				System.out.println(actual + "  not equals  " + value);
				takeScreenshot(description);
			}
		} catch (NoSuchElementException e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);

		} catch (Exception e) {

			try {
				String actual = element.getText();

				if (actual.equalsIgnoreCase(value)) {
					extentTest.log(LogStatus.PASS, description);

				} else {

					extentTest.log(LogStatus.FAIL, description);
					System.out.println("text not matched :  " + description);
					System.out.println(actual + "  not equals  " + value);
					takeScreenshot(description);
				}

			} catch (Exception e1) {

				System.out.println(e.getMessage());
				extentTest.log(LogStatus.FAIL, description);
				takeScreenshot(description);
			}
		}
	}

	public static void verifyText(List<WebElement> elements, int index, String value, String description) {

		try {

			waiting(300);
			waitForPageLoadComplete();

			wait.until(ExpectedConditions.visibilityOf(elements.get(index)));

			highlightElement(elements.get(index));

			String actual = elements.get(index).getText().trim();

			if (actual.equalsIgnoreCase(value)) {
				extentTest.log(LogStatus.PASS, description);

			} else {
				extentTest.log(LogStatus.FAIL, description);
				System.out.println("text not matched :  " + description);
				System.out.println(actual + "  not equals  " + value);
				takeScreenshot(description);
			}
		} catch (NoSuchElementException e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);

		} catch (Exception e) {

			try {
				String actual = elements.get(index).getText();

				if (actual.equalsIgnoreCase(value)) {
					extentTest.log(LogStatus.PASS, description);

				} else {

					extentTest.log(LogStatus.FAIL, description);
					System.out.println("text not matched :  " + description);
					System.out.println(actual + "  not equals  " + value);
					takeScreenshot(description);
				}

			} catch (Exception e1) {

				System.out.println(e.getMessage());
				extentTest.log(LogStatus.FAIL, description);
				takeScreenshot(description);
			}
		}
	}

	public static void verifyElementSize(List<WebElement> elements, int actual_size, String description) {
		try {

			waiting(500);
			waitForPageLoadComplete();
			System.out.println("element size is  " + elements.size());
			int size = elements.size();

			if (size == actual_size) {
				extentTest.log(LogStatus.PASS, description);
			} else {
				extentTest.log(LogStatus.FAIL, description);
				System.out.println(size + "is not equals" + actual_size);
				takeScreenshot(description);
			}

		} catch (NoSuchElementException e) {

			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);
		}
	}

	public static String verifyCurrentUrl(String urlExpected, String description) {

		String actual = null;
		try {
			waitForPageLoadComplete();

			actual = driver.getCurrentUrl();

			if (actual.equals(urlExpected)) {

				extentTest.log(LogStatus.PASS, description);
				return actual;

			} else {

				extentTest.log(LogStatus.FAIL, description);
				System.out.println("URL not  matched");
				takeScreenshot(description);
			}
		} catch (NoSuchElementException e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);
		}
		return actual;
	}

	public static String verifyPageTittle(String titleExpected, String description) {
		String title = null;
		try {
			waitForPageLoadComplete();

			title = driver.getTitle();
			if (title.equalsIgnoreCase(titleExpected)) {
				extentTest.log(LogStatus.PASS, description);

			} else {
				extentTest.log(LogStatus.FAIL, description);
				System.out.println("text not  matched");
				takeScreenshot(description);

				System.out.println("text not matched :  " + description);
				System.out.println(title + "  not equals to " + titleExpected);
				takeScreenshot(description);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("element not found " + description);
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);
		}
		return title;
	}

	// navigate methods

	public static void pageRefresh() {

		try {

			driver.navigate().refresh();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	public static void navigateToPage(String url, String description) {
		try {

			driver.navigate().to(url);
			String value = driver.getCurrentUrl();
			System.out.println("Navigated to url : " + value);
			extentTest.log(LogStatus.PASS, description);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);
		}
	}

	public static void navigateForward(String description) {
		try {

			driver.navigate().forward();
			extentTest.log(LogStatus.PASS, description);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);
		}
	}

	public static void navigateBack(String description) {
		try {

			driver.navigate().back();

			extentTest.log(LogStatus.PASS, description);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);
		}
	}

	public static void switchToFrame(WebElement locator) {
		try {

			Driver.driver.switchTo().frame(locator);

		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, "Switch to frame");
			takeScreenshot("fail to switch");
		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, "switch to frame");
			takeScreenshot("fail to switch");
		}
	}

	public static void switchToFrame(String frameId) {
		try {

			driver.switchTo().frame(frameId);
			extentTest.log(LogStatus.INFO, "Switch to frame");

		} catch (NoSuchElementException e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, "Switch to frame");
			takeScreenshot("fail to switch");
		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, "switch to frame");
			takeScreenshot("fail to switch");
		}
	}

	public static void switchToDefaultFrame() {
		try {

			Driver.driver.switchTo().defaultContent();

		} catch (NoSuchElementException e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, "Switch to frame");
			takeScreenshot("switch to default frame");

		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, "switch to frame");
			takeScreenshot("switch to default frame");
		}
	}

	public static void dragAndDrop(WebElement element1, WebElement element2, String description) {

		try {

			waitForPageLoadComplete();
			Actions action = new Actions(driver);
			waiting(300);
			action.dragAndDrop(element1, element2).perform();
			extentTest.log(LogStatus.PASS, description);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);
		}
	}

	// other usefull methods

	public static void ENTERKEY(String description) {
		try {

			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			extentTest.log(LogStatus.PASS, description);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println("Action Not Performed" + description);
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(description);

		}
	}

	public static void doubleClick(WebElement element, String description) {
		try {

			waitForPageLoadComplete();
			highlightElement(element);
			element.isEnabled();
			Actions action = new Actions(driver);
			action.moveToElement(element);
			action.doubleClick(element).build().perform();
			extentTest.log(LogStatus.PASS, description);

		} catch (NoSuchElementException e) {

			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + element + description);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);

		}
	}

	public static void waiting(int timeInMiliSecond) {

		try {
			Thread.sleep(timeInMiliSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitForPageLoadComplete() {

		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 4);
			wait.until(
					driver -> String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
							.equals("complete"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void highlightElement(WebElement element) {
		try {

			if (Driver.driver instanceof JavascriptExecutor) {
				((JavascriptExecutor) Driver.driver).executeScript("arguments[0].style.border='3px solid red'",
						element);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// return element;
	}

	public static void takeScreenshot(String description) {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(BaseTest.screenshotDirPath + "/" + description + ".jpg"));
			System.out.println("screenshot taken");

		} catch (Exception e) {
			System.out.println("got exeception in screenshoot method");

		}
	}

	public static String currentTime() {
		String report_date = null;
		try {

			DateFormat dateFormat = new SimpleDateFormat("E-yyyy-MM-dd-'at'-hh-mma");
			Date date = new Date();
			dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
			report_date = dateFormat.format(date).toLowerCase();

		} catch (Exception e) {

			System.out.println("Exception in currentTime");
		}

		return report_date;
	}
}
