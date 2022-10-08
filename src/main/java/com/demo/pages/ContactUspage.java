package com.demo.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import com.demo.main.WebDriverManager;
import com.demo.utility.Utility;
import com.demo.utility.Waits;
import com.demo.utility.WebElementHandlers;

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
	
	String userDir = System.getProperty("user.dir") + "/src/test/resources/";
	
	public void contactUsRedirection() throws InterruptedException
	{
	    WebDriverManager.waitForPageLoad();
		WebElementHandlers.click(contact);
		Thread.sleep(5000);
		WebDriverManager.waitForPageLoad();
		Waits.explicitWaitVisiblity(heading);
		 WebDriverManager.waitForPageLoad();
	}
	
	public void enterDetailsBeforeLogin(HashMap<String,String> contact,String Email)
	{
	WebElementHandlers.dropDown(subject).selectByIndex(1);
	WebElementHandlers.sendText(email,Email);
	WebElementHandlers.sendText(order,contact.get("ordertest"));
	WebElementHandlers.sendText(upload,userDir + "test.pdf");
	WebElementHandlers.sendText(msg,contact.get("phone"));
	WebElementHandlers.click(button);
	WebDriverManager.waitForPageLoad();

}
	public String verifyAddContact()
	{
		String alertText = alertMsg.getText();
		return alertText;
	}
	public void enterDetailsAfterLogin(HashMap<String,String> contact)
	{ 
		WebElementHandlers.dropDown(subject).selectByIndex(1);
		String orderid = WebElementHandlers.dropDown(order).getOptions().get(2).getAttribute("value");
		WebElementHandlers.dropDown(order).selectByIndex(2);
	    Waits.explicitWaitVisiblity(product);
		WebElement product = driver.findElement(By.id(orderid + "_order_products"));
		Waits.explicitWaitVisiblity(product);
		WebElementHandlers.dropDown(product).selectByIndex(1);
		Waits.explicitWaitVisiblity(upload);
		WebElementHandlers.sendText(upload,userDir + "test.pdf");
		WebElementHandlers.sendText(msg,contact.get("phone"));
		WebElementHandlers.click(button);
	}
	public void validateLogin(HashMap<String,String> contact)
	{
		WebElementHandlers.dropDown(subject).selectByIndex(1);
		WebElementHandlers.sendText(orderinput,contact.get("order"));
		WebElementHandlers.sendText(upload,userDir + "test.pdf");
		WebElementHandlers.sendText(msg,contact.get("phone"));
		WebElementHandlers.click(button);
	}
	public String verifyErrorMessage()
	{
		String alertErrorMsg = alertdanger.getText();
		return alertErrorMsg;
	}
	
}