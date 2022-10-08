package com.demo.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.demo.main.WebDriverManager;
import com.demo.utility.Utility;
import com.demo.utility.Waits;
import com.demo.utility.WebElementHandlers;

public class ProductsPage extends BasePage{

	public ProductsPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (linkText="T-SHIRTS")
	 public WebElement tshirtLink;
	
	@FindBy (xpath="//*[@id=\"ul_layered_id_attribute_group_1\"]/li[3]")
	public WebElement large;
	
	@FindBy (xpath="//*[@id=\"ul_layered_id_attribute_group_3\"]/li[1]")
	public WebElement blue;
	
	@FindBy (xpath="//*[@id=\"ul_layered_id_feature_5\"]/li[1]")
	public WebElement cotton;
	
	@FindBy (id="layered_id_feature_11")
	public WebElement casual;
	
	@FindBy (id="layered_id_feature_17")
	public WebElement shrtSleeve;
	
	@FindBy (id="layered_quantity_1")
	public WebElement inStock;
	
	@FindBy (id="layered_manufacturer_1")
	public WebElement manufacturer;
	
	@FindBy (id="layered_condition_new")
	public WebElement newcoll;
	
	@FindBy (xpath="//*[@id=\"center_column\"]/ul/li/div")
	public WebElement tshirtProduct;
	
	/*@FindBy (className="button ajax_add_to_cart_button btn btn-default")
	public WebElement AddtoCart;*/
	
	@FindBy (xpath="//*[@id=\"center_column\"]/h1/span[1]")
	public WebElement tshirtText;

	@FindBy (xpath="//div[@id='layered_ajax_loader'][contains(@style,opacity)]")
	public WebElement loader;
			
	@FindBy (id="quantity_wanted")
	public WebElement quantitytest;
	
	@FindBy (xpath="//p[@id=\"add_to_cart\"]/button/span")
	public WebElement AddtoCart;
	

	@FindBy(xpath="//div[@class=\"button-container\"]/a")
	public WebElement checkOut;
	
	@FindBy(xpath="//div[@class=\"layer_cart_product col-xs-12 col-md-6\"]/h2")
	public WebElement productSuccessmsg;
	
	@FindBy (xpath="//div[@class=\"button-container\"]/a")
	public WebElement proceedCheckout;
	
	@FindBy (xpath="//p[@class=\"cart_navigation clearfix\"]/a")
	public WebElement sumCheckout;
	
	@FindBy (className="\"form-control\"")
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
	
	@FindBy (xpath="//div[@class='box order-confirmation']/strong[3]")
	public WebElement ordermailtext;
	
	@FindBy (xpath="//i[@class=\"icon-plus\"]")
    public WebElement quantityinc;
	
	@FindBy (xpath="//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a")
	 public WebElement womenLink;
	
	@FindBy (xpath="//*[@class='product_list grid row']/li//img")
	public List <WebElement> searchResults;
	
