package com.search.flipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {

	WebDriver driver;

	@BeforeMethod
	public void browserlaunch() {

		//WebDriverManager.chromedriver().setup();
		
		System.setProperty("webdriver.chrome.driver", "C://Users//sounderrajan.jothi//Desktop//Drivers & Jenkins & JAVA//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	@Test
	public void test1() {

		driver.findElement(By.xpath("//*[contains(text(),'✕')]")).click();
		driver.findElement(By.name("q")).sendKeys("iphone");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("q")).click();

	}

	@AfterMethod
	public void browserclose() {

		driver.quit();

	}

}
