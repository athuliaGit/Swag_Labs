package com.Swag_Labs.qa.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {
static WebDriver driver;
static WebElement element;	
	public static WebElement waitForElement(By locator,int timeOut) {
		
		WebDriverWait wait=new WebDriverWait(driver, timeOut);
		try {
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return element;
	}
}
