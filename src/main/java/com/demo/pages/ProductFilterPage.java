package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFilterPage extends ProductsPage{

	public ProductFilterPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath="//table[@class=\"table-data-sheet\"]/tbody/tr/td[2]")
	public WebElement detailcotton;

	
	
	

}
