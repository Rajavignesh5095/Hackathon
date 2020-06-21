package com.udemy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.udemy.base.Testbase;

public class AddtoCartpage extends Testbase{
	
	
	
	@FindBy(id="header.dropdown.cart")
	WebElement addToCartlink;
	
	@FindBy(xpath="//h1[contains(text(),'Shopping Cart')]")
	WebElement addToCartLabel;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement keepShoppingbtn;
	
	
	public AddtoCartpage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddtoCartLink() {
		addToCartlink.click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Shopping Cart')]"))).isDisplayed();
	}
	
	public void clickOnKeepShoppingLink() {
		 addToCartlink.click();
		 keepShoppingbtn.click();
		 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notice-streamer__headline']"))).isDisplayed();
	}
	
	public boolean addtoCartLabel() {
		return addToCartLabel.isDisplayed();
	}
	
	
	

}
