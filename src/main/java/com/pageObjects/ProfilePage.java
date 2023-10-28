package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	
	public WebDriver driver;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}


	// All objects should be defined here
	private By userNameLbl = By.id("userName-value");
	private By logOutBtn = By.id("submit");


	// All methods should be defined here
	public WebElement getUserNameLbl() {
		return driver.findElement(userNameLbl);
	}

	public WebElement getLogOutBtn() {
		return driver.findElement(logOutBtn);
	}
}
