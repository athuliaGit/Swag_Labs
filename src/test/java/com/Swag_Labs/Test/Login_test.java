package com.Swag_Labs.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Swag_Labs.qa.config.base;
import com.Swag_Labs_pages.LogIn_Page;

public class Login_test extends base {

	WebDriver driver;
	LogIn_Page page;

	@BeforeMethod
	public void setUp() {
		driver = in();
		page = new LogIn_Page(driver);

	}

	@Test
	public void test1() throws InterruptedException {
		page.ClickLogn();

	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
