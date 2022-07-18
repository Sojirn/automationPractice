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
		Scroll(0, 1250);
		click(objAddressPage.adresslink);
		waitForPageLoad();
		explicitWaitvisiblity(objAddressPage.addanaddresslink);
		click(objAddressPage.addanaddresslink);
		HashMap<String,String> address = RandomData.getAddressData();
		sendText(objAddressPage.company,address.get("company"));
		sendText(objAddressPage.address1,address.get("address1"));
		sendText(objAddressPage.address2,address.get("address2"));
		sendText(objAddressPage.city,address.get("city"));
		dropDown(objAddressPage.state).selectByIndex(3);
		sendText(objAddressPage.postalcode,address.get("postalcode"));
		sendText(objAddressPage.phone,address.get("phone"));
		sendText(objAddressPage.phone,address.get("mobile"));
		sendText(objAddressPage.additional,address.get("additional"));
		objAddressPage.alias.clear();
		Utility.waitfor(2);
		sendText(objAddressPage.alias,address.get("expected"));
		objAddressPage.submit.click();
		Utility.waitfor(10);
		waitForPageLoad();
		explicitWaitvisiblity(objAddressPage.addressheadingtest1);
		List<WebElement> addressheading = objAddressPage.addressheadingtest;
		
		Assert.assertTrue(isListContainsText(addressheading, address.get("expected")));

	}

	@Test(priority = 10)
	public void checkoutdelete() throws InterruptedException {
		objAddressPage = new AddressPage(driver);
		List<WebElement> addresslist = objAddressPage.addressheadingtest;
		explicitWaitClickable(addresslist.get(1));
		String addressname=getText(addresslist.get(1));
		System.out.println(addressname);
		List<WebElement> del = objAddressPage.delete;
		explicitWaitClickable(del.get(1));
		click(del.get(1));
		alertcheck("accept", "");
		Assert.assertFalse(isListContainsText(del, addressname));
		}

	@Test(priority = 11)
	public void update() {
		objAddressPage = new AddressPage(driver);
		List<WebElement> update = objAddressPage.updatelist;
		explicitWaitClickable(update.get(1));
		click(update.get(1));
		Utility.waitfor(5);
		waitForPageLoad();
		explicitWaitClickable(objAddressPage.firstname);
		HashMap<String,String> address = RandomData.getAddressData();
		objAddressPage.firstname.clear();
		sendText(objAddressPage.firstname,address.get("updatefirstname"));
		sendText(objAddressPage.alias,address.get("additionalupdate"));
		click(objAddressPage.submit);
		waitForPageLoad();
		Utility.waitfor(7);
		List<WebElement> firstname = objAddressPage.addressfirstname;
		String firstnameupdated=getText(firstname.get(1));
		Assert.assertTrue(address.get("updatefirstname").equalsIgnoreCase(firstnameupdated));
		

	}

}
