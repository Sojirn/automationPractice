package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.main.WebDriverManager;
import com.demo.pages.LoginPage;
import com.demo.utility.Utility;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CreateAccountTest extends WebDriverManager {
	LoginPage objLoginPage;

	@Test(priority = 1, enabled = true, groups = { "smoke" })
	public void Createaccountvalid() {
		objLoginPage = new LoginPage(driver);
		click(objLoginPage.signIn);
		waitForPageLoad();
		explicitWaitvisiblity(objLoginPage.createEmail);
		String enteredEmail = Utility.getRandomEmail();
		sendText(objLoginPage.createEmail, enteredEmail);
		click(objLoginPage.createAccount);
		Utility.waitfor(15);
		String displayedEmail = getAttribute(objLoginPage.email, "Value");
		Assert.assertTrue(enteredEmail.equals(displayedEmail));

	}

	@Test(priority = 2, enabled = true, groups = { "smoke" })
	public void createaccountvalidation() {
		boolean found = false;
		objLoginPage = new LoginPage(driver);
		click(objLoginPage.gender);
		sendText(objLoginPage.firstName, "Soji");
		sendText(objLoginPage.secondName, "Satheesh");
		sendText(objLoginPage.accntPassword, "Ucs@1234");
		dropDown(objLoginPage.days).selectByValue("3");
		dropDown(objLoginPage.months).selectByValue("3");
		dropDown(objLoginPage.years).selectByValue("2020");
		click(objLoginPage.newsletter);
		sendText(objLoginPage.postcode, "00");
		click(objLoginPage.register);
		explicitWaitvisiblity(objLoginPage.error);
		String expected = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
		List<WebElement> errors = objLoginPage.errorList;
		for (WebElement test : errors) {
			if (test.getText().contains(expected)) {
				System.out.println(test.getText());
				found = true;
				break;
			} else {
				found = false;
			}
		}
		Assert.assertTrue(found);

	}

	@Test(priority = 3, enabled = true, groups = { "smoke" })
	public void createaccount() {
		Utility.waitfor(5);
		objLoginPage.firstName.clear();
		objLoginPage.secondName.clear();
		objLoginPage.accntPassword.clear();
		objLoginPage.postcode.clear();
		objLoginPage = new LoginPage(driver);
		click(objLoginPage.gender);
		sendText(objLoginPage.firstName, "Soji");
		sendText(objLoginPage.secondName, "Satheesh");
		sendText(objLoginPage.accntPassword, "Ucs@1234");
		click(objLoginPage.newsletter);
		sendText(objLoginPage.address1, "shj");
		sendText(objLoginPage.city, "shj");
		sendText(objLoginPage.postcode, "00501");
		dropDown(objLoginPage.state).selectByValue("2");
		sendText(objLoginPage.phoneNo, "1234567890");
		click(objLoginPage.register);
		explicitWaitvisiblity(objLoginPage.submittest);
		String accountcreated = driver.getCurrentUrl();
		String expectedurl = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertTrue(accountcreated.equals(expectedurl), "account not created");

	}

}
