package com.qa.testscript;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.Cleartrip_pages;



public class TestBase {
	
	WebDriver driver;
	
	Cleartrip_pages Cleartrip;
	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void SetUp(String Browser,String Url) throws InterruptedException
	{
		if(Browser.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chan\\eclipse-workspace\\ClearTrip_Miniproject\\conf\\chromedriver.exe");
		driver=new ChromeDriver();
		
		}
		else if(Browser.equalsIgnoreCase("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\chan\\eclipse-workspace\\ClearTrip_Miniproject\\conf\\geckodriver.exe");
		driver=new FirefoxDriver();
		} 
			Cleartrip=new Cleartrip_pages (driver);
				driver.get(Url);
	 
		
	}
	@AfterClass
	public void TearDown()
	{
	 driver.close();
		
	}
	
   public void CaptureScreenshot(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot Screenshot=(TakesScreenshot)driver;
		File source=Screenshot.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"/Screenshots/"+ tname +".png";
		
		FileUtils.copyFile(source, new File(dest));
		
	}
	
	
	

}
