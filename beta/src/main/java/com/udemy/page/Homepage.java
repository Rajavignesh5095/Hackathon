package com.udemy.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.udemy.base.Testbase;

public class Homepage extends Testbase{
	
	@FindBy(xpath="//*[@id=\"udemy\"]/div[2]/div[3]/div[1]/div[4]/div[7]/div/button")
	WebElement signupbtn;
	
	@FindBy(xpath="//a[@id='header.dropdown.cart']")
	WebElement addcartlink;
	
	@FindBy(xpath="//h1[contains(text(),'Shopping Cart')]")
	WebElement addcartlabel;
	
	@FindBy(xpath="//button[@class='btn btn-quaternary']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[@id='header.instructor']")
	WebElement teachOnUdemylink;
	
	@FindBy(xpath="//a[@id='header.try-ufb']")
	WebElement udemyForBusinesslink;
	
	@FindBy(xpath="//a[@id='header.browse']")
	WebElement Categorieslink;
	
	@FindBy(xpath="//div[@class='c_header__logo-container']")
	WebElement udemylink;
	
	@FindBy(xpath="//input[@id='header-search-field']")
	WebElement searchtextbox;
	
	@FindBy(xpath="//button[@class='btn btn-link']")
	WebElement searchtextboxbtn;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	public Signuppage clickOnSignupLink() {
		signupbtn.click();
		return new Signuppage();
	}
	public  Loginpage clickOnLoginLink() {
		loginbtn.click();
		return new Loginpage();
	}
	
	public  void clickOnAddtoCartLink() {
		addcartlink.click();
		
	}
	public  boolean AddtoCartLabel() {
		 return addcartlabel.isDisplayed();
		
	}
	
	public  TeachOnUdemypage clickOnTeachOnUdemyLink() {
		teachOnUdemylink.click();
		return new TeachOnUdemypage();
	}
	public Catergoriespage clickOnCategoriesLink() {
		Categorieslink.click();
		return new Catergoriespage();
	}
	
	public  UdemyForBusinesspage clickOnudemyForBusinesslink() {
		Categorieslink.click();
		return new UdemyForBusinesspage();
	}
	
	public  void clickOnUdemyLink() {
		udemylink.click();
	}
	
	public void clickOnSearchTextbox() {
		searchtextbox.click();
		searchtextbox.sendKeys(prop.getProperty("coursename"));
		searchtextboxbtn.click();
		
	}
	
	
	
}
