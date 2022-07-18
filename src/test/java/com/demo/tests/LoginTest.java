package com.demo.tests;

import org.testng.annotations.Test;
import com.demo.data.ConstantsData;
import com.demo.main.WebDriverManager;
import com.demo.pages.LoginPage;
import com.demo.utility.Utility;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginTest extends WebDriverManager {

	LoginPage objLogin;

	@Test(priority = 2, enabled = true, groups = { "sanity" })
	public void validlogin() throws IOException {
		Utility.waitfor(10);
		objLogin = new LoginPage(driver);
		objLogin.signIn.click();
		WebElement test = objLogin.wishlist;
		String username = Utility.readExcelData(0, 1);
		String password = Utility.readExcelData(0, 2);
		objLogin.email.sendKeys(username);
		objLogin.password.sendKeys(password);
		objLogin.submit.click();
		explicitWaitvisiblity(test);
		String ActualUrl = driver.getCurrentUrl();
		Assert.assertTrue(ActualUrl.equals(ConstantsData.URL_LOGGED_IN), "Unable to Login");

	}

	@Test(priority = 1, enabled = true, groups = { "sanity" })
	public void invalidLogin() throws IOException {

		objLogin = new LoginPage(driver);
		Utility.waitfor(10);
		objLogin.signIn.click();

		String username = Utility.readExcelData(1, 1);
		String password = Utility.readExcelData(1, 2);
		WebElement emailtest = objLogin.email;

		Utility.waitfor(6);

		objLogin.email.sendKeys(username);
		objLogin.password.sendKeys(password);
		objLogin.submit.click();
		explicitWaitvisiblity(emailtest);

		String ActualMsg = objLogin.errorMessage.getText();
		Assert.assertTrue(ActualMsg.contains(ConstantsData.ERROR_LOGIN), "Logged in not done as expected");
		driver.navigate().refresh();

	}

}
