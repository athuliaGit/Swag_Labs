package com.Swag_Labs_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Swag_Labs.qa.config.base;
import com.Swag_Labs.qa.config.propConfig;

public class LogIn_Page extends base{
	WebDriver driver;
@FindBy(id="user-name")	
WebElement username;

@FindBy(id="password")
WebElement password;

@FindBy(id="login-button")
WebElement loginBtn;

public LogIn_Page(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

public void ClickLogn() {
	String pword=null;
	String uname = null;
	try {
		pword = propConfig.getpropertyKey("password");
		uname=propConfig.getpropertyKey("username");
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		
	username.sendKeys(uname);
	password.sendKeys(pword);
	System.out.println(pword+uname);
	loginBtn.click();
	
}
	
	

}
