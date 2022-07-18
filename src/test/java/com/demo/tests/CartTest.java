package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.main.WebDriverManager;
import com.demo.pages.ProductsPage;
import com.demo.pages.ShoppingCartPage;
import com.demo.utility.Utility;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CartTest extends WebDriverManager {
	ShoppingCartPage objCart;
	ProductsPage objProduct;

	@Test(priority = 20)
	public void cart() {
		objCart = new ShoppingCartPage(driver);
		objProduct = new ProductsPage(driver);
		Scroll(0, -1200);
		explicitWaitClickable(objProduct.womenLink);
		Utility.waitfor(2);
		waitForPageLoad();
		Actions action = new Actions(driver);
		action.moveToElement(objCart.cart).build().perform();
		Utility.waitfor(7);
		List<WebElement> productslist = objCart.cartproducts;
		click(objCart.remove);
		Utility.waitfor(3);
		int size = productslist.size();
		System.out.println("Cart empty msg" + size);
		Assert.assertTrue(size == 0);

	}

}
