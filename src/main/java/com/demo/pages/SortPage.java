package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class SortPage extends BasePage{

	public SortPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (linkText="WOMEN")
	 public WebElement womenLink;
	
	@FindBy (id="selectProductSort")
	public WebElement sort;
	
	@FindBy  (xpath="//*[@class=\"right-block\"]/div[1]/span[1]")
	public List <WebElement> sortResults;
	
	@FindBy (xpath="//div[@id=\"layered_ajax_loader\"]/p/img")
	public WebElement loader;
	
	@FindBy (xpath="//h1[@class='page-heading product-listing']")
	public WebElement pageHeading;
	

}
