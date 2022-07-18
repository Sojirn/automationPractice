package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	public WebElement TshirtText;

	@FindBy (xpath="//div[@id=\"layered_ajax_loader\"]/p/img")
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
	
}
