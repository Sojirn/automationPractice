package com.demo.pages;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.main.WebDriverManager;
import com.demo.utility.Utility;
import com.demo.utility.Waits;
import com.demo.utility.WebElementHandlers;



public class SortPage extends BasePage{

	public SortPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (linkText="WOMEN")
	 public WebElement womenLink;
	
	@FindBy (id="selectProductSort")
	public WebElement sort;
	
	@FindBy  (xpath="//*[@class=\"right-block\"]/div[1]/span[1]")
	public List <WebElement> sortResults;
	
	@FindBy (xpath="//div[@id=\"layered_ajax_loader\"]/p/img")
	public WebElement loader;
	
	@FindBy (xpath="//h1[@class='page-heading product-listing']")
	public WebElement pageHeading;
	
	public List<String> expectedSortResult()
	{
    List<WebElement> result = sortResults;
	List<String> Prices1 = new LinkedList<String>();
	for (WebElement t : result) {
		Prices1.add(t.getText().replace("$", ""));
      }
	Collections.sort(Prices1);
	WebDriverManager.waitForPageLoad();
	return Prices1;
	}
	public List<String> actualSortResult()
	{
	Waits.explicitWaitVisiblity(sort);
	WebElementHandlers.dropDown(sort).selectByValue("price:asc");
	Waits.explicitWaitInvisiblity(loader);
	WebDriverManager.waitForPageLoad();
	List<String> Prices2 = new LinkedList<String>();
	for (WebElement t : sortResults) {
		Prices2.add(t.getText().replace("$", ""));

	}
	return Prices2;
	}
}