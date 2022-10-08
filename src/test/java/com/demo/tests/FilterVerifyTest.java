package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.data.ConstantsData;
import com.demo.main.WebDriverManager;
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
	

	@Test
	public void filterproduct() {
		objProduct = new ProductsPage(driver);
		objProduct.selectCategoryWomen();
		objProduct.applyMaterialFilter(ConstantsData.MATERIAL_TYPE);
		boolean filterVerified=objProduct.verifyMaterialFilter(ConstantsData.MATERIAL_TYPE);
		Assert.assertTrue(filterVerified);
	}

	
}
