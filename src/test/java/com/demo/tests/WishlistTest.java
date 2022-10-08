package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.data.ConstantsData;
import com.demo.main.WebDriverManager;
import com.demo.pages.ProductsPage;
import com.demo.pages.WishlistPage;
import com.demo.utility.Utility;
import com.demo.utility.WebElementHandlers;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class WishlistTest extends WebDriverManager {
	ProductsPage objProduct;
	WishlistPage objWishlist;

	@Test(priority = 14, enabled = true)
	public void wishlistlogin() {
		objProduct = new ProductsPage(driver);
		objProduct.selectCategoryWomen();
		WebElement product = objProduct.getProduct(1);
		String itemName = objProduct.productName(1);
		String alertText = objProduct.addToWishList(1, product);
		Assert.assertTrue(objProduct.verifyWishListSuccessMessage(alertText, ConstantsData.WISHLIST_SUCCESS_MSG),
				"Unable to add product to wishlist");

		objWishlist = new WishlistPage(driver);
		objWishlist.wishlistNavigation();
		Assert.assertTrue(objWishlist.wishlistProductCheck(itemName));

	}

	/*
	 * @Test(priority = 15, enabled = true) public void wishlisttest() { WebElement
	 * product = objProduct.getProduct(1); String itemName =
	 * objProduct.productName(product); objWishlist = new WishlistPage(driver);
	 * objWishlist.wishlistNavigation();
	 * Assert.assertTrue(objWishlist.wishlistProductCheck(itemName)); }
	 */

	@Test(priority = 15, enabled = false)
	public void wishlistdelete() {
		objWishlist = new WishlistPage(driver);
		objWishlist.wishlistNavigation();
		String product = objWishlist.deleteProduct(0);
		boolean deleted = objWishlist.verifyDelete(product);
		Assert.assertTrue(deleted);
	}

	@Test(priority = 16, enabled = false)
	public void wishlistredirection() {
		objWishlist = new WishlistPage(driver);
		objWishlist.wishlistNavigation();
		objWishlist.productLinkClick();
		Assert.assertTrue(objWishlist.heading.isDisplayed());

	}

	@Test(priority = 17, enabled = false)
	public void wishlistnotlogin() {
		objProduct = new ProductsPage(driver);
		objProduct.selectCategoryWomen();
		WebElement product = objProduct.getProduct(1);
		String alertText = objProduct.addToWishList(1, product);
		Assert.assertTrue(objProduct.verifyWishListNonSuccessMessage(alertText, ConstantsData.WISHLIST_NOT_LOGIN));

	}
}
