package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.data.ConstantsData;
import com.demo.main.WebDriverManager;
import com.demo.pages.CheckOutPage;
import com.demo.pages.ProductsPage;
import com.demo.utility.Utility;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ContinueShoppingPageTest extends WebDriverManager {
	ProductsPage objProduct;
	CheckOutPage objCheckout;

	

	@Test(priority = 21)
	public void continueshopSK() throws InterruptedException {
		objProduct = new ProductsPage(driver);
		objProduct.selectCategoryWomen();
		objProduct.ContinueShopping(0);
		objProduct.ContinueShopping(1);
		boolean verified=objProduct.verifyContinueShopping(1);
		Assert.assertTrue(verified);
		objProduct.carttoCheckOut(3);
	}

	

	@Test(priority = 23,enabled=true)
	public void checkoutdelete() throws InterruptedException {
		objCheckout = new CheckOutPage(driver);
		String productName=objCheckout.deleteProductFromCart(1);
		boolean verified=objCheckout.verifyDelete(productName,"alt");
        Assert.assertFalse(verified);
	}
}
