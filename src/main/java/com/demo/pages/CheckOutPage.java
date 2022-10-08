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
	
	public String deleteProductFromCart(int index)
	{
		WebDriverManager.waitForPageLoad();
		Waits.explicitWaitClickable(productlist.get(index));
		String productName=WebElementHandlers.getAttribute(productlist.get(1),"alt");
		Waits.explicitWaitClickable(deleteproducts.get(index));
		WebElementHandlers.click(deleteproducts.get(index));
		System.out.println(productName);
		return productName;
	}
	public boolean verifyDelete(String expected, String attribute) {
		boolean found = false;
		for (WebElement t : productlist) {
			if (t.getAttribute(attribute).contains(expected)) {
				found = false;
				break;
			} else {
				found = true;
			}
		}
		return found;

	}
	public String verifyCheckOutNavigation()
	{
	WebDriverManager.waitForPageLoad();
	WebDriverManager.scroll(0, 500);

	try {
		Waits.explicitWaitVisiblity(sumCheckout);
	} catch (Exception e) {
		System.out.print("hello " + e.getMessage());
	}
	String displaySummary=WebElementHandlers.getText(summaryhead);
	return displaySummary;
	}
	public int clickIncrement()
	{
	WebDriverManager.waitForPageLoad();
	int qntyCurrent = Integer.parseInt(qntydisplayed.getAttribute("Value"));
	quantityinc.click();
	driver.navigate().refresh();
	return qntyCurrent;
	}
	public int verifyQuantityIncrement()
	{ 
		WebDriverManager.waitForPageLoad();
		int actualQnty= Integer.parseInt(qntydisplayed.getAttribute("Value"));
		return actualQnty;
	}
	public double getUnitPrice()
	{
	WebDriverManager.waitForPageLoad();
	double unitPrice = Utility.getPrice(UnitPrice);
	return unitPrice;
	}
	public double getqty()
	{
	double actualQnty = Double.parseDouble(qntydisplayed.getAttribute("Value"));
	return actualQnty;
	}
	public double totalPriceExpected(double qnty,double unitPrice)
	{
	double totalPriceExpected = qnty * unitPrice;
	return  totalPriceExpected;
	}
	public double actualTotalPrice()
	{
	double actualTotalPrice = Utility.getPrice(totPrice);
	return actualTotalPrice;
	}
	public void addressSectionNavigation()
	{
	WebDriverManager.waitForPageLoad();
	WebElementHandlers.click(sumCheckout);
	WebDriverManager.waitForPageLoad();
	Waits.explicitWaitVisiblity(addCheckout);
	}
	public void enterMessage(String message)
	{
		WebElementHandlers.sendText(msgBox,message);
	}
	public void shippingSectionNavigation()
	{
	WebElementHandlers.click(addCheckout);
    Waits.explicitWaitVisiblity(shipCheckout);
    WebElementHandlers.click(checkterms);
    WebDriverManager.waitForPageLoad();
	}
	public void paymentSectionNavigation() {
	WebElementHandlers.click(shipCheckout);
	Waits.explicitWaitVisiblity(paycheck);
	WebElementHandlers.click(paycheck);
	WebDriverManager.waitForPageLoad();
	}
	public void confirmOrder()
	{
	
	Waits.explicitWaitVisiblity(confirmOrder);
	WebElementHandlers.click(confirmOrder);
	}
	public String verifyConfirmOrder()
	{
	Waits.explicitWaitVisiblity(ordermailtext);
	String orderConfirmationMsg=WebElementHandlers.getText(ordermailtext);
	return orderConfirmationMsg;
	}

}