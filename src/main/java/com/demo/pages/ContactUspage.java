package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUspage extends BasePage {

	public ContactUspage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}
	@FindBy (linkText="Contact us")
	public WebElement contact;
	
	@FindBy (id="id_contact")
	public WebElement subject;
	
	@FindBy (name="id_order")
	public WebElement order;
	
	@FindBy (xpath="//div[@id='uniform-449215_order_products']")
	public WebElement product;
	
	@FindBy (xpath="//div[@id='uniform-449215_order_products']")
	public WebElement product1;
	
	
	@FindBy (id="fileUpload")
	public WebElement upload;
	
	@FindBy (id="message")
	public WebElement msg;
	
	@FindBy (id="submitMessage")
	public WebElement button;
	
	@FindBy (xpath="//h1[@class='page-heading bottom-indent']")
	public WebElement heading;
	
	@FindBy (id="id_order")
	public WebElement orderinput;
	
	@FindBy (id="email")
	public WebElement email;
	
	@FindBy (xpath="//p[@class='alert alert-success']")
	public WebElement alertMsg;
	
	@FindBy (xpath="//div[@class='alert alert-danger']")
	public WebElement alertdanger;
	

}
