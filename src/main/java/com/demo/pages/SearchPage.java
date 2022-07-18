package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (name="submit_search")
    public WebElement searchIcon;
	 
	@FindBy (id="search_query_top")
    public WebElement searchText;
	
	@FindBy (xpath="//*[@class='product_list row grid']/li//img")
	public List <WebElement> searchResults;
	

	
}
