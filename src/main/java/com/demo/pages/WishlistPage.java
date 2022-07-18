package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends BasePage{

	public WishlistPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath="//li[@class='lnk_wishlist']/a")
	public WebElement accountWishlist;
	
	@FindBy (xpath="//table[@class='table table-bordered']/tbody/tr/td[5]/a")
	public WebElement wishlistlink;
	
	@FindBy (xpath="//ul[@class='row wlp_bought_list']/li//img")
	public List <WebElement> productlist;
	
	@FindBy (linkText="My account")
	public WebElement accountlink;
	
	@FindBy (xpath="//i[@class='icon-remove-sign']")
	public List <WebElement> deletelist;
	
	@FindBy (xpath="//i[@class='icon-remove-sign']")
	public  WebElement delete;
	
	@FindBy (xpath="//h1[@itemprop='name']")
	public WebElement heading;
	
	
	
	

}
