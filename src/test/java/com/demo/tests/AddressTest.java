package com.demo.tests;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.data.RandomData;
import com.demo.main.WebDriverManager;
import com.demo.pages.AddressPage;
import com.demo.utility.Utility;

public class AddressTest extends WebDriverManager {
	AddressPage objAddressPage;

	@Test(priority = 9)
	public void address() {
		objAddressPage = new AddressPage(driver);
		objAddressPage.addressPageNavigation();
		objAddressPage.addaddressPageNavigation();
		HashMap<String,String> address=RandomData.getAddressData();
		objAddressPage.enterAddressDetails(address);
		objAddressPage.addressPageNavigation();
		boolean addAddressVerify=objAddressPage.addAddressVerification(address);
		Assert.assertTrue(addAddressVerify);

	}

	@Test(priority = 11)
	public void addressDelete() throws InterruptedException {
		objAddressPage = new AddressPage(driver);
		String addresstobeDeleted=objAddressPage.selectAddresstobeDeleted(1);
		objAddressPage.deleteAddress(1);
		objAddressPage.verifyDelete(addresstobeDeleted);
		}

	@Test(priority = 10)
	public void addressUpdate() {
		objAddressPage = new AddressPage(driver);
		objAddressPage.addresstobeUpdated(1);
		HashMap<String,String> address=RandomData.getAddressData();
		objAddressPage.updateFirstname(address, 1);
		String firstnameUpdated=objAddressPage.verifyUpdatedFirstname(address);
		Assert.assertTrue(address.get("updatefirstname").equalsIgnoreCase(firstnameUpdated));
		

	}

}
