package com.highstreet.login.auto.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.highstreet.login.auto.util.HighStreetConstants;

public class HighStreetDuplicateLookbookTest {

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
			ClickLookbookManager();
			DuplicateLookBook();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// to click Look book Manager option
	
	public void ClickLookbookManager() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='promotionManager']/div[1]/div[1]/div[1]/img")).click();
		
	}
	
	// to Duplicate 'Test' lookbook
	
	public void DuplicateLookBook() {
		try {
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"lookbookOverview\"]/div/div[2]/tile-group/div/div[2]/div[2]/div/div/tile/div/div[2]/div[2]/img")).click();
			Thread.sleep(HighStreetConstants.DELAY_TIME);
			driver.findElement(By.xpath("//*[@id=\"lookbookOverview\"]/div/div[2]/tile-group/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[1]/p/span")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HighStreetDuplicateLookbookTest hsDuplicateLB = new HighStreetDuplicateLookbookTest();
		hsDuplicateLB.invokeBrowser();
		
		
	}

}
