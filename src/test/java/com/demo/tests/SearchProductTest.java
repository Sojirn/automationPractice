package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.main.WebDriverManager;
import com.demo.pages.CheckOutPage;
import com.demo.pages.ProductsPage;
import com.demo.pages.SearchPage;
import com.demo.utility.Utility;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SearchProductTest extends WebDriverManager {

	SearchPage objSearch;

	@Test(priority = 5, groups = { "smoke" })
	public void search() {
		objSearch = new SearchPage(driver);
		String searchText = "Print";
		Utility.waitfor(5);
		explicitWaitClickable(objSearch.searchText);
		objSearch.searchText.sendKeys("Print");
		Utility.waitfor(5);
		objSearch.searchIcon.click();
		List<WebElement> result = objSearch.searchResults;
		for (WebElement t : result) {
			Assert.assertTrue(t.getAttribute("title").contains(searchText), "Search Result not correct");
		}

	}

}
