package com.java.automatin.basetest;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.constants.DriverPaths;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	
	private static WebDriver webdriver;
	private static ExtentReports reports;
	private static ExtentTest test;

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
	@BeforeMethod
	public void trackTC(Method method) {
		String tcName=method.getName();
		test=reports.startTest(tcName);
		test.log(LogStatus.PASS,"tracking the Test case is going be execute" +tcName);
		
	}
	@BeforeClass
	public void initReports() {
		reports=new ExtentReports("D:\\workspace\\selenium\\Drivers\\Reports.html");
		
	}
	@AfterMethod
	public void exeTC(ITestResult result) {
		String TcName=result.getName();
		if(result.getStatus()==result.SUCCESS) {
			test.log(LogStatus.PASS, "tc is passed"+TcName);
		}else if(result.getStatus()==result.FAILURE) {
			test.log(LogStatus.FAIL,"tc is failed"+TcName);
		}
		reports.endTest(test);
		reports.flush();
	}
	public void init() {
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webdriver.manage().deleteAllCookies();
	}
	/*
	 * driver  is not null close the browser
	 */
	
	@AfterSuite
	public void closeBrowser() {
		if(webdriver!=null) {
			webdriver.close();
		}else {
			System.out.println("hello");
			System.out.println("driver pointing to null...");
		}
	}

	@AfterClass
	public void extentTest() {
		reports.close();
	
	}
	
public static WebDriver getWebDriver() {
	return webdriver;
}
public static ExtentReports getReports() {
	return reports;
}
	public static ExtentTest getTest() {
		return test;
	}

}
