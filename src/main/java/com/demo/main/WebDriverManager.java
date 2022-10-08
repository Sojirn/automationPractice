package com.demo.main;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.demo.utility.Utility;
import com.demo.utility.WebElementHandlers;
import com.google.common.io.Files;

public class WebDriverManager {

	protected static WebDriver driver;

	public WebDriver launchBrowser(String browser) {

		if (driver != null) {
			return driver;
		}

		Properties configFile = Utility.getPropertiesFile();
		String urltest = configFile.getProperty("url");
		if (browser.equals("fromConfig")) {
			browser = configFile.getProperty("browser");
		}
		String userDir = System.getProperty("user.dir") + "/src/main/resources/";

		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", userDir + "chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", userDir + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "mozilla":
			System.setProperty("webdriver.ge+cko.driver", userDir + "geckodriver.exe");
			driver = new FirefoxDriver();

		case "edge":
			System.setProperty("webdriver.edge.driver", userDir + "msedgedriver.exe");
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		driver.get(urltest);
		retryWebUrl();
		waitForPageLoad();
		retryWebUrl();

		return driver;

	}

	public WebDriver getdriver() {
		return driver;
	}

	@Parameters({ "Browser" })
	@BeforeTest(alwaysRun = true)
	public void beforeTest(@Optional("fromConfig") String browser) {
		this.driver = launchBrowser(browser);
	}

	@AfterMethod
	public void failedscreenshots(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println("Test Failed " + result.getName());
			Utility.screenshot(result.getName());
	}

	}

	public void retryWebUrl() {
		for (int it = 0; it < 5; it++) {
			try {
				if (driver.findElement(By.id("index")).isDisplayed()) {
					break;
				}
			} catch (Exception e) {
				driver.navigate().refresh();
				waitForPageLoad();
			}
		}
	}

	

	


	public static void scroll(int a, int b) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + a + "," + b + ")");
	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static  void waitForPageLoad() {
		
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(pageLoadCondition);

	}


	public boolean isListContainsText(List<WebElement> elements, String expected) {
		boolean found = false;
		for (WebElement t : elements) {
			String te = t.getText();
			if (te.equalsIgnoreCase(expected)) {
				found = true;
				break;
			}
		}
		return found;
	}

	

	public boolean isListContainsAttribute(List<WebElement> elements, String expected, String attribute) {
		boolean found = false;
		for (WebElement t : elements) {
			if (t.getAttribute(attribute).equals(expected)) {
				found = true;
				break;
			} else {
				found = false;
			}
		}
		return found;

	}
}