package com.demo.utility;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.main.WebDriverManager;

public class Waits extends WebDriverManager{
	
	public static void explicitWaitVisiblity(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			System.out.println("wait timeout ....");
		}
	}

	public static void explicitWaitClickable(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (Exception e) {
			System.out.println("wait timeout");
		}
	}

	public static WebElement fluentWaitVisiblity(final By loc, int timeOut) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver webDriver) {
				return driver.findElement(loc);
			}
		});

	}

	public static void explicitWaitInvisiblity(WebElement ele) {
  try {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
  catch (Exception e) {
		System.out.println("wait timeout");
	}
  }


}
