package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;

	public BasePage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		driver = driver2;
		PageFactory.initElements(driver, this);
	}

}
