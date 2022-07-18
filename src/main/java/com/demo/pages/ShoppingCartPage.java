package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath="//div[@class='shopping_cart']/a")
	public WebElement cart;
	
	@FindBy (linkText="Cart")
	public WebElement carttest;
	
	@FindBy (xpath="//dt[@class='first_item']")
	public WebElement firstItem;
	
	@FindBy (xpath="//dt[@class='first_item']/span")
	public WebElement remove;
	
	@FindBy (xpath="//dl[@class='products']/dt/a")
	public List <WebElement> cartproducts;
	
	@FindBy (xpath="//p[@class='alert alert-warning']")
	public WebElement cartemptymessage;
	
	
}
