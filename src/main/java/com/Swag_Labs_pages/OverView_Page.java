package com.Swag_Labs_pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.Swag_Labs.qa.config.base;

public class OverView_Page extends base {


	public WebDriver driver;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Fleece Jacket')]")
	WebElement jacket;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")
	WebElement t_shirt;
	@FindBy(xpath = "//div[@class='summary_total_label']")
	WebElement total_price;
	@FindBy(xpath = " //div[@class='summary_subtotal_label']")
	WebElement sub_total;
	@FindBy(xpath = "//div[@class='summary_tax_label']")
	WebElement tax;

	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Fleece Jacket')]//parent::a//following-sibling::div[2]/div")
	WebElement jacket_unitPrice;
	

	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Bolt T-Shirt')]//parent::a//following-sibling::div[2]/div")
	WebElement Shirt_unitPrice;
	

	public OverView_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    public Double calculateTax() {
    	Double taX_total=converttoInt(tax.getText(),6,10);
		return taX_total;
    }
	public Double calculate_Total() {
		
		Double sub_Total=converttoInt(sub_total.getText(),13,18);
		Double taX_total=converttoInt(tax.getText(),6,10);
		return sub_Total+taX_total;
	}

	public Double total() {
		//Total: $71.26
		total_price.getText();
		Double total=converttoInt(total_price.getText(),8,13);
		return total;

	}
    public ArrayList<String> cartItems() {
    	ArrayList<String> item_List = new ArrayList<String>();
    	List<WebElement> items=driver.findElements(By.xpath("//div[@class='cart_list']//a/div"));
    	
    	for(WebElement e:items) {
    		item_List.add(e.getText());
    	}
    	
    	return item_List;
    }
	
	public Double converttoInt(String s,int begIndex,int endIndex) {
		
		String str=s.substring(begIndex,endIndex);
		Double value=Double.valueOf(str);
		return value;
		
	}
	
	
	public Double unitPricecal() {
		 
		Double shirt_price=converttoInt(Shirt_unitPrice.getText(),1,6);
	    Double jacket_price=converttoInt(jacket_unitPrice.getText(),1,6);
	   Double total_unitPrice= shirt_price +jacket_price;
		return total_unitPrice;
		
}
}
