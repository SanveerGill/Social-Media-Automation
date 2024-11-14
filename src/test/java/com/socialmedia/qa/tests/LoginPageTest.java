package com.socialmedia.qa.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.socialmedia.qa.base.TestBase;
import com.socialmedia.qa.pages.HomePage;
import com.socialmedia.qa.pages.LoginPage;
import com.socialmedia.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	WebDriver driver;
	
	TestBase base; 
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		base = new TestBase(); 
		driver = base.initializeDriver();
		loginPage = new LoginPage(driver); 
	}
	
	 @DataProvider(name = "loginData")
	 public Object[][] loginData() {
		 List<Object[]> data = TestUtil.getExcelData();
	     return data.toArray(new Object[0][]);
	    }

	 @Test(dataProvider = "loginData", priority = 2)
	 public void loginTest(String username, String password) {
		 SoftAssert softAssert = new SoftAssert();
		 homePage = loginPage.login(username, password);
		 
		 softAssert.assertNotNull(homePage, "The user was not logged in successfully.");
		 
		 try {
				Thread.sleep(1000);
			 } 
		 catch (InterruptedException e) {
				e.printStackTrace();
			 }
		 String actualUrl = driver.getCurrentUrl();
		 String expectedUrl = prop.getProperty("homeurl");
		 
		 softAssert.assertEquals(actualUrl, expectedUrl, "The user was not redirected to the homepage. They were redirected to: " + actualUrl); 
		 
		 String actualTitle = homePage.getHomeTitle();
		 String expectedTitle = "React App";
		 softAssert.assertEquals(actualTitle, expectedTitle, "The title of the page is incorrect. It should be " + expectedTitle + ", but it is instead " + actualTitle + ".");
		 
		 softAssert.assertTrue(homePage.isHomeTextDisplayed(), "The header on the homepage which is supposed to say 'Sanveer's Social Media App' is missing.");
		 
		 softAssert.assertAll();
	 }
	/*
	@Test(priority=2)
	public void loginTest() {
		homePage = loginPage.login("test@test.com", "testing123");
		String homeText = homePage.getHomeText(); 
		Assert.assertEquals(homeText, "Sanveer's Social Media App", "Home page text did not match.");
	}
	*/
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, "React App");
	}
	
	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
