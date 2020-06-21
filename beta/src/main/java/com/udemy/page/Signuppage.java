package com.udemy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.udemy.base.Testbase;
import com.udemy.utlity.TestUtil;

public class Signuppage extends Testbase {

	@FindBy(xpath ="//button[contains(text(),'Sign Up')]")
	WebElement signupbtn;
	
	@FindBy(css="#udemy > div:nth-child(20) > div.generic-modal.fade.in.modal > div > div > div > div > div > div.signup-modal-wrapper > div > div > div.loginbox-v4__header.loginbox-v4__header--signup")
	WebElement signuplabel;
	
	@FindBy(css="#id_fullname")
	WebElement signupfullname;
	
	@FindBy(css="#email--1")
	WebElement signupemail;
	
	@FindBy(css="#password")
	WebElement signuppassword;
	
	@FindBy(css="#submit-id-submit")
	WebElement signupsubmit;
	
	
	
	
	
	public Signuppage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean signupLabel() {
		signupbtn.click();
		TestUtil.switchToFrame();;
		return signuplabel.isDisplayed();
	}
	public void signupTest(String name, String un, String pwd) {
		signupbtn.click();
		signupfullname.sendKeys(name);
		signupemail.sendKeys(un);
		signuppassword.sendKeys(pwd);
		signupsubmit.click();	
	}
	
	public boolean alertmsg() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		 return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert alert-danger js-error-alert')]"))).isDisplayed();	
	}
	
	
}
