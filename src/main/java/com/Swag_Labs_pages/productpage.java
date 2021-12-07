package com.Swag_Labs_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class productpage {
	WebDriver driver;
    @FindBy(xpath="//select[@class=\"product_sort_container\"]")
    public WebElement product_sort;
    
    @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement backPack;
    
    @FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
    public WebElement fleeceJacket;
    
    @FindBy(css="#add-to-cart-sauce-labs-bolt-t-shirt")
   public WebElement bolt_shirt;
    
    public productpage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
	
	public void sortProduct() {
		product_sort.click();
		Select select=new Select(product_sort);
		select.selectByValue("za");
	}
	public void addToCart(WebElement element) {
		element.click();
	}
	
	
}
