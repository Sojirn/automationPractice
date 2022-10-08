package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.demo.main.WebDriverManager;
import com.demo.utility.Utility;
import com.demo.utility.Waits;
import com.demo.utility.WebElementHandlers;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (name="submit_search")
    public WebElement searchIcon;
	 
	@FindBy (id="search_query_top")
    public WebElement searchText;
	
	@FindBy (xpath="//*[@class='product_list grid row']/li//img")
	public List <WebElement> searchResults;
	
	public void search(String search)
	{
	WebDriverManager.waitForPageLoad();
	Waits.explicitWaitClickable(searchText);
	WebElementHandlers.sendText(searchText,search);
	Waits.explicitWaitVisiblity(searchIcon);
	WebElementHandlers.click(searchIcon);
	WebDriverManager.waitForPageLoad();
}
	public boolean verifySearch(String Search)
	{
		WebDriverManager.waitForPageLoad();
		List<WebElement> result = searchResults;
		boolean verified=false;
		for (WebElement t : result) {
			if(t.getAttribute("title").contains(Search))
			{
			verified=true;
			}
			else
			{
				verified=false;
			}
		}
		return verified;
	}
}