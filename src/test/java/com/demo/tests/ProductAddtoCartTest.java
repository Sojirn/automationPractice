package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.data.ConstantsData;
import com.demo.main.WebDriverManager;
import com.demo.pages.ProductsPage;
import com.demo.utility.Utility;

import org.testng.annotations.BeforeTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ProductAddtoCartTest extends WebDriverManager {
	ProductsPage objProduct;

	@Test(priority = 4, enabled = true, groups = { "sanity" })
	public void tshirtSelection() {
		objProduct = new ProductsPage(driver);
		objProduct.selectCategory(ConstantsData.Category_TSHIRT);
		boolean verify=objProduct.verifyCategoryTshirtSelection(ConstantsData.TSHIRT_SELECTION);
		Assert.assertTrue( verify,"Not selected");
	}

	@Test(priority = 5, enabled = true, groups = { "sanity" })
	public void productselection() {
		objProduct = new ProductsPage(driver);
		objProduct.productSelection();
		String actualTest=objProduct.productAddToCart();
		objProduct.CheckOutRedirection();
		Assert.assertTrue(actualTest.contains(ConstantsData.CART_EXPECTED_MSG), "Product not added");

	}

}
