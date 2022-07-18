package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	
	
	
}
