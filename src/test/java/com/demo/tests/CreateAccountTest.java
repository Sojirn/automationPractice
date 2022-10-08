package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.data.ConstantsData;
import com.demo.data.RandomData;
import com.demo.main.WebDriverManager;
import com.demo.pages.LoginPage;
import com.demo.utility.Utility;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.HashMap;
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
	public void CreateAccountNavigation() {
		objLoginPage = new LoginPage(driver);
		objLoginPage.accessSignInPage();
		String userEmail = Utility.getRandomEmail();
		objLoginPage.enterEmail(userEmail);
		objLoginPage.clickCreateAccount();
		Assert.assertTrue(objLoginPage.verifyEmailEntered(userEmail));

	}

	@Test(priority = 2, enabled = true, groups = { "smoke" })
	public void createaccountvalidation() {
		objLoginPage = new LoginPage(driver);
		objLoginPage.enterInvalidAccountDetails(RandomData.getAccountData());
		objLoginPage.clickRegister();
		boolean verifyErrorMsg=objLoginPage.verifyErrorMessage(ConstantsData.POSTAL_ERROR_MSG);
		Assert.assertTrue(verifyErrorMsg);

	}

	@Test(priority = 3, enabled = true, groups ={"smoke"})
	public void createaccount() {
		objLoginPage = new LoginPage(driver);
		objLoginPage.enterAccountDetails(RandomData.getAccountData());
		objLoginPage.clickRegister();
		WebElement accountVerify=objLoginPage.verifyRegisterAccount();
		Assert.assertTrue(accountVerify.isDisplayed());

	}

}
