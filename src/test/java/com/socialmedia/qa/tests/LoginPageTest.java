package com.socialmedia.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.socialmedia.qa.base.TestBase;
import com.socialmedia.qa.pages.HomePage;
import com.socialmedia.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initializeDriver(); 
		loginPage = new LoginPage(); 
	}
	
	@Test(priority=2)
	public void loginTest() {
		homePage = loginPage.login("test@test.com", "testing123");
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, "React App");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
