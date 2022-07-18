package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.main.WebDriverManager;
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

	@Test(priority = 5)
	public void sortlist() throws InterruptedException {
		objSort = new SortPage(driver);
		Utility.waitfor(5);
		objSort.womenLink.click();
		explicitWaitvisiblity(objSort.pageHeading);
		Scroll(0, 1000);

		List<WebElement> result = objSort.sortResults;
		List<String> Prices1 = new LinkedList<String>();
		for (WebElement t : result) {
			Prices1.add(t.getText().replace("$", ""));

		}
		System.out.println("Before sort" + Prices1);
		Collections.sort(Prices1);
		System.out.println(" sort Price" + Prices1);

		Utility.waitfor(25);
		dropDown(objSort.sort).selectByValue("price:asc");
		explicitWaitinvisiblity(objSort.loader);
		result = objSort.sortResults;
		Utility.waitfor(25);
		List<String> Prices2 = new LinkedList<String>();
		for (WebElement t : result) {
			Prices2.add(t.getText().replace("$", ""));

		}
		System.out.println("After sort" + Prices2);
		Assert.assertEquals(Prices1, Prices2);

	}

}
