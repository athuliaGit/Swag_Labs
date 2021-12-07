package com.Swag_Labs.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Swag_Labs.qa.config.base;
import com.Swag_Labs_pages.LogIn_Page;
import com.Swag_Labs_pages.productpage;

public class productTest extends base {
	WebDriver driver;
	productpage prodPage;
	LogIn_Page page;

	@BeforeMethod
	public void setUp() {

		driver = in();
		prodPage = new productpage(driver);
		page = new LogIn_Page(driver);
		page.ClickLogn();
	}

	@Test
	public void test1() {

		prodPage.sortProduct();
		prodPage.addToCart(prodPage.backPack);
		prodPage.addToCart(prodPage.fleeceJacket);
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
