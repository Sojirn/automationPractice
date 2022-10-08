package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.demo.main.WebDriverManager;
import com.demo.utility.Waits;
import com.demo.utility.WebElementHandlers;

public class WishlistPage extends BasePage {

	public WishlistPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//li[@class='lnk_wishlist']/a")
	public WebElement accountWishlist;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr/td[5]/a")
	public WebElement wishlistlink;

	@FindBy(xpath = "//ul[@class='row wlp_bought_list']/li//img")
	public List<WebElement> productlist;

	@FindBy(xpath = "//ul[@class='row wlp_bought_list']/li//a")
	public List<WebElement> productlink;

	@FindBy(linkText = "My account")
	public WebElement accountlink;

	@FindBy(xpath = "//i[@class='icon-remove-sign']")
	public List<WebElement> deletelist;

	@FindBy(xpath = "//i[@class='icon-remove-sign']")
	public WebElement delete;

	@FindBy(xpath = "//h1[@itemprop='name']")
	public WebElement heading;

	public void wishlistNavigation() {
		WebElementHandlers.scroll(0, 1250);
		Waits.explicitWaitClickable(accountlink);
		WebElementHandlers.click(accountlink);
		Waits.waitForPageLoad();
		Waits.explicitWaitClickable(accountWishlist);
		WebElementHandlers.click(accountWishlist);
		Waits.waitForPageLoad();
		Waits.explicitWaitClickable(wishlistlink);
		WebElementHandlers.click(wishlistlink);
		WebElementHandlers.scroll(0, 1000);
		Waits.waitForPageLoad();
	}

	public boolean wishlistProductCheck(String itemExpected) {
		Waits.waitForPageLoad();
		List <WebElement> products=productlist;
		Waits.explicitWaitVisiblity(products.get(0));
		System.out.println(products.get(0).getAttribute("alt"));
		System.out.println(products.get(1).getAttribute("alt"));
		System.out.println("item is"+itemExpected);
		boolean found = false;
		for (WebElement item : productlist) {
			if (item.getAttribute("alt").equals(itemExpected)) {
				System.out.println(item.getAttribute("alt"));
				found = true;
				break;
			} else {
				found = false;
			}
		}
		return found;
	}

	public String deleteProduct(int index) {
		List<WebElement> productwishlist = productlist;
		String expproduct1 = WebElementHandlers.getAttribute(productwishlist.get(index), "alt");
		List<WebElement> deletetest = deletelist;
		Waits.explicitWaitClickable(delete);
		deletetest.get(0).click();
		Waits.explicitWaitClickable(productwishlist.get(index));
		return expproduct1;
	}

	public boolean verifyDelete(String product) {
		boolean delete = true;
		for (WebElement t : productlist) {
			{
			if (t.getAttribute("alt").equals(product)) {
				delete = false;
			} else {
				delete = true;
			}
		}
	}
		return delete;
	}
	public void productLinkClick() {
		WebDriverManager.waitForPageLoad();
		Waits.explicitWaitClickable(productlink.get(0));
		productlink.get(0).click();
		WebDriverManager.waitForPageLoad();
		Waits.explicitWaitVisiblity(heading);

	}

}