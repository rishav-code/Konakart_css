package it.pkg.testbase;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import it.pkg.constants.FilePath;
import it.pkg.util.ReadProp;

public class TestBase {

	Properties baseClass;
	String url;
	public static WebDriver driver;
	public static String browser;
	int downloadFile;
	public static String normal;
	String nodeUrl;

	ReadProp property = new ReadProp();

	@BeforeSuite
	public void intitailizeBrowser() throws IOException {

		baseClass = ReadProp.loadProperty(FilePath.CONFIG_FILE);
		url = baseClass.getProperty("url");
		browser = baseClass.getProperty("browser");
		normal = baseClass.getProperty("normal");

		if (normal.equalsIgnoreCase("normal")) {
			System.out.println("browser is " + browser);

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FilePath.CHROME_PATH);

				driver = new ChromeDriver();
				driver.get(url);
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FilePath.FIREFOX_PATH);
				driver = new FirefoxDriver();
				driver.get(url);
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.edge.driver", FilePath.IE_PATH);
				DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
				ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
				driver = new InternetExplorerDriver(ieCaps);
			}

		} else if (normal.equalsIgnoreCase("grid")) {
			System.out.println("Grid connection");
			
			WebDriver drv =Grid.getConnection(driver, browser);
			TestBase.driver=drv;
			driver.get(url);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
//	@AfterTest()
//	public void end() {
//		driver.quit();
//	}

}
