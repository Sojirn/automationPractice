package com.demo.tests;

import org.testng.annotations.Test;

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

	@Test(enabled = false)
	public void continueshop() {
		objProduct = new ProductsPage(driver);
		objProduct.womenLink.click();
		waitForPageLoad();
		Scroll(0, 1000);
		List<WebElement> product = objProduct.searchpResults;
		System.out.println(product.get(0));
		WebElement producttest = product.get(0);
		Actions action = new Actions(driver);
		action.moveToElement(producttest).build().perform();
		Utility.waitfor(15);
		explicitWaitvisiblity(objProduct.moverAddtoCart);
		objProduct.moverAddtoCart.click();
		Utility.waitfor(15);
		objProduct.continueShopping.click();
		Utility.waitfor(15);
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		String expectedURL = "http://automationpractice.com/index.php?id_category=3&controller=category";
		Assert.assertEquals(currentURL, expectedURL);

	}

	@Test(priority = 21)
	public void continueshopSK() throws InterruptedException {
		objProduct = new ProductsPage(driver);
		explicitWaitClickable(objProduct.womenLink);
		elementClick(objProduct.womenLink);
		waitForPageLoad();
		Scroll(0, 1000);
		List<WebElement> product = objProduct.searchpResults;
		WebElement producttest = product.get(0);
		Actions action = new Actions(driver);
		action.moveToElement(producttest).build().perform();
		explicitWaitClickable(objProduct.moverAddtoCart);
		objProduct.moverAddtoCart_SK.get(0).click();
		explicitWaitClickable(objProduct.continueShopping);
		objProduct.continueShopping.click();
		explicitWaitClickable(product.get(1));
		action = new Actions(driver);
		action.moveToElement(product.get(1)).build().perform();
		explicitWaitClickable(product.get(1));
		objProduct.moverAddtoCart_SK.get(1).click();
		explicitWaitClickable(objProduct.continueShopping);
		objProduct.continueShopping.click();
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		String expectedURL = "http://automationpractice.com/index.php?id_category=3&controller=category";
		Assert.assertEquals(currentURL, expectedURL);
		explicitWaitClickable(product.get(3));
		action = new Actions(driver);
		action.moveToElement(product.get(3)).build().perform();
		explicitWaitClickable(product.get(3));
		objProduct.moverAddtoCart_SK.get(3).click();
		explicitWaitClickable(objProduct.checkOut);
		objProduct.checkOut.click();

	}

	@Test(priority = 23, enabled = true)
	public void checkoutdelete() throws InterruptedException {
		objCheckout = new CheckOutPage(driver);
		List<WebElement> productlist = objCheckout.productlist;
		explicitWaitClickable(productlist.get(1));
		boolean notfound = false;
		String productname = productlist.get(1).getAttribute("alt");
		System.out.println(productname);
		List<WebElement> delete = objCheckout.deleteproducts;
		explicitWaitClickable(delete.get(1));
		delete.get(1).click();
		for (WebElement del : productlist) {
			if (del.getAttribute("alt").equals(productname)) {
				notfound = false;
			} else {
				notfound = true;
			}
		}
		Assert.assertTrue(notfound);
	}

}
