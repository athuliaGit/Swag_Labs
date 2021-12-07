package com.Swag_Labs_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Info {
    public WebDriver driver;
	@FindBy(xpath="//input[@id='first-name']")
	WebElement firstName;
	@FindBy(css="#last-name")
	WebElement lastName;
	@FindBy(css="#postal-code")
	WebElement postalCode;
	@FindBy(css="#continue")
	WebElement continuelnk;
	public Info(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
		}
	public void VerifyInfo(String fName,String lName,String postal_Code) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		postalCode.sendKeys(postal_Code);
	}
	public void click_continueLnk() {
		continuelnk.click();	
	}
}
