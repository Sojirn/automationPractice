package com.demo.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.demo.main.WebDriverManager;

import com.demo.utility.Waits;
import com.demo.utility.WebElementHandlers;

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
    
	@FindBy(xpath = "//li[@class='lnk_wishlist']/a")
	public WebElement accountWishlist;
	
    public void login(String[] userData)
    {
    	WebDriverManager.waitForPageLoad();
		WebElementHandlers.click(signIn);
		WebElementHandlers.sendText(email, userData[0]);
		WebElementHandlers.sendText(password, userData[1]);
		Waits.explicitWaitClickable(submit);
		WebElementHandlers.click(submit);
    }
    
	public 	WebElement validlogin() 
    {
    	Waits.explicitWaitVisiblity(wishlist);
    	return wishlist;
    }
	
	public 	String inValid() 
    {
    	Waits.explicitWaitVisiblity(email);
    	String ActualMsg = WebElementHandlers.getText(errorMessage);
    	return ActualMsg;
    }
	public void  signOutClick()
	{
	  WebElementHandlers.click(signOut);
	  WebDriverManager.waitForPageLoad();
	   Waits.explicitWaitVisiblity(password);
	}
	public boolean verifySignout(String expectedText)
	{
		String actualText=signIn.getText();
		boolean verified=false;
		if(actualText.contains(expectedText))
		{
			verified=true;
		}
		else
		{
			verified=false;
		}
		return verified;
			
	}
	
	public void accessSignInPage() {
		WebElementHandlers.click(signIn);
		WebDriverManager.waitForPageLoad();
	}
	
	public void enterEmail(String email)
	{
		Waits.explicitWaitVisiblity(createEmail);
		WebElementHandlers.sendText(createEmail, email);
	}
	
	public void clickCreateAccount() {
		WebElementHandlers.click(createAccount);
		WebDriverManager.waitForPageLoad();
	}
	
	public void enterAccountDetails(HashMap<String,String> account ) {
		WebElementHandlers.click(gender);
		WebElementHandlers.sendText(firstName,account.get("firstname"));
		WebElementHandlers.sendText(secondName, account.get("secondname"));
		WebElementHandlers.sendText(accntPassword,account.get("accntPassword"));
		WebElementHandlers.click(newsletter);
		WebElementHandlers.sendText(address1,account.get("address1"));
		WebElementHandlers.sendText(city,account.get("city"));
		WebElementHandlers.sendText(postcode, account.get("postalcode"));
		WebElementHandlers.dropDown(state).selectByValue("2");
		WebElementHandlers.sendText(phoneNo, account.get("phone"));
		
	}
	public void clickRegister()
	{
		WebElementHandlers.click(register);
		WebDriverManager.waitForPageLoad();
		
	}
	public WebElement verifyRegisterAccount()
	{
		Waits.explicitWaitVisiblity(accountWishlist);
		return accountWishlist;
	}
	public WebElement verifyInvalidPostalCode()
	{
		Waits.explicitWaitVisiblity(submittest);
		return submittest;
	}
	public boolean verifyErrorMessage(String expected)
	{
		Waits.explicitWaitVisiblity(error);
		List<WebElement> errors = errorList;
		boolean errorDisplayed = false;
		for (WebElement t : errors) {
			String te = t.getText();
			if (te.equalsIgnoreCase(expected)) {
				errorDisplayed = true;
				break;
			}
		}
		return errorDisplayed;
	}
	public boolean verifyEmailEntered(String emailExpected)
	{
		return WebElementHandlers.getAttribute(email, "Value").equals(WebElementHandlers.getAttribute(email, "Value"));
	}
	public void enterInvalidAccountDetails(HashMap<String,String> account)
	{
		WebElementHandlers.click(gender);
		WebElementHandlers.sendText(firstName,account.get("firstname"));
		WebElementHandlers.sendText(secondName, account.get("secondname"));
		WebElementHandlers.sendText(accntPassword,account.get("accntPassword"));
		WebElementHandlers.dropDown(days).selectByValue("3");
		WebElementHandlers.dropDown(months).selectByValue("3");
		WebElementHandlers.dropDown(years).selectByValue("2020");
		WebElementHandlers.click(newsletter);
		WebElementHandlers.sendText(postcode, "00");
		
	}
	
}
