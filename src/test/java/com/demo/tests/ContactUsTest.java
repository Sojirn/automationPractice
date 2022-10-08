package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.data.ConstantsData;
import com.demo.data.RandomData;
import com.demo.main.WebDriverManager;
import com.demo.pages.ContactUspage;
import com.demo.utility.Utility;

import org.testng.annotations.BeforeTest;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ContactUsTest extends WebDriverManager {
	ContactUspage objContactUs;
	String userDir = System.getProperty("user.dir") + "/src/test/resources/";

	@Test(priority = 13, enabled = false)
	public void contactnotlogin() throws InterruptedException {
		objContactUs = new ContactUspage(driver);
		objContactUs.contactUsRedirection();
		HashMap<String,String> contact=RandomData.getAddressData();
		//String email=Utility.getRandomEmail();
		String email="soji@test.com";
		objContactUs.enterDetailsBeforeLogin(contact, email);
		String verifyAddContact =objContactUs.verifyAddContact();
		Assert.assertEquals(ConstantsData.Contact_MSG_CONFIRMATION,verifyAddContact);
	}

	@Test(priority = 13, enabled = true)
	public void contactlogin() throws InterruptedException {
		objContactUs = new ContactUspage(driver);
		objContactUs.contactUsRedirection();
		HashMap<String,String> contact=RandomData.getAddressData();
		objContactUs.contactUsRedirection();
		objContactUs.enterDetailsAfterLogin(contact);
		String alertText = objContactUs.verifyAddContact();
		Assert.assertEquals(ConstantsData.Contact_MSG_CONFIRMATION, alertText);
	}

	@Test(priority = 12, enabled = false)
	public void contactvalidlogin() throws InterruptedException {
		objContactUs = new ContactUspage(driver);
		HashMap<String,String> contact = RandomData.getContactData();
		objContactUs.contactUsRedirection();
		objContactUs.validateLogin(contact);
		String alertErrorMsg=objContactUs.verifyErrorMessage();
		Assert.assertTrue(alertErrorMsg.contains(ConstantsData.ERROR_LOGIN));
	}
	


}
