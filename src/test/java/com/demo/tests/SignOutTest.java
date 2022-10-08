package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.data.ConstantsData;
import com.demo.main.WebDriverManager;
import com.demo.pages.LoginPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SignOutTest extends WebDriverManager{
	LoginPage objLogin;
	
  @Test(priority=4,groups= {"smoke"})
  public void logout() {
	  objLogin=new LoginPage(driver);
	  objLogin.signOutClick();
	  boolean verified=objLogin.verifySignout(ConstantsData.Sign_In_Text);
	  Assert.assertTrue(verified);
	 
  }
  

}
