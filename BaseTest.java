package com.java.automatin.basetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.constants.DriverPaths;

public class BaseTest {
	
	private static WebDriver webdriver;

	@Parameters({"browser"})
	@BeforeSuite
	public void openBrowser(@Optional(value="chrome") String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty(DriverPaths.chromeKey, DriverPaths.chromeValue);
			webdriver=new ChromeDriver();
			//driver.get("https://www.gmail.com");
			init();
			
			
		}else if(browser.equalsIgnoreCase("opera")) {
			
			System.setProperty(DriverPaths.operaKey, DriverPaths.operaValue);
			webdriver=new OperaDriver();
			init();
			
		}else if (browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty(DriverPaths.firefoxKey, DriverPaths.firefoxValue);
			webdriver=new FirefoxDriver();
			init();
			
		}
		
	}
	
	public void init() {
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webdriver.manage().deleteAllCookies();
	}
	
	System.out.println("hello");
	/*
	 * driver  is not null close the browser
	 */
	
	@AfterSuite
	public void closeBrowser() {
		if(webdriver!=null) {
			webdriver.close();
		}else {
			System.out.println("driver pointing to null...");
		}
	}
	
public static WebDriver getWebDriver() {
	return webdriver;
}
	

}
