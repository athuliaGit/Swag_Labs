package com.Swag_Labs.Test;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Swag_Labs.qa.config.base;
import com.Swag_Labs_pages.LogIn_Page;
import com.Swag_Labs_pages.cartPage;
import com.Swag_Labs_pages.productpage;

public class cartTest extends base {

	WebDriver driver;
	productpage prodPage;
	LogIn_Page page;
	cartPage cpage;
	ArrayList<String> itemArr;

	@BeforeMethod
	public void setUp() {
		driver = in();
		prodPage = new productpage(driver);
		page = new LogIn_Page(driver);
		page.ClickLogn();
		cpage = new cartPage(driver);
	}


	@Test
	public void Verify_Cart() throws InterruptedException {

		prodPage.sortProduct();
		prodPage.addToCart(prodPage.backPack);
		prodPage.addToCart(prodPage.fleeceJacket);
		cpage.clickBtn();
		itemArr = cpage.cartItems();

		if (itemArr.contains("Sauce Labs Backpack") && itemArr.contains("Sauce Labs Fleece Jacket")) {
			Reporter.log("Asserted selected items and items in the cart are same");
		} else {
			Assert.fail(
					"arry1 Assertion failed on products in the cart .MisMach between items selected and items in the cart");
		}

		cpage.RemoveItem();
		cpage.clickBtn();

		cpage.continue_shopping();
		prodPage.addToCart(prodPage.bolt_shirt);
		cpage.clickBtn();
		itemArr = cpage.cartItems();
		if (itemArr.contains("Sauce Labs Bolt T-Shirt") && itemArr.contains("Sauce Labs Fleece Jacket")) {
			Reporter.log("Asserted selected items and items in the cart are same");
		} else {
			Assert.fail(
					"aeey3Assertion failed on products in the cart .MisMach between items selected and items in the cart");
		}

		cpage.clickBtn();
		cpage.checkOut();

	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
