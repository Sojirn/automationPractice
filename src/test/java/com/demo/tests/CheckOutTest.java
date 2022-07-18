package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.data.ConstantsData;
import com.demo.main.WebDriverManager;
import com.demo.pages.CheckOutPage;
import com.demo.pages.ProductsPage;
import com.demo.utility.Utility;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CheckOutTest extends WebDriverManager {
	CheckOutPage objCheckout;
	ProductsPage objProudct;

	@Test(priority = 5, enabled = true, groups = { "sanity" })
	public void checkoutsummary() {

		objCheckout = new CheckOutPage(driver);
		objProudct = new ProductsPage(driver);
		Utility.waitfor(5);

		Scroll(0, 500);

		try {
			explicitWaitvisiblity(objCheckout.sumCheckout);
		} catch (Exception e) {
			System.out.print("hello " + e.getMessage());
		}
		String displaysummary=getText(objCheckout.summaryhead);
		System.out.println("summary heading displayed" + displaysummary);
	}

	@Test(priority = 23)
	public void checkoutdelete() throws InterruptedException {
		List<WebElement> productlist = objCheckout.productlist;
		explicitWaitClickable(productlist.get(1));
		boolean notfound = false;
		String productname=getAttribute(productlist.get(1),"alt");
		//String productname = productlist.get(1).getAttribute("alt");
		System.out.println(productname);
		List<WebElement> delete = objCheckout.deleteproducts;
		explicitWaitClickable(delete.get(1));
		click(delete.get(1));
		//delete.get(1).click();
		Assert.assertFalse(isListContainsAttribute(productlist,productname,"alt"));
		/*for (WebElement del : productlist) {
			if (del.getAttribute("alt").equals(productname)) {
				notfound = false;
			} else {
				notfound = true;
			}
		}
		Assert.assertTrue(notfound);*/
	}

	@Test(priority = 6, enabled = true, groups = { "sanity" })
	public void checkoutsummaryquantity() throws InterruptedException {
		Utility.waitfor(5);
		int qntyCurrent = Integer.parseInt(objCheckout.qntydisplayed.getAttribute("Value"));
		objCheckout.quantityinc.click();
		driver.navigate().refresh();
		int qntyActual = Integer.parseInt(objCheckout.qntydisplayed.getAttribute("Value"));
		Assert.assertTrue(qntyActual == (qntyCurrent+1));
	}

	@Test(priority =7, enabled = true, groups = { "sanity" })
	public void checkoutsummaryprice() throws InterruptedException

	{
		Utility.waitfor(5);
		double unitprice = getPrice(objCheckout.UnitPrice);
		double qnty = Double.parseDouble(objCheckout.qntydisplayed.getAttribute("Value"));
		double totalPriceExpected = qnty * unitprice;
		double totalPriceActual = getPrice(objCheckout.totPrice);
		Assert.assertEquals(totalPriceExpected, totalPriceActual);

	}

	@Test(priority = 8, enabled = true, groups = { "sanity" })
	public void checkout() {
		Utility.waitfor(2);
		click(objCheckout.sumCheckout);
		explicitWaitvisiblity(objCheckout.addCheckout);
		String checkoutMsg=ConstantsData.CHECKOUT_MSG;
		sendText(objCheckout.msgBox,checkoutMsg);
		click(objCheckout.addCheckout);
        explicitWaitvisiblity(objCheckout.shipCheckout);
        click(objCheckout.checkterms);
        click(objCheckout.shipCheckout);
		explicitWaitvisiblity(objCheckout.paycheck);
		click(objCheckout.paycheck);
		explicitWaitvisiblity(objCheckout.confirmOrder);
		click(objCheckout.confirmOrder);
		explicitWaitvisiblity(objCheckout.ordermailtext);
		String displayedMsg=getText(objCheckout.ordermailtext);
		Assert.assertTrue(displayedMsg.contains(ConstantsData.ORDER_CONFIRMATION_MSG), "checkout not successfull");

	}


}
