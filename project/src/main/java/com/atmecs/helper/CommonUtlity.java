package com.atmecs.helper;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.constants.TimeOut;
import com.atmecs.testbase.TestBase;

public class CommonUtlity extends TestBase {
	static WebElement element;

	public static WebElement selectloc(String loc) {
		String[] ar = loc.split(":", 2);
		
		switch (ar[0]) {
		case "id":
			element = driver.findElement(By.id(ar[1]));

			break;
		case "name":
			element = driver.findElement(By.name(ar[1]));

			break;
		case "class":
			element = driver.findElement(By.className(ar[1]));

			break;
		case "linktext":
			element = driver.findElement(By.linkText(ar[1]));

			break;
		case "partiallinktext":
			element = driver.findElement(By.partialLinkText(ar[1]));

			break;
		case "tagname":
			element = driver.findElement(By.tagName(ar[1]));

			break;
		case "css":
			element = driver.findElement(By.cssSelector(ar[1]));

			break;
		case "xpath":
			element = driver.findElement(By.xpath(ar[1]));

			break;

		}
		return element;

	}

	public static void clickElement(final String loc) {
		try {

			FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(1))
					.withTimeout(Duration.ofSeconds(30));
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					selectloc(loc);
					element.click();
					return true;
				}

			});
		} catch (Exception e) {
			System.out.println();

		}
	}

	public static void selectDropdown(final String loc, int timeOut, final String text) {
		try {

			FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(1))
					.withTimeout(Duration.ofSeconds(30));
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					selectloc(loc);
					Select select = new Select(element);

					select.selectByVisibleText(text);
					return true;
				}

			});
		} catch (Exception e) {
			System.out.println();


		}
	}

	public static void clickAndSendText(final String loc, int timeOutInSeconds, final String text) {
		try {

			FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(1))
					.withTimeout(Duration.ofSeconds(30));

			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					selectloc(loc);
					element.sendKeys(text);
					;
					return true;
				}
			});
		} catch (Exception e) {
			System.out.println();


		}
	}

	public static void clickOnElement(String loc) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, TimeOut.TIMEOUT_INSECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc)));
			selectloc(loc);
			element.click();

		} catch (Exception e) {
			System.out.println();


		}
	}

	public static String getText(final String loc) {
	 String text = null;
		try {

					selectloc(loc);
					text = element.getText();
					
					
				}

			
		catch (Exception e) {

		}
		return text;
	}

	public static WebElement getElementAndSendText(String loc, String text) {
		try {

			selectloc(loc);
			element.sendKeys(text);

		} catch (Exception e) {
			System.out.println();

		}
		return element;
	}

	public static boolean isDisplayed(String loc) {
		boolean isDisplayed = false;
		try {
			selectloc(loc);
			isDisplayed = element.isDisplayed();

		} catch (Exception e) {
			System.out.println();
			isDisplayed = false;
		}
		return isDisplayed;
	}

	public static boolean isElementVisible(String loc) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			selectloc(loc);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception exception) {
			System.out.println();

			return false;
		}
		return true;
	}

	public static List<WebElement> getElementsList(final String locator) {
		String[] loc=locator.split(":");
		List<WebElement> element = null;
		try {
			
		if(loc[0].toUpperCase().equalsIgnoreCase("CSS")) {
			element = driver.findElements(By.cssSelector(loc[1]));
		}
		else {
			element = driver.findElements(By.xpath(loc[1]));
		}
		
		
	}catch(Exception e) {
		System.out.println();
		
	}
		
		return  element;
	}

	public static void scrollDownPage(int byResolution) {
		try {
			
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scroll = "window.scrollBy(0," + byResolution + ")";
		js.executeScript(scroll);

	}
		catch(Exception e) {
			System.out.println();
		}
	}

	public static WebElement getTheElement(String xpath) {
		WebElement element = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, TimeOut.TIMEOUT_INSECONDS);
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
		element = driver.findElement(By.xpath(xpath));
		
	}
		catch(Exception e) {
			
		}
		return element;
	}

	public static WebElement getElement(String loc) {
		try {
			
		

		selectloc(loc);
		
	}catch(Exception e) {
		System.out.println();
	}
		return element;
		
	}

	public static void clearTextData(final String loc) {
		try {
			
		

		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(1))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				selectloc(loc);
				element.clear();
				return true;
			}
		});
	}
		catch(Exception e) {
			System.out.println();
		}
	}

	public static List<WebElement> getElementsList(WebDriver driver, final String xpath) {
		List<WebElement> elements = null;
		try {
			
		

		elements = driver.findElements(By.xpath(xpath));
		
	}catch(Exception e) {
		System.out.println();
		
	}
		return elements;
	}

	public static boolean isSelected(String loc) {
		boolean isSelected = false;
		try {
			selectloc(loc);
			element.isSelected();
		} catch (Exception e) {
			isSelected = false;
		}
		return isSelected;
	}

	public static void scrollIntoview(String xpath) {
		try {

			WebElement element = driver.findElement(By.xpath(xpath));
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {

		}
	}

	public static void selectDropdownByIndex(final String loc, final int index) {
		try {

			FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(2))
					.withTimeout(Duration.ofSeconds(30));
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					selectloc(loc);
					Select trip = new Select(element);

					trip.selectByIndex(index);
					return true;
				}

			});
		} catch (Exception e) {

		}

	}
}
