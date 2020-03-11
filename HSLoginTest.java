package com.highstreet.login.auto.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.highstreet.login.auto.util.HighStreetConstants;

public class HighStreetLoginTest {

	static WebDriver driver;

	//to invoke browser
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver",HighStreetConstants.BROWSER_CHROME_PATH);
			driver= new ChromeDriver();
			driver. manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			 
			//to get website
			driver.get(HighStreetConstants.WEBSITE_URL);
			WebsiteLogin.LoginDetails(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// to enter login details
	
	/*public void LoginDetails() {
		try {
			driver.findElement(By.xpath("//div[@id='loginEmailField']/input")).sendKeys("demo@highstreetapp.com");
			Thread.sleep(2500);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("greatmobilecontent");
			Thread.sleep(2500);
			driver.findElement(By.className("loginButton")).click();
			Thread.sleep(2500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	public static void main(String[] args) {
		// Run the Login test scenario

		HighStreetLoginTest hsLoginTest = new HighStreetLoginTest();
		hsLoginTest.invokeBrowser();
		
		
	}

}
