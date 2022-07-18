package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.main.WebDriverManager;
import com.demo.pages.ProductsPage;
import com.demo.pages.WishlistPage;
import com.demo.utility.Utility;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class WishlistTest extends WebDriverManager{
	ProductsPage objProduct;
	WishlistPage objWishlist;
  @Test(priority=14)
  public void wishlistlogin() {
	  boolean found=false;
	  objProduct=new ProductsPage(driver);
	  objWishlist=new WishlistPage(driver);
	  explicitWaitClickable(objProduct.womenLink);
	  elementClick( objProduct.womenLink);
	  waitForPageLoad();
	  Scroll(0,1000);
	  List <WebElement> product=objProduct.searchpResults;
	  WebElement producttest=product.get(0);
	  List <WebElement> productwishlist=objProduct.searchResults;
	  String expproduct1=productwishlist.get(0).getAttribute("alt");
	  System.out.println(expproduct1);
	  Actions action=new Actions(driver);
	  action.moveToElement(producttest).build().perform();
	 
	  explicitWaitClickable(objProduct.wishlist);
	  objProduct.wishlisttest.get(0).click();
	  explicitWaitClickable(objProduct.wishlistAlert);
	  String alertText=objProduct.wishlistAlert.getText();
	 
	  String expectedText="Added to your wishlist.";
	  explicitWaitClickable(objProduct.wishlistClose);
	  Utility.waitfor(15);
	  
	  Assert.assertTrue(alertText.contains(expectedText), "Wishlist not success");
	  
	  
	  objProduct.wishlistClose.click(); 
	  Utility.waitfor(15);
	  Scroll(0,1250);
	  explicitWaitClickable(objWishlist.accountlink);
	  objWishlist.accountlink.click();
	  waitForPageLoad();
	  explicitWaitClickable(objWishlist.accountWishlist);
	  objWishlist.accountWishlist.click();
	  waitForPageLoad();
	  explicitWaitClickable(objWishlist.wishlistlink);
	  objWishlist.wishlistlink.click();
	  Utility.waitfor(10);
	  Scroll(0,1000);
	  List <WebElement> products=objWishlist.productlist;
	  for(WebElement t:products)
	  {
		  System.out.println(t.getAttribute("alt"));
		 if( t.getAttribute("alt").equals(expproduct1))
				 {
			     found=true;
				 
				 break;
	  }
	else
				 {
					 found=false;
				 }
	  }
	  Assert.assertTrue(found);	  
  }
  
  @Test(priority=15)
  public void wishlistdelete() {
	  objProduct=new ProductsPage(driver);
	  objWishlist=new WishlistPage(driver);
	  boolean delete=false;
	  List <WebElement> productwishlist=objWishlist.productlist;
	  String expproduct1=productwishlist.get(0).getAttribute("alt");
	  List <WebElement> deletetest=objWishlist.deletelist;
	  explicitWaitClickable(objWishlist.delete);
	  deletetest.get(0).click();
	  
	  for(WebElement t: productwishlist)
	  {
		  if( t.getAttribute("alt").contains(expproduct1))
		  {
			  delete=false;
		  }
		  else
		  {
			  delete=true;
		  }
	  }
	  Assert.assertTrue(delete);
	  
  }
  @Test(priority=16)
  
  public void wishlistdirection() {
	  objProduct=new ProductsPage(driver);
	  objWishlist=new WishlistPage(driver);
	  
	  List <WebElement> productwishlist=objWishlist.productlist;
	 productwishlist.get(0).click();
	 waitForPageLoad();
	 explicitWaitvisiblity(objWishlist.heading);
	 String expectedURL="http://automationpractice.com/index.php?id_product=1&controller=product";
	 String actualUrl=driver.getCurrentUrl();
	 Assert.assertEquals(expectedURL,actualUrl);
	  
	  
	  
  }
  
  @Test(priority=17)
  public void wishlistnotlogin() {
	  objProduct=new ProductsPage(driver);
	  explicitWaitClickable(objProduct.womenLink);
	  elementClick( objProduct.womenLink);
	  waitForPageLoad();
	  Scroll(0,1000);
	  List <WebElement> product=objProduct.searchpResults;
	  WebElement producttest=product.get(0);
	  Actions action=new Actions(driver);
	  action.moveToElement(producttest).build().perform();
	 
	  explicitWaitClickable(objProduct.wishlist);
	  objProduct.wishlisttest.get(0).click();
	  explicitWaitClickable(objProduct.wishlistAlert);
	  String ActualText=objProduct.wishlistAlert.getText();
	  String expectedText="You must be logged in to manage your wishlist.";
	  Assert.assertTrue(ActualText.contains(expectedText), "Wishlist success"); 
	  
	  objProduct.wishlistClose.click(); 
	  
  }
  @BeforeTest
  public void beforeTest() {
	  //this.driver=launchBrowser();
  }

  @AfterTest
  public void afterTest() {
  }

}
