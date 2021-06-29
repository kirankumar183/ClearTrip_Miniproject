package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
	
	public static FileInputStream fileloc;
	public static XSSFWorkbook wbook;
	public static XSSFSheet wsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	//1.get row count
	public static int getrowcount(String xfile,String xsheet) throws IOException {
		fileloc=new FileInputStream(xfile);
		wbook=new XSSFWorkbook(fileloc);
		wsheet=wbook.getSheet(xsheet);
		int rowcount=wsheet.getLastRowNum();
		
		return rowcount;
		
	}
	//2.get cell count
	public static int getcellcount(String xfile,String xsheet,int rownum) throws IOException {
		fileloc=new FileInputStream(xfile);
		wbook=new XSSFWorkbook(fileloc);
		wsheet=wbook.getSheet(xsheet);
		row=wsheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		
		return cellcount;
		
	}
	//3.get cell Data
	public static String getcellData(String xfile,String xsheet,int rownum,int colnum) throws IOException {
		fileloc=new FileInputStream(xfile);
		wbook=new XSSFWorkbook(fileloc);
		wsheet=wbook.getSheet(xsheet);
		
		row=wsheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter=new DataFormatter();
		String cellData=formatter.formatCellValue(cell);
		
		wbook.close();
		fileloc.close();
		return cellData;
		
		
	
		
		
	}
	
	
	

}
