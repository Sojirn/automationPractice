package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.data.ConstantsData;
import com.demo.main.WebDriverManager;
import com.demo.pages.CheckOutPage;
import com.demo.pages.ProductsPage;
import com.demo.pages.SearchPage;
import com.demo.utility.Utility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SearchProductTest extends WebDriverManager {

	SearchPage objSearch;

	@Test(priority = 5, dataProvider="SearchProvider",groups = { "smoke" })
	public void searchTest(String test,String Search) {
		objSearch = new SearchPage(driver);
		objSearch.search(Search);
		boolean verified=objSearch.verifySearch(Search);
		Assert.assertTrue(verified, "Search not working properly");
		

}
	@DataProvider(name="SearchProvider")
	  public Object[][] getDataFromDataprovider(){
	  return new Object[][]
	  {
	  { "Test","Printed"},
	  { "New","Summer" },
	  { "new", "Chiffon"}
	  };
	}
}