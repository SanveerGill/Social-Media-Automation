package com.socialmedia.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.socialmedia.qa.base.TestBase;
import com.socialmedia.qa.pages.HomePage;
import com.socialmedia.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage; 
	HomePage homePage;
	
	public HomePageTest(){
		 super();
	}
	
	@BeforeMethod
	public void setup() {
		initializeDriver();
		loginPage = new LoginPage();
		homePage = loginPage.login("test@test.com", "testing123"); 
	}
	
	@Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.getHomeTitle();
        Assert.assertEquals(homePageTitle, "React App", "Home page title should be 'React App' but is " + homePageTitle + " instead.");
    }

    @Test(priority = 2)
    public void verifyHomeTextTest() {
        String homeText = homePage.getHomeText();
        Assert.assertEquals(homeText, "Sanveer's Social Media App", "The home page header should say 'Sanveer's Social Media App' but says " + homeText + " instead.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
