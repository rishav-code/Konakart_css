#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.helper;

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

import ${package}.constants.TimeOut;
import ${package}.testbase.TestBase;

public class CommonUtlity extends TestBase {
	public static void clickElement(final String xpath) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(1))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.click();
				return true;
			}

		});
	}

	

	public static void selectDropdown(final String xpath, int timeOut, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(1))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				Select select = new Select(element);

				select.selectByVisibleText(text);
				return true;
			}

		});
	}

	public static void clickAndSendText(final String xpath, int timeOutInSeconds, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(1))
				.withTimeout(Duration.ofSeconds(30));

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.sendKeys(text);
				;
				return true;
			}
		});
	}

	public static void clickOnElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOut.TIMEOUT_INSECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();

	}

	public static String getText(final String xpath) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(ElementClickInterceptedException.class);

		return fluentWait.until(new Function<WebDriver, String>() {
			public String apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				String text = element.getText();
				return text;
			}

		});
	}

	public static WebElement getElementAndSendText(String xpath, String text) {

		WebElement element = driver.findElement(By.xpath(xpath));
		element.sendKeys(text);
		return element;
	}

	public static boolean isDisplayed(String XPathIsDisplayed) {
		boolean isDisplayed = false;
		try {
			isDisplayed = driver.findElement(By.xpath(XPathIsDisplayed)).isDisplayed();
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	public static boolean isElementVisible(String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {

			return false;
		}
		return true;
	}

	public static List<WebElement> getElementsList(final String xpath) {

		List<WebElement> element = driver.findElements(By.xpath(xpath));
		return element;
	}

	public static void scrollDownPage(int byResolution) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scroll = "window.scrollBy(0," + byResolution + ")";
		js.executeScript(scroll);

	}

	public static WebElement getTheElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOut.TIMEOUT_INSECONDS);
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public static WebElement getElement(String xpath) {

		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public static void clearTextData(final String xpath) {

		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(1))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.clear();
				return true;
			}
		});
	}

	public static List<WebElement> getElementsList(WebDriver driver, final String xpath) {

		List<WebElement> element = driver.findElements(By.xpath(xpath));
		return element;
	}

	public static boolean isSelected(String XPathIsSelected) {
		boolean isSelected = false;
		try {
			isSelected = driver.findElement(By.xpath(XPathIsSelected)).isSelected();
		} catch (Exception e) {
			isSelected = false;
		}
		return isSelected;
	}

public static void scrollIntoview(String xpath) {
WebElement element = driver.findElement(By.xpath(xpath));
JavascriptExecutor je = (JavascriptExecutor) driver;
je.executeScript("arguments[0].scrollIntoView(true);", element);
}
public static void selectDropdownByIndex(final String xpath, final int index) {
	FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(2))
			.withTimeout(Duration.ofSeconds(30));
	fluentWait.until(new Function<WebDriver, Boolean>() {
		public Boolean apply(WebDriver driver) {
			WebElement element = driver.findElement(By.xpath(xpath));
			Select trip = new Select(element);

			trip.selectByIndex(index);
			return true;
		}

	});
}

}
