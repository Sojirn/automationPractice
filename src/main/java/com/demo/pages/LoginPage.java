package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}
	@FindBy (id="SubmitCreate")
	public WebElement createAccount;
	
	@FindBy (id="email_create")
	public WebElement createEmail;
	
	@FindBy (className = "login")
	public WebElement signIn;

	@FindBy (id = "email")
	public WebElement emailAddress;
	
	@FindBy (id="passwd")
	public WebElement password;
	
	@FindBy (id="SubmitLogin")
	public WebElement submit;
	
	@FindBy (xpath="//div/label[@for=\"id_gender1\"]")
     public WebElement gender;
	
	@FindBy (id="customer_firstname")
	public WebElement firstName;
	
	@FindBy (id="customer_lastname")
	public WebElement secondName;
	
	@FindBy (id="passwd")
	public WebElement accntPassword;
	
	@FindBy(id="days")
	public WebElement days;
	
	@FindBy(id="months")
	public WebElement months;
	
	@FindBy (id="years")
	public WebElement years;
	
	@FindBy(id="id_state")
	public WebElement  state;
	
	@FindBy (id="uniform-newsletter")
	public WebElement newsletter;
	
	@FindBy (id="firstname")
	public WebElement frstName;
	
	@FindBy(id="lastname")
	public WebElement lstnme;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="address1")
	public WebElement address1;
	
	@FindBy(id="address2")
	public WebElement address2;
	
	@FindBy(id="city")
	public WebElement city;
	
	@FindBy(id="postcode")
	public WebElement postcode;
	
	@FindBy(id="phone_mobile")
	public WebElement phoneNo;
	
	@FindBy (id="alias")
	public WebElement addressalias;
	
	@FindBy (id="submitAccount")
	public WebElement register;
	
	@FindBy (xpath="//*[@id=\"columns\"]/div[1]/span[2]")
	public WebElement wishlist;
	
	@FindBy (xpath="//div[@id=\"center_column\"]/div[1]")
	public WebElement errorMessage;
	
	@FindBy (xpath="//a[@class='logout']")
	public WebElement signOut;
	
    @FindBy(xpath="//a[@class='account']")
    public WebElement account;
    
    @FindBy (id="SubmitCreate")
    public WebElement submittest;
    
    @FindBy (id="//*[@id=\\\"columns\\\"]/div[1]/span[2]")
    public WebElement registertest;
    
    @FindBy (xpath="//div[@class='alert alert-danger']/ol/li")
    public List  <WebElement> errorList;
	
    @FindBy (xpath="//div[@class='alert alert-danger']/ol/li")
    public WebElement error;
	
	
	
	
}
