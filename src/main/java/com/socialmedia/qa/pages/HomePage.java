package com.socialmedia.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.socialmedia.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory / Object Repository
	@FindBy(xpath="//p[text()=\"Sanveer's Social Media App\"]")
	private WebElement homeTextLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomeText() {
		return homeTextLink.getText(); 
	}
}
