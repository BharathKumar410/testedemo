package com.vbk.app.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {
	
	@Test
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\selenium\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("identifierId")).sendKeys("bharath14741@gmail.com");
		Thread.sleep(5000);
		driver.close();
		
		System.out.println("hello");
	}

}
