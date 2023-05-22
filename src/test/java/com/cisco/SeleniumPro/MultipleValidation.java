package com.cisco.SeleniumPro;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleValidation {
ChromeDriver driver;
	
	
	@BeforeTest
	public void lanuchApplication() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//3)navigate to application
		driver.get("https://facebook.com");
		//4)click on "continue to login" button
		
	}
	@Test(priority=1)
	public void verifyTitle() {
	//4) verify when the page is loaded,title is facebook -log in or sign up
	String expectedTitle ="Facebook – log in or sign up";
	String actualTitle = driver.getTitle();
	AssertJUnit.assertEquals(actualTitle,expectedTitle);
	}
	
	@Test(priority=2,enabled=true,dependsOnMethods = "verifyTitle")
	public void verifyText() {
		//5)verify when the page is loaded ,text-'Facebook helps you connect and share with the people in your life.'
//		String exceptedText ="Facebook helps you connect and share with the people in your life.";
//		String actualText = driver.findElement(By.xpath("//h2[contains(@class,'eso')]")).getText();
//		Assert.assertEquals(actualText,exceptedText);
          
		boolean textStatus = driver.getPageSource().contains("Facebook helps you connect and share with the people in your life.");
	     AssertJUnit.assertTrue(textStatus);
	}
	//6)verify log in button has blue color
	    @Test(priority=3)
	    public void verifyLoginBtnIsBlue() {
	    	//6)verify log in button has blue color
	    	String expectedColor = "rgba(24, 119, 242, 1)";
	    	String actualColor =  driver.findElement(By.name("login")).getCssValue("background-color");
	    	AssertJUnit.assertEquals(actualColor,expectedColor); 
	    	
	    }
	
	//7)close the browser
	    @AfterTest
	    public void closeBrowser() {
	    	driver.quit();
	    }
}
