package com.demo.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.demo.main.WebDriverManager;
import com.google.common.io.Files;

public class WebElementHandlers extends WebDriverManager{
	public static  void click(WebElement element) {
		
		element.click();
	}

	public static String getText(WebElement element) {
		
		return element.getText();

	}

	public static void sendText(WebElement element, String text) {
	
		element.clear();
		element.sendKeys(text);
	}

	public static String getAttribute(WebElement element, String attributename) {
		
		return element.getAttribute(attributename);
	}

	public static void elementClick(WebElement el) {
		el.click();
		waitForPageLoad();
	}

	public static  void actionsMove(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static  void actionsClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	

	public static void alertcheck(String option, String text) {
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

	public static Select dropDown(WebElement value) {
		Select select = new Select(value);
		return select;
	}
}
