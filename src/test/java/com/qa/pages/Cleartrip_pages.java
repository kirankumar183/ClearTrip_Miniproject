package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Cleartrip_pages {

	
	WebDriver driver;
	
	@FindBy(linkText="Hotels")
	WebElement Hotellink;
	
	public WebElement getHotellink() {
		return Hotellink;
	}
	
	
	@FindBy(xpath="//input[@id='Tags']")
	WebElement Hotelfield;
	
	public WebElement getHotelfield() {
		return Hotelfield;
	}
	
	@FindBy(xpath="//*[@id=\"SearchForm\"]/section[2]/div[1]/dl/dd/div/i")
	WebElement CheckinField;
	
	public WebElement getCheckinField() {
		return CheckinField;
	}
	
	@FindBy(xpath="//td[@data-month='5' and @data-year='2021']/a[text()='27']")
	WebElement CheckinDate;
	
	public WebElement getCheckinDate() {
		return CheckinDate;
	}
	

	@FindBy(xpath="//*[@id=\"SearchForm\"]/section[2]/div[2]/dl/dd/div/i")
	WebElement CheckoutField;
	
	public WebElement getCheckoutField() {
		return CheckoutField;
	}
	
	@FindBy(xpath="//td[@data-month='5' and @data-year='2021']/a[text()='28']")
	WebElement CheckoutDate;
	
	public WebElement getCheckoutDate() {
		return CheckoutDate;
	}
	
	@FindBy(id="travellersOnhome")
	WebElement Travellers;
	
	public Select getTravellers() {
		
		Select Travellerschoice=new Select(Travellers);
		return Travellerschoice;
	}
	
	@FindBy(xpath="//input[@id='SearchHotelsButton']")
	WebElement SearchHotel;
	
	public WebElement getSearchHotel() {
		return SearchHotel;
	}
	
	@FindBy(linkText="Trains")
	WebElement Trainlink;
	
	public WebElement getTrainlink() {
		return Trainlink;
	}
	
	
	
	@FindBy(xpath="//input[@id='from_station']")
	WebElement Fromtxtfield;
	
	public WebElement getFromtxtfield() {
		return Fromtxtfield;
	}
	
	
	@FindBy(xpath="//input[@id='to_station']")
	WebElement Totxtfield;
	
	public WebElement getTotxtfield() {
		return Totxtfield;
	}
	
	
	@FindBy(id="trainClass")
	WebElement ClassDdown;
	
	public Select getClassDdown() {
		
		Select ClassDdownbtn=new Select(ClassDdown);
		return ClassDdownbtn;
	}
	

	@FindBy(xpath="//*[@id=\"rail_search\"]/section[2]/div[3]/dl/dd/span/a/img")
	WebElement Trainfieldbox;
	
	public WebElement getTrainfieldbox() {
		return Trainfieldbox;
	}
	
	@FindBy(xpath="//a[text()='24'][1]")
	WebElement TrainsearchDate;
	
	public WebElement getTrainsearchDate() {
		return TrainsearchDate;
	}
	
	@FindBy(id="train_adults")
	WebElement AdultDdown;
	
	public Select getAdultDdown() {
		
		Select Adultbtn=new Select(AdultDdown);
		return Adultbtn;
	}
	
	@FindBy(id="train_children")
	WebElement ChildrenDdown;
	
	public Select getChildrenDdown() {
		
		Select Childbtn=new Select(AdultDdown);
		return Childbtn;
	}
	
	@FindBy(id="train_male_seniors")
	WebElement SeniorMenDdown;
	
	public Select getSeniorMenDdown() {
		
		Select SeniorMenbtn=new Select(SeniorMenDdown);
		return SeniorMenbtn;
	}
	
	@FindBy(id="train_female_seniors")
	WebElement SeniorWoMenDdown;
	
	public Select getSeniorWoMenDdown() {
		
		Select SeniorWoMenbtn=new Select(SeniorMenDdown);
		return SeniorWoMenbtn;
	}
	
	
	@FindBy(id="trainFormButton")
	WebElement Searchtrain;
	
	public WebElement getSearchtrain() {
		return Searchtrain;
	}
	
	@FindAll(@FindBy(xpath="//span[@class='ui-widget span span24' and @id='trainsSelBox']")) 
	List<WebElement> Classlist; 
	public List<WebElement> getClasslist()
	{
	  return Classlist;
	}
	
	
	
	
	
	
	
	public Cleartrip_pages(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
}
