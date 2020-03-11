package com.highstreet.login.auto.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.highstreet.login.auto.util.HighStreetConstants;

public class HighStreetPushNotificationTest {

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
			ClickNotificationManager();
			CreateNewNotification();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// to click Notification Manager option
	
	public void ClickNotificationManager() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='promotionManager']/div[1]/div[1]/div[3]/img")).click();
		
				
	}
	
	
	
	// to Create New Notification
	
	public void CreateNewNotification() {
		try {
			
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("rightButton")).click();			
			Thread.sleep(HighStreetConstants.DELAY_TIME);
			
			//Select storefront
			
			driver.findElement(By.xpath("//div[@class='selectNotificationLocales']/div[1]/div[1]/div[1]/div[contains(@class,'ddBtnArrow')]")).click();
			driver.findElement(By.xpath("//*[@id=\"addLocalePopup\"]/div/div[1]/ul/li[3]/toggle-switch/div/div[2]/input")).click();
			Thread.sleep(HighStreetConstants.DELAY_TIME);
			driver.findElement(By.xpath("//*[@id=\"addLocalePopup\"]/div/div[1]/input")).click();
			Thread.sleep(HighStreetConstants.DELAY_TIME);
			
			//to Select the content in the app 
			driver.findElement(By.xpath("//div[@class='ddBtn notification']/div")).click();
			WebElement menu=driver.findElement(By.xpath("//ul[@class='ddList navigation']"));
			
			//move mouse to select option from drop down
			Actions action= new Actions(driver);
			action.moveToElement(menu).perform();
			driver.findElement(By.linkText("lookbooks")).click();
			
			
			// to enter Compose message details
			driver.findElement(By.xpath("//*[@id=\"applicationContent\"]/div[3]/div/div[2]/div/div[2]/div[2]/div/input[contains(@placeholder,'Enter notification')]")).sendKeys("This is Automation test");
			driver.findElement(By.xpath("//*[@id=\"applicationContent\"]/div[3]/div/div[2]/div/div[2]/div[2]/textarea")).sendKeys("This is Automation demo message");	
			
			// to click on Send button
			driver.findElement(By.xpath("//div[@id=\"doCreatePromotion\"]/button")).click();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HighStreetPushNotificationTest hsPushNotification = new HighStreetPushNotificationTest();
		hsPushNotification.invokeBrowser();
		
	}

}