	@FindBy  (xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div")
	public  WebElement firstProduct;
	
	@FindBy (xpath="//*[@class='product_list grid row']/li")
	public List <WebElement> searchpResults;
	
	@FindBy (xpath="//span[@class='continue btn btn-default button exclusive-medium']")
	public WebElement continueShopping;
	
	@FindBy (xpath="//a[@class='button ajax_add_to_cart_button btn btn-default']")
	public WebElement moverAddtoCart;
	
	@FindBy (xpath="//a[@class='button ajax_add_to_cart_button btn btn-default']")
	public List<WebElement> moverAddtoCart_SK;
	
	@FindBy (xpath="//*[@class='product_list grid row']/li/div")
	public List <WebElement> searchcottonResults;
	
	@FindBy (xpath="//a[@class='button lnk_view btn btn-default']/span")
	public WebElement moreButton_sk;
	
	@FindBy (xpath="//a[@class='button lnk_view btn btn-default']/span")
	public List <WebElement> moreButton;
	
	@FindBy (xpath="//div[@class='wishlist']")
	public WebElement wishlist;
	
	@FindBy (xpath="//div[@class='wishlist']")
	public List <WebElement> wishlisttest;
	
	@FindBy (xpath="//a[@title='Close']")
	public WebElement wishlistClose;
	
	@FindBy (xpath="//p[@class='fancybox-error']")
	public WebElement wishlistAlert;
	
	@FindBy(xpath = "//table[@class=\"table-data-sheet\"]/tbody/tr/td[2]")
	public WebElement detailcotton;
	
	@FindBy (xpath="//*[@class='product_list grid row']/li//a")
	public WebElement tshirt;
	
	WebDriverManager objWebDriver;
	
	public void selectCategoryWomen()
	{   

		Waits.explicitWaitClickable(womenLink);
		WebElementHandlers.elementClick(womenLink);
		WebDriverManager.waitForPageLoad();
		WebElementHandlers.scroll(0, 1000);
	}
	
	public WebElement getProduct(int i) {
		Waits.waitForPageLoad();
		return searchpResults.get(i);
		
	}
	
	public String productName(int index)
	{
		String productname=searchResults.get(index).getAttribute("alt");
		
		return productname;
		
	}
	public String addToWishList(int itemIndex,WebElement product)
	{
		Waits.waitForPageLoad();
		Waits.explicitWaitClickable(product);
	    Waits.explicitWaitClickable(product);
		Actions action = new Actions(driver);
		action.moveToElement(product).build().perform();
		WebElementHandlers.actionsMove(product);
        Waits.explicitWaitClickable(wishlist);
        WebElementHandlers.click(wishlisttest.get(itemIndex));
        Waits.explicitWaitClickable(wishlistAlert);
        String alertText = wishlistAlert.getText();
        System.out.println(alertText);
        return alertText;
        
	}
	
	public Boolean verifyWishListSuccessMessage(String message,String alertText) {
			Actions action = new Actions(driver);
			action.moveToElement(wishlistClose).build().perform();
			Waits.explicitWaitClickable(wishlistClose);
			WebElementHandlers.click(wishlistClose);
			/*JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", wishlistClose);*/
			Waits.explicitWaitInvisiblity(wishlistClose);
			return alertText.equals(message);
	}
	public Boolean verifyWishListNonSuccessMessage(String message,String alertText) {
	    Waits.explicitWaitClickable(wishlistAlert);
		Waits.explicitWaitClickable(wishlistClose);
		WebElementHandlers.click(wishlistClose);
		return alertText.equals(message);
}
	public void applyMaterialFilter(String material)
	{
		
		WebElementHandlers.click(getMaterialFilter(material));
		WebDriverManager.scroll(0, 500);
		Waits.explicitWaitInvisiblity(loader);
		WebDriverManager.waitForPageLoad();
	}
	
	public WebElement getMaterialFilter(String option) {
		WebElement filterOption = null;
		if (option.equals("cotton")){
			filterOption = cotton;
		}
		return filterOption;
	}
	
	public void viewProduct(int i) {
		WebElement product = searchcottonResults.get(i);
		Waits.explicitWaitVisiblity(product);
		WebElementHandlers.actionsMove(product);
        clickViewMore(i);
		WebDriverManager.waitForPageLoad();
	}
	
    public void clickViewMore(int i) {
    	Waits.explicitWaitClickable(moreButton.get(i));
		WebElementHandlers.click(moreButton.get(i));
		WebDriverManager.waitForPageLoad();
    }
    
	public boolean verifyMaterialFilter(String option)
	{
		int productsize = searchcottonResults.size();
		boolean filter=false;
		for (int i = 0; i <productsize; i++) {
			viewProduct(i);
			if (detailcotton.getText().contains(option)) {
				System.out.println(detailcotton.getText());
				filter = true;
			} else {
				return false;
			}

			navigateBack();
			WebDriverManager.waitForPageLoad();
		}
		return filter;
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void selectCategory(String Category)
	{   
		if(Category.equals("Tshirts"))
		{
		Waits.explicitWaitClickable(tshirtLink);
		WebElementHandlers.elementClick(tshirtLink);
		}
		WebDriverManager.waitForPageLoad();
		WebElementHandlers.scroll(0, 1000);
	}
	public String verifyTshirtselection() 
	{
	WebElement te = tshirtText;
	Waits.explicitWaitVisiblity(te);
	String tshirt = te.getText();
	return tshirt;
	
	}
	public void productSelection()
	{
			WebElementHandlers.click(large);
	        Waits.explicitWaitInvisiblity(loader);
			WebElementHandlers.click(blue);
			Waits.explicitWaitInvisiblity(loader);
			WebElementHandlers.click(cotton);
			Waits.explicitWaitInvisiblity(loader);
			WebElementHandlers.click(casual);
			Waits.explicitWaitInvisiblity(loader);
			WebElementHandlers.click(shrtSleeve);
			Waits.explicitWaitInvisiblity(loader);
			WebElementHandlers.click(manufacturer);
			WebElementHandlers.scroll(0,250);
			Waits.explicitWaitInvisiblity(loader);
			WebElementHandlers.click(newcoll);
			Waits.explicitWaitInvisiblity(loader);
			
}
	public String productAddToCart()
	{
		Waits.explicitWaitInvisiblity(loader);
		WebElementHandlers.jsClick(tshirt);
		WebDriverManager.waitForPageLoad();
		Waits.explicitWaitVisiblity(quantitytest);
		WebElementHandlers.sendText(quantitytest,"2");
		WebElementHandlers.scroll(0, 500);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", AddtoCart);
		WebElementHandlers.click(AddtoCart);
        Waits.explicitWaitVisiblity(checkOut);
        String displayedMsg = productSuccessmsg.getText();
		
		return displayedMsg;
		}
	
	public boolean verifyCategoryTshirtSelection(String expectedText)
	{
		boolean verify=verifyTshirtselection().contains(expectedText);
		return verify;
	}
	public void CheckOutRedirection()
	{
		WebElementHandlers.click(proceedCheckout);
		WebDriverManager.waitForPageLoad();
	}
	public void ContinueShopping(int index)
	{
		List<WebElement> product = searchpResults;
		WebElement productTest = product.get(index);
		Waits.explicitWaitVisiblity(productTest);
		Actions action=new Actions(driver);
		action.moveToElement(productTest).build().perform();
		WebElementHandlers.actionsMove(productTest);
		Waits.explicitWaitClickable(moverAddtoCart);
		WebElementHandlers.click(moverAddtoCart_SK.get(index));
		Waits.explicitWaitClickable(continueShopping);
		WebElementHandlers.click(continueShopping);
		
	}
	public boolean verifyContinueShopping(int index)
	{
	Waits.explicitWaitClickable(searchpResults.get(index));
	if(searchpResults.get(index).isDisplayed())
	{
	return true;
	}
	else
	{
		return false;
	}
	}
	public void carttoCheckOut(int index) {
	List<WebElement> product = searchpResults;
	WebElement productTest = product.get(index);
	Waits.explicitWaitVisiblity(productTest);
	Actions action=new Actions(driver);
	action.moveToElement(productTest).build().perform();
	WebElementHandlers.actionsMove(productTest);
	Waits.explicitWaitClickable(moverAddtoCart);
	WebElementHandlers.click(moverAddtoCart_SK.get(index));
	Waits.explicitWaitClickable(checkOut);
	checkOut.click();
	WebDriverManager.waitForPageLoad();
	}
}
	

