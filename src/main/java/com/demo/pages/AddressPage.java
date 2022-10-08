package com.demo.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.main.WebDriverManager;
import com.demo.utility.Utility;
import com.demo.utility.Waits;
import com.demo.utility.WebElementHandlers;

public class AddressPage extends BasePage{

	public AddressPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (linkText="My addresses")
	public WebElement adresslink;
	
	@FindBy (xpath="//a[@title='Add an address']")
	public WebElement addanaddresslink;
	
	@FindBy (id="firstname")
	public WebElement firstname;
	
	@FindBy (id="company")
    public WebElement  company;
	
	@FindBy (id="address1")
	public WebElement address1;
	
	@FindBy (id="address2")
	public WebElement address2;
	
	@FindBy (id="city")
	public WebElement city;
	
	@FindBy (id="id_state")
	public WebElement state;
	
	@FindBy (id="postcode")
	public WebElement postalcode;
	
	@FindBy (id="id_country")
	public WebElement country;
	
	@FindBy (id="phone")
	public WebElement phone;
	
	@FindBy (id="phone_mobile")
	public WebElement mobile;
	
	@FindBy (id="other")
	public WebElement additional;
	
	@FindBy (id="alias")
	public WebElement alias;
	
	@FindBy (id="submitAddress")
	public WebElement submit;
	
	@FindBy(xpath="//a[@class='btn btn-defaul button button-small']")
	public WebElement backtoaddresslink;
	
	@FindBy (xpath="h3[@class='page-subheading']")
	public List <WebElement> addressheading;
	
	@FindBy (xpath="h3[@class='page-subheading']")
	public WebElement addressheading1;
	
	@FindBy (xpath="//div[@class='bloc_adresses row']/div/ul/li[1]/h3")
	public List <WebElement> addressheadingtest;
	
	@FindBy (xpath="//div[@class='bloc_adresses row']/div/ul/li[1]/h3")
	public WebElement addressheadingtest1;
	
	@FindBy (xpath="//a[@title='Delete']")
	public List <WebElement> delete;
	
	@FindBy (xpath="//a[@title='Delete']")
	public WebElement deletetest;
	
	@FindBy (xpath="//a[@title='Update']")
	public WebElement update;
	
	@FindBy (xpath="//a[@title='Update']")
	public List <WebElement> updatelist;
	
	@FindBy (xpath="//div[@class='bloc_adresses row']/div/ul/li[2]/span[1]")
	public List <WebElement> addressfirstname;
	
	@FindBy (xpath="//div[@class='bloc_adresses row']/div/ul/li[2]/span[1]")
	public List <WebElement> addresssecondname;
	
	
	public void addressPageNavigation()
   	{
		WebDriverManager.waitForPageLoad();
		WebElementHandlers.scroll(0, 1250);
		WebElementHandlers.click(adresslink);
		WebDriverManager.waitForPageLoad();
		Waits.explicitWaitVisiblity(addanaddresslink);
	}
	public void addaddressPageNavigation()
	{
		WebElementHandlers.click(addanaddresslink);
	}
	public void enterAddressDetails(HashMap<String,String> address)
	{
		WebElementHandlers.sendText(company,address.get("company"));
		WebElementHandlers.sendText(address1,address.get("address1"));
		WebElementHandlers.sendText(address2,address.get("address2"));
		WebElementHandlers.sendText(city,address.get("city"));
		WebElementHandlers.dropDown(state).selectByIndex(3);
		WebElementHandlers.sendText(postalcode,address.get("postalcode"));
		WebElementHandlers.sendText(phone,address.get("phone"));
		WebElementHandlers.sendText(phone,address.get("mobile"));
		WebElementHandlers.sendText(additional,address.get("additional"));
		WebElementHandlers.sendText(alias,address.get("expected"));
		submit.click();
		WebDriverManager.waitForPageLoad();
	}
	public boolean addAddressVerification(HashMap<String,String> address)
	{
		WebDriverManager.waitForPageLoad();
		System.out.println("test for"+address.get("expected"));
		Waits.explicitWaitVisiblity(addressheadingtest1);
		List<WebElement> addressHeading = addressheadingtest;
		Waits.explicitWaitVisiblity(addressHeading.get(1));
		System.out.println("address added"+addressHeading.get(2).getText());
		boolean found = false;
		for (WebElement t : addressHeading) {
			String te = t.getText();
			System.out.println("address found"+te);
			if (te.equalsIgnoreCase(address.get("expected"))) {
				found = true;
				break;
			}
			else
			{
				found=false;
			}
		}
		return found;
	}
	
	
	public String selectAddresstobeDeleted(int index) {
		List<WebElement> addresslist = addressheadingtest;
		Waits.explicitWaitClickable(addresslist.get(index));
		String addressName=WebElementHandlers.getText(addresslist.get(index));
		return addressName;
	}
	public void deleteAddress(int index)
	{
		List<WebElement> del = delete;
		Waits.explicitWaitClickable(del.get(index));
		WebElementHandlers.click(del.get(index));
		WebElementHandlers.alertcheck("accept", "");
		
		}
	public boolean verifyDelete(String addressname)
	{
		boolean found = false;
		for (WebElement t : delete) {
			String te = t.getText();
			if (te.equalsIgnoreCase(addressname)) {
				found = true;
				break;
			}
		}
		return found;
	}  
	
	public void addresstobeUpdated(int index)
	{
		List<WebElement> update = updatelist;
		WebElement addresstobeUpdated=updatelist.get(index);
		Waits.explicitWaitClickable(updatelist.get(index));
		WebElementHandlers.click(updatelist.get(index));
		WebDriverManager.waitForPageLoad();
		Waits.explicitWaitClickable(firstname);
		
	}
	public void updateFirstname(HashMap<String,String> address,int index)
	{
		WebElementHandlers.sendText(firstname,address.get("updatefirstname"));
		WebElementHandlers.sendText(alias,address.get("additionalupdate"));
		WebElementHandlers.click(submit);
		WebDriverManager.waitForPageLoad();
		
	}
	public String verifyUpdatedFirstname(HashMap<String,String> address)
	{
		List<WebElement> firstname = addressfirstname;
		Waits.explicitWaitVisiblity((firstname).get(1));
		String firstnameUpdated=WebElementHandlers.getText(firstname.get(1));
		return firstnameUpdated;
	}
		
		
	}

