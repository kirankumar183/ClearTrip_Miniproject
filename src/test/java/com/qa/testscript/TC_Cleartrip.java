package com.qa.testscript;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utilities.Excelutility;



public class TC_Cleartrip extends TestBase {
	
	@Test(dataProvider="getData")
	public void ClearTripRegister(String HotelName,String Traveller) throws InterruptedException, IOException {
		
		Cleartrip.getHotellink().click();
		Thread.sleep(3000);
		Cleartrip.getHotelfield().sendKeys(HotelName+Keys.ENTER);
		Thread.sleep(3000);
		
		Cleartrip.getCheckinField().click();
		Thread.sleep(3000);
		Cleartrip.getCheckinDate().click();
		Thread.sleep(5000);
		Cleartrip.getCheckoutField().click();
		Thread.sleep(3000);
		Cleartrip.getCheckoutDate().click();
		Cleartrip.getTravellers().selectByVisibleText(Traveller);
		Thread.sleep(5000);
		//Cleartrip.getSearchHotel().click();
		
		
		
		String title=driver.getTitle();
		if(title.contains("Cleartrip")) {
			Reporter.log("Test is passed", true);
			Assert.assertTrue(true);
		}
		else
		{
			CaptureScreenshot(driver,"ClearTripRegister" );
			Assert.assertTrue(false);
			Reporter.log("Test is failed", true);
		}
		//driver.navigate().back();
		Thread.sleep(5000);
		Cleartrip.getHotelfield().clear();
		//Cleartrip.getCheckinField().clear();
		//Cleartrip.getCheckoutField().clear();
		
	}

		@DataProvider
		public String[][] getData() throws IOException
		{
			String xFile = "C:\\Users\\chan\\eclipse-workspace\\Virtusa_Miniproject\\conf\\TestData1.xlsx";
			String xSheet="Sheet1";
			int rowCount=Excelutility.getrowcount(xFile, xSheet);
			int cellCount =Excelutility.getcellcount(xFile, xSheet, rowCount);
			
			String[][] data=new String[rowCount][cellCount];
			for(int i=1;i<=rowCount;i++)
			{
				for(int j=0;j<cellCount;j++)
				{
					data[i-1][j]=Excelutility.getcellData(xFile, xSheet, i, j);
				}
			}
			return data;
	     }
		
		
		
		
		
	}


