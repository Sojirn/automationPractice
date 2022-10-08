package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.data.ConstantsData;
import com.demo.main.WebDriverManager;
import com.demo.pages.CheckOutPage;
import com.demo.pages.ProductsPage;
import com.demo.utility.Utility;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

public class CheckOutTest extends WebDriverManager {
	CheckOutPage objCheckout;
	ProductsPage objProudct;

	@Test(priority =26, enabled = true, groups = { "sanity" })
	public void checkoutsummary() {
		objCheckout = new CheckOutPage(driver);
		objProudct=new ProductsPage(driver);
		String verifyNavigation=objCheckout.verifyCheckOutNavigation();
		Assert.assertTrue(verifyNavigation.equals(ConstantsData.SUMMARY_PAGE_HEADING));
	
	}

	

	@Test(priority = 27, enabled = true, groups = { "sanity" })
	public void checkoutsummaryquantity() throws InterruptedException {
		objCheckout = new CheckOutPage(driver);
		int qtyBeforeIncrement=objCheckout.clickIncrement();
		int qtyAfterIcrement=objCheckout.verifyQuantityIncrement();
		Assert.assertTrue(qtyAfterIcrement == (qtyBeforeIncrement+1));
	}

	@Test(priority =28, enabled = true, groups = { "sanity" })
	public void checkoutsummaryprice() throws InterruptedException
	{
		objCheckout = new CheckOutPage(driver);
		double unitPrice=objCheckout.getUnitPrice();
		double qty=objCheckout.getqty();
		double expectedPrice=objCheckout.totalPriceExpected(qty, unitPrice);
		double actualPrice=objCheckout.actualTotalPrice();
		Assert.assertEquals(expectedPrice,actualPrice);

	}

	@Test(priority = 29, enabled = true,groups = {"sanity"})
	public void checkout() {
		objCheckout = new CheckOutPage(driver);
		objCheckout.addressSectionNavigation();
		objCheckout.enterMessage(ConstantsData.ORDER_CONFIRMATION_MSG);
		objCheckout.shippingSectionNavigation();
		objCheckout.paymentSectionNavigation();
		objCheckout.confirmOrder();
		String verifyConfirmOrder=objCheckout.verifyConfirmOrder();
		Assert.assertTrue(verifyConfirmOrder.contains(ConstantsData.ORDER_CONFIRMATION_MSG), "checkout not successfull");

	}


}
