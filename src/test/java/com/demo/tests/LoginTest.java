package com.demo.tests;

import org.testng.annotations.Test;
import com.demo.data.ConstantsData;
import com.demo.data.RandomData;
import com.demo.main.WebDriverManager;
import com.demo.pages.LoginPage;
import com.demo.utility.Utility;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginTest extends WebDriverManager {

	LoginPage objLogin;

	@Test(priority = 2, enabled = true, groups = { "sanity" })
	public void login() throws IOException {
		objLogin = new LoginPage(driver);
		objLogin.login(RandomData.getValidUserData());
		WebElement element=objLogin.validlogin();
		Assert.assertTrue(element.isDisplayed());
}

	@Test(priority = 1, enabled =true, groups = { "sanity" })
	public void invalidLogin() throws IOException {
        objLogin = new LoginPage(driver);
		objLogin.login(RandomData.getInValidUserData());
		Assert.assertTrue(objLogin.inValid().contains(ConstantsData.ERROR_LOGIN), "Logged in not done as expected");
		driver.navigate().refresh();
}
}
