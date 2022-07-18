package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.main.WebDriverManager;
import com.demo.pages.ContactUspage;
import com.demo.utility.Utility;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ContactUsTest extends WebDriverManager {
	ContactUspage objContactUs;

	@Test(priority = 1, enabled = false)
	public void contactnotlogin() throws InterruptedException {
		objContactUs = new ContactUspage(driver);
		Utility.waitfor(15);
		objContactUs.contact.click();
		Utility.waitfor(15);
		explicitWaitvisiblity(objContactUs.heading);
		dropDown(objContactUs.subject).selectByIndex(1);
		objContactUs.email.sendKeys("test@gmail.com");
		objContactUs.orderinput.sendKeys("34232243");
		objContactUs.upload.sendKeys("D:\\Selenium\\Pictures\\test.pdf");
		objContactUs.msg.sendKeys("Test for msg");
		objContactUs.button.click();
		String expected = "Your message has been successfully sent to our team.";
		String actual = objContactUs.alertMsg.getText();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	}

	@Test(priority = 12, enabled = true)
	public void contactlogin() throws InterruptedException {
		objContactUs = new ContactUspage(driver);
		Utility.waitfor(15);
		objContactUs.contact.click();
		Utility.waitfor(15);
		explicitWaitvisiblity(objContactUs.heading);
		dropDown(objContactUs.subject).selectByIndex(1);
		String orderid = dropDown(objContactUs.order).getOptions().get(2).getAttribute("value");
		dropDown(objContactUs.order).selectByIndex(2);
		Utility.waitfor(5);
		WebElement product = driver.findElement(By.id(orderid + "_order_products"));
		explicitWaitvisiblity(product);
		System.out.println("Dropdown options" + dropDown(product).getOptions());
		dropDown(product).selectByIndex(1);
		Utility.waitfor(5);
		objContactUs.upload.sendKeys("D:\\Selenium\\Pictures\\test.pdf");
		objContactUs.msg.sendKeys("Test for msg");
		objContactUs.button.click();
		String expected = "Your message has been successfully sent to our team.";
		String actual = objContactUs.alertMsg.getText();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	}

	@Test(priority = 13, enabled = false)
	public void contactvalidlogin() throws InterruptedException {
		objContactUs = new ContactUspage(driver);
		Utility.waitfor(15);
		objContactUs.contact.click();
		Thread.sleep(15);
		explicitWaitvisiblity(objContactUs.heading);
		dropDown(objContactUs.subject).selectByIndex(1);
		objContactUs.orderinput.sendKeys("34232243");
		objContactUs.upload.sendKeys("D:\\Selenium\\Pictures\\test.pdf");
		objContactUs.msg.sendKeys("Test for msg");
		objContactUs.button.click();
		String expected = "There is 1 error";
		String actual = objContactUs.alertdanger.getText();
		System.out.println(actual);
		Assert.assertTrue(actual.contains(expected));
	}


}
