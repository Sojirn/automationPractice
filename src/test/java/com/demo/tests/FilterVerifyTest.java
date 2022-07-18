package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.main.WebDriverManager;
import com.demo.pages.ProductFilterPage;
import com.demo.pages.ProductsPage;
import com.demo.utility.Utility;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FilterVerifyTest extends WebDriverManager {
	ProductsPage objProduct;
	ProductFilterPage objProductFilter;

	@Test
	public void filterproduct() {
		boolean filter = false;
		objProduct = new ProductsPage(driver);
		objProductFilter = new ProductFilterPage(driver);
		explicitWaitClickable(objProduct.womenLink);
		elementClick(objProduct.womenLink);
		objProduct.cotton.click();
		Scroll(0, 500);
		explicitWaitinvisiblity(objProduct.loader);
		Utility.waitfor(10);
		List<WebElement> product = objProduct.searchcottonResults;
		System.out.println(product.size());
		int test = product.size();
		for (int i = 0; i < test; i++) {
			Utility.waitfor(3);

			WebElement producttest = product.get(i);
			Actions action = new Actions(driver);
			action.moveToElement(producttest).build().perform();

			explicitWaitClickable(objProduct.moreButton_sk);
			objProduct.moreButton.get(i).click();
			waitForPageLoad();
			String expected = objProductFilter.detailcotton.getText();
			System.out.println(expected);
			if (expected.contains("Cotton")) {
				filter = true;
			} else {
				filter = false;
			}

			driver.navigate().back();
		}
		Assert.assertTrue(filter);
	}

}
