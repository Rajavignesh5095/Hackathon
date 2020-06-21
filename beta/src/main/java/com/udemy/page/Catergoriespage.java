package com.udemy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.udemy.base.Testbase;

public class Catergoriespage extends Testbase {
    @CacheLookup
	@FindBy(xpath="//a[@id='header.browse']")
	WebElement Categorieslink;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[2]")
	WebElement subCategorieslink;
	
	@FindBy(xpath="//h1[contains(text(),'Development Courses')]")
	WebElement subCategorieslabel;
	
	@FindBy(xpath="//button[@class='filter-button--filter-button--y-iVA btn btn-quaternary']")
	WebElement filterbtn;
	
	
	
	public Catergoriespage() {
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public void clickOnCatergoriesLink() {
		Categorieslink.click();
		Actions action = new Actions(driver);
		action.moveToElement(subCategorieslink).build().perform();
		subCategorieslink.click();
	}
	
	public boolean subCatergoriesLabel() {
		return subCategorieslabel.isDisplayed();
	}
	
	public String validateCatergoriespageTitle() {
		return driver.getTitle();
	}
	
	public void validateFilterOptions() {
		filterbtn.click();
	}
	
	public void checkingFilters() {
		 WebElement target= driver.findElement(By.cssSelector(
					".filter--filter-container--1ftIU:nth-child(4) > .filter-option--checkbox--3Ar4b:nth-child(2) .toggle-control-label"));
		target.click();
	}
	
	
}
