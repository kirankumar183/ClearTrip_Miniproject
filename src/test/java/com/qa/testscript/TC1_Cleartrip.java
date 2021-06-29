package com.qa.testscript;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utilities.Excelutility;

public class TC1_Cleartrip extends TestBase {
	
	@Test(dataProvider="getData")
	public void TrainRegister(String FromPlace,String ToPlace) throws InterruptedException, IOException {
		
		Thread.sleep(3000);
		Cleartrip.getTrainlink().click();
		Thread.sleep(5000);
		Cleartrip.getFromtxtfield().sendKeys(FromPlace);
		Cleartrip.getTotxtfield().sendKeys(ToPlace);
		Cleartrip.getClassDdown().selectByIndex(1);
		List<WebElement> Classlist=Cleartrip.getClasslist();
		System.out.println("Total No.of classlist are :"+Classlist.size());
		for (WebElement Trainlist : Classlist) {
			Reporter.log(Trainlist.getText(), true);	
		}
		Cleartrip.getTrainfieldbox().click();
		Cleartrip.getTrainsearchDate().click();
		Cleartrip.getAdultDdown().selectByIndex(1);
		Cleartrip.getChildrenDdown().selectByIndex(1);
		Cleartrip.getSeniorMenDdown().selectByIndex(1);
		Cleartrip.getSeniorWoMenDdown().selectByIndex(1);
		//Cleartrip.getSearchtrain().click();
		String title=driver.getTitle();
		if(title.contains("trains")) {
			Reporter.log("Title is passed", true);
			Assert.assertTrue(true);
		}
		else
		{
			CaptureScreenshot(driver, "TrainRegister");
			Assert.assertTrue(true);
			Reporter.log("Title is failed", true);
		}
		
		
		Cleartrip.getFromtxtfield().clear();
		Cleartrip.getTotxtfield().clear();
		
	}
		
	@DataProvider
	public String[][] getData() throws Exception 
	{
		String xFile = "C:\\Users\\chan\\eclipse-workspace\\Virtusa_Miniproject\\conf\\TestData1.xlsx";
		String xSheet="Sheet2";
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
