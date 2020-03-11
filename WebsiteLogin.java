package com.highstreet.login.auto.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.highstreet.login.auto.util.HighStreetConstants;



public class WebsiteLogin {
	
	
	// to enter into website with login details
	
	public static void LoginDetails(WebDriver driver) {
			try {
				driver.findElement(By.xpath("//div[@id='loginEmailField']/input")).sendKeys(HighStreetConstants.LOGIN_EMAIL);
				Thread.sleep(HighStreetConstants.DELAY_TIME);
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys(HighStreetConstants.LOGIN_PASSWORD);
				Thread.sleep(HighStreetConstants.DELAY_TIME);
				driver.findElement(By.className("loginButton")).click();
				Thread.sleep(HighStreetConstants.DELAY_TIME);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
