package com.socialmedia.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.socialmedia.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory / Object Repository
	@FindBy(name="email")
	private WebElement emailField; 
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[text()='LOGIN']")
	private WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
		
		return new HomePage(); 
	}
}
