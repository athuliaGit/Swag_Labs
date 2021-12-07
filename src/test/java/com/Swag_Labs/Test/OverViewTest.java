package com.Swag_Labs.Test;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Swag_Labs.qa.config.base;
import com.Swag_Labs_pages.Info;
import com.Swag_Labs_pages.LogIn_Page;
import com.Swag_Labs_pages.OverView_Page;
import com.Swag_Labs_pages.cartPage;
import com.Swag_Labs_pages.productpage;

public class OverViewTest extends base{

	WebDriver driver;
	productpage prodPage;
	LogIn_Page page;
	cartPage cpage;
	OverView_Page overView;
	Info vInfo;
	@BeforeMethod
	public void setUp() {
		driver = in();
	    prodPage=new productpage(driver);
	    page=new LogIn_Page(driver);
		page.ClickLogn();
		cpage=new cartPage(driver);
	}
	@Test
	public void Verify_TotaLPrice () throws InterruptedException {
		prodPage.sortProduct();
		prodPage.addToCart(prodPage.backPack);
		prodPage.addToCart(prodPage.fleeceJacket);
		cpage.clickBtn();
		cpage.RemoveItem();
		cpage.continue_shopping();
		prodPage.addToCart(prodPage.bolt_shirt);
		cpage.clickBtn();
		cpage.checkOut();
		 vInfo=new Info(driver);
		 vInfo.VerifyInfo("FirstName", "Lastname", "53532");
		 vInfo.click_continueLnk();
		overView =new OverView_Page(driver);
		Double cal_total=overView.calculate_Total();
		Double total_Amount=overView.total();
		//Asserting  total Amount againt (tax + SubTotal)
		Assert.assertEquals(total_Amount, cal_total);
		
	}
	@Test
	public void Verify_UnitPrice () throws InterruptedException {
		prodPage.sortProduct();
		prodPage.addToCart(prodPage.backPack);
		prodPage.addToCart(prodPage.fleeceJacket);
		cpage.clickBtn();
		cpage.RemoveItem();
		cpage.continue_shopping();
		prodPage.addToCart(prodPage.bolt_shirt);
		cpage.clickBtn();
		cpage.checkOut();
		 vInfo=new Info(driver);
		 vInfo.VerifyInfo("FirstName", "Lastname", "53532");
		 vInfo.click_continueLnk();
		overView =new OverView_Page(driver);
		
		Double Total_unitPrice=overView.unitPricecal();
		Double total_tax=overView.calculateTax();
		Double calculated_Total=Total_unitPrice+total_tax;
		Double total_Amount=overView.total();
		//Asserting  total Amount againt (tax + UnitPrice)
		Assert.assertEquals(total_Amount, calculated_Total);
		
	}
	@Test
	public void Verify_Cart() throws InterruptedException {
	    
		prodPage.sortProduct();
		prodPage.addToCart(prodPage.backPack);
		prodPage.addToCart(prodPage.fleeceJacket);
		cpage.clickBtn();
		cpage.RemoveItem();
		cpage.continue_shopping();
		prodPage.addToCart(prodPage.bolt_shirt);
		cpage.clickBtn();
		cpage.checkOut();
		 vInfo=new Info(driver);
		 vInfo.VerifyInfo("FirstName", "Lastname", "53532");
		 vInfo.click_continueLnk();
		overView =new OverView_Page(driver);
		ArrayList<String> itemArr=overView.cartItems();
		if(itemArr.contains("Sauce Labs Bolt T-Shirt")&&itemArr.contains("Sauce Labs Fleece Jacket")) {
			Reporter.log("Asserted selected items and items in the cart are same");
		}
		else {
			Assert.fail("Assertion failed on products in the cart .MisMach between items selected and items in the cart");
		}
		
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
