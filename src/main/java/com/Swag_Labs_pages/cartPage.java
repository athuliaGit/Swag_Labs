package com.Swag_Labs_pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {
WebDriver driver;
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement cartLink;
	@FindBy(xpath="//div[@class='cart_item_label']//button")
	WebElement removeItem;
	@FindBy(id="continue-shopping")
	WebElement shoppingLnk;
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkOutlnk;
	
	public cartPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
		
	}
	public void  clickBtn() {
		cartLink.click();	
	}
	public void RemoveItem() {
		removeItem.click();	
	}
	 public void continue_shopping() {
		 shoppingLnk.click(); 
		 
	 }
	 public void checkOut() {
		 checkOutlnk.click(); 
		 
	 }
	 public ArrayList<String> cartItems() {
	    	ArrayList<String> item_List = new ArrayList<String>();
	    	List<WebElement> items=driver.findElements(By.xpath("//div[@class='cart_list']//a/div"));
	    	
	    	for(WebElement e:items) {
	    		item_List.add(e.getText());
	    	}
	    	System.out.println(item_List.size());
	    	return item_List;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
