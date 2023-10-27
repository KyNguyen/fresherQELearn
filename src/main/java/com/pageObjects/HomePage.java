package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// All objects should be defined here
	private By menuBtn = By.cssSelector("a[id='menu-toggle']");
	private By login = By.cssSelector("a[href*='login']");
	private By labelUserName = By.id("userName-label");
	private By footer = By.cssSelector("footer");
	
	
	// All methods should be defined here
	public WebElement getMenuBtn() {
		return driver.findElement(menuBtn);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getLabelUserName() {
		return driver.findElement(labelUserName);
	}
	
	public WebElement getFooter() {
		return driver.findElement(footer);
	}

}
