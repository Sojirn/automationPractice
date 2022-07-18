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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.demo.utility.Utility;
import com.google.common.io.Files;

public class WebDriverManager {

	protected static WebDriver driver;

	public WebDriver launchBrowser() {

		if (driver != null) {
			return driver;
		}

		{
			Properties configFile = Utility.getPropertiesFile();
			String urltest = configFile.getProperty("url");
			String browserType = configFile.getProperty("browser");
			String userDir = System.getProperty("user.dir") + "/src/main/resources/";

			switch (browserType.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", userDir + "chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver", userDir + "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "mozilla":
				System.setProperty("webdriver.gecko.driver", userDir + "geckodriver.exe");
				driver = new FirefoxDriver();

			case "edge":
				System.setProperty("webdriver.edge.driver", userDir + "msedgedriver.exe");
				driver = new EdgeDriver();

			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

			driver.get(urltest);
			waitForPageLoad();
			retryWebUrl();

			return driver;
		}

	}

	public static WebDriver getdriver() {
		return driver;
	}
   
	
	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		WebDriverManager.driver = launchBrowser();
	}

	@AfterMethod
	public void failedscreenshots(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println("Test Failed " + result.getName());
			Screenshot(result.getName());
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
				Utility.waitfor(10);
				waitForPageLoad();
			}
		}
	}

	public void click(WebElement element) {
		Utility.waitfor(3);
		element.click();
	}

	public String getText(WebElement element) {
		Utility.waitfor(1);
		return element.getText();

	}

	public void sendText(WebElement element, String text) {
		Utility.waitfor(3);
		element.clear();
		element.sendKeys(text);
	}

	public String getAttribute(WebElement element, String attributename) {
		Utility.waitfor(3);
		return element.getAttribute(attributename);
	}

	public void elementClick(WebElement el) {
		el.click();
		waitForPageLoad();
	}

	public void Screenshot(String testName) throws IOException {
		String finaldate = java.time.Clock.systemUTC().instant().toString().replace(":", "_");

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		String extention = ".png";
		String filename = testName.concat("_" + finaldate).concat(extention);
		File DestFile = new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/" + filename);
		Files.copy(SrcFile, DestFile);
	}

	public void alertcheck(String option, String text) {
		Alert objalert = driver.switchTo().alert();
		switch (option.toLowerCase()) {
		case "dismiss":
			objalert.dismiss();
			break;

		case "accept":
			objalert.accept();
			break;

		case "text":
			objalert.sendKeys(text);
			objalert.accept();
			break;

		default:
			break;
		}
	}

	public void highlightelement(By value) {

		WebElement ele = driver.findElement(value);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// use executeScript() method and pass the arguments
		// Here i pass values based on css style. Yellow background color with solid red
		// color border.
		js.executeScript("arguments[0].setAttribute('style', 'background: brown; border: 2px solid red;');", ele);
	}
	// method implementation for similar locators

	public Select dropDown(WebElement value) {
		Select select = new Select(value);
		return select;
	}

	public void explicitWaitvisiblity(WebElement ele) {
		Utility.waitfor(3);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			System.out.println("wait timeout ....");
		}
	}

	public void explicitWaitClickable(WebElement ele) {
		Utility.waitfor(3);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (Exception e) {
			System.out.println("wait timeout");
		}
	}

	public WebElement fluentWaitvisiblity(final By loc, int timeOut) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver webDriver) {
				return driver.findElement(loc);
			}
		});

	}

	public void explicitWaitinvisiblity(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void Scroll(int a, int b) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + a + "," + b + ")");
	}

	public void waitForPageLoad() {
		Utility.waitfor(5);
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(pageLoadCondition);

	}

	public void Scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
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
	
	public Double getPrice(WebElement el) {
		return Double.parseDouble(el.getText().replace("$", ""));
	}

	public boolean isListContainsAttribute(List<WebElement> elements, String expected, String attribute) {
		boolean found = false;
		for (WebElement t : elements) {
			if (t.getAttribute(attribute).equals(expected)) {
				found = false;
			} else {
				found = true;
			}
		}
		return found;

	}
}