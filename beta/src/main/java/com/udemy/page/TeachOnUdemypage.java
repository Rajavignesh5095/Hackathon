package com.udemy.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.udemy.base.Testbase;

public class TeachOnUdemypage extends Testbase {
	
	@FindBy(id="header.try-ufb")
	WebElement udemyForBusinesslink;
	
	@FindBy(xpath="//button[@class='has-sticky teaching-signup-button--cta--fMxEG btn btn-primary']")
	WebElement becomeInstructorbtn;
	
	@FindBy(className="loginbox-v4__header loginbox-v4__header--signup")
	WebElement becomeInstructorlabel;
	
	
	public void clickOnudemyForBusinessLink() {
		udemyForBusinesslink.click();
	}

	public String validateudemyForBusinesspageTitle() {
		return driver.getTitle();
	}
	
	public String validateudemyForBusinesspageURL() {
		return driver.getCurrentUrl();
	}
	
	public void clickOnbecomeInstructorLink() {
		becomeInstructorbtn.click();
	}
	public void becomeInstructorLabel() {
		becomeInstructorlabel.isDisplayed();
	}
	
	
	
}
