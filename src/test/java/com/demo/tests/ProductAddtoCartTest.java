package com.demo.tests;

import org.testng.annotations.Test;

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
	
	@Test(priority = 3, enabled = true, groups = { "sanity" })
	public void tshirtSelection() {
		objProduct = new ProductsPage(driver);
		Utility.waitfor(5);
		objProduct.tshirtLink.click();
		waitForPageLoad();
		WebElement te = objProduct.TshirtText;
		explicitWaitvisiblity(te);

		String tshirttext = te.getText();
		System.out.println("Text is" + tshirttext);
		String expectedText = "T-SHIRTS";
		Assert.assertTrue(tshirttext.contains(expectedText), expectedText);
	}

	@Test(priority = 4, enabled = true, groups = { "sanity" })
	public void productselection() {
		objProduct.large.click();

		explicitWaitinvisiblity(objProduct.loader);
		objProduct.blue.click();
		explicitWaitinvisiblity(objProduct.loader);
		objProduct.cotton.click();
		explicitWaitinvisiblity(objProduct.loader);
		objProduct.casual.click();
		explicitWaitinvisiblity(objProduct.loader);
		objProduct.shrtSleeve.click();
	    explicitWaitinvisiblity(objProduct.loader);
		objProduct.manufacturer.click();
		explicitWaitinvisiblity(objProduct.loader);
		objProduct.newcoll.click();
		explicitWaitinvisiblity(objProduct.loader);
		Actions action = new Actions(driver);
		action.moveToElement(objProduct.tshirtProduct).click().build().perform();

		WebElement qu = objProduct.quantitytest;
		qu.clear();
		qu.sendKeys("2");
		Scroll(0, 500);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", objProduct.AddtoCart);
		objProduct.AddtoCart.click();

		explicitWaitvisiblity(objProduct.checkOut);

		String displayedmsg = objProduct.productSuccessmsg.getText();
		String Expectedmsg = "Product successfully added to your shopping cart";
		System.out.println("success msg" + displayedmsg);
		Assert.assertTrue(displayedmsg.contains(Expectedmsg), "Product not added");
		objProduct.proceedCheckout.click();

	}

}
