package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.main.WebDriverManager;
import com.demo.pages.ProductsPage;
import com.demo.pages.SortPage;
import com.demo.utility.Utility;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SortTest extends WebDriverManager {
	SortPage objSort;
	ProductsPage objProduct;

	@Test(priority = 5)
	public void sortlist() throws InterruptedException {
		
		objProduct=new ProductsPage(driver);
		objProduct.selectCategoryWomen();
		objSort = new SortPage(driver);
        List <String> Prices1=objSort.expectedSortResult();
        List <String> Prices2=objSort.expectedSortResult();
		Assert.assertEquals(Prices1, Prices2);
      }
}
