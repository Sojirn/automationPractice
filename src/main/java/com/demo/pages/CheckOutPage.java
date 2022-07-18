package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{

	public CheckOutPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//ul[@id='order_step']")
	public WebElement summaryhead;
	
	@FindBy (xpath="//a[@class=\"cart_quantity_delete\"]")
	public List <WebElement> deleteproducts;
	
	@FindBy (xpath="//p[@class='cart_navigation clearfix']/a[1]")
	public WebElement sumCheckout;
	
	@FindBy (xpath="//textarea[@class='form-control']")
	public WebElement msgBox;
	
	@FindBy (xpath="//button[@class=\"button btn btn-default button-medium\"]/span")
	public WebElement addCheckout;
	
	@FindBy (id="cgv")
	public WebElement checkterms;
	
	@FindBy (xpath="//button[@class=\"button btn btn-default standard-checkout button-medium\"]")
	public WebElement shipCheckout;
	
	@FindBy (xpath="//div[@class=\"col-xs-12 col-md-6\"]/p/a")
	public WebElement paycheck;
	
	@FindBy (xpath="//p[@id=\"cart_navigation\"]/button/span")
	public WebElement confirmOrder;
	
	@FindBy (xpath="//*[@id=\"center_column\"]/h1")
	public WebElement ordermailtext;
	
	@FindBy (xpath="//i[@class=\"icon-plus\"]")
    public WebElement quantityinc;
	
	@FindBy (xpath="//input[@class='cart_quantity_input form-control grey']")
	public WebElement qntydisplayed;
	 
	@FindBy (xpath="//tr[@class=\"cart_item last_item first_item address_714064 odd\"]/td[4]/span/span")
	public WebElement UnitPrice;
	
	@FindBy (xpath="//tr[@class=\"cart_item last_item first_item address_714064 odd\"]/td[6]/span")
	public WebElement totPrice;

	@FindBy (xpath="//td[@class='cart_product']/a/img")
	public List <WebElement> productlist;
}
