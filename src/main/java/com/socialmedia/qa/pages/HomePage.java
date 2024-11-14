package com.socialmedia.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.socialmedia.qa.base.TestBase;

public class HomePage extends TestBase {
	
	WebDriver driver; 
	
	//Page Factory / Object Repository
	@FindBy(xpath="//p[text()=\"Sanveer's Social Media App\"]")
	private WebElement homeTextLink;
	
	@FindBy(xpath="//input[@placeholder='What's on your mind...']")
	private WebElement postInputField; 
		
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomeText() {
		return homeTextLink.getText(); 
	}
	
	public boolean isHomeTextDisplayed() {
		return homeTextLink.isDisplayed();
	}
	
	public String getHomeTitle() {
		return driver.getTitle();
	}
}
