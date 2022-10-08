package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.main.WebDriverManager;
import com.demo.pages.ProductsPage;
import com.demo.pages.ShoppingCartPage;
import com.demo.utility.Utility;
import com.demo.utility.WebElementHandlers;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CartTest extends WebDriverManager {
	ShoppingCartPage objCart;
	ProductsPage objProduct;

	@Test(priority = 6)
	public void cart() {
		objProduct = new ProductsPage(driver);
		objProduct.selectCategoryWomen();
		objCart = new ShoppingCartPage(driver);
		WebElementHandlers.actionsMove(objCart.cart);
		int size=objCart.productDeleteFromCart();
		Assert.assertTrue(size == 0);

	}

}
