package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.main.WebDriverManager;
import com.demo.utility.Utility;

public class ProductDetailPage extends ProductsPage {

	public ProductDetailPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//table[@class=\"table-data-sheet\"]/tbody/tr/td[2]")
	public WebElement detailcotton;
	WebDriverManager objWebDriver;

}
