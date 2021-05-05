package com.vbk.app.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

public class Rameshsoft {
	@Test
	public  void fp_login() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rameshsoft.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.close();
		
	}
	

}
