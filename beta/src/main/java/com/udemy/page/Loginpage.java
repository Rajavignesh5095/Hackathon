package com.udemy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.udemy.base.Testbase;

public class Loginpage extends Testbase{
	@FindBy(xpath="//button[@class='btn btn-quaternary']")
	WebElement loginbtn;
    
	@FindBy(css="#email--1")
	WebElement loginemail;
	
	@FindBy(name ="password")
	WebElement loginpwd;
	
	@FindBy(xpath ="//input[@id='submit-id-submit']")
	WebElement loginsubmit;
	
	@FindBy(className="udemy-logo")
	WebElement udemylogo;
	
	@FindBy(xpath ="//div[contains(@class,'alert alert-danger js-error-alert')]")
	WebElement errormsg;
	
	@FindBy(css="#udemy > div:nth-child(20) > div.generic-modal.fade.in.modal > div > div > div > div > div > div.signup-modal-wrapper > div > div > div.loginbox-v4__header.loginbox-v4__header--signup")
	WebElement signuplabel;
	
	
	//Initializing the Page Objects;
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public String validateLoginpageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateUdemyLogo() {
		 return udemylogo.isDisplayed();
	}
	
	public void login(String un,String pwd) throws InterruptedException {
		loginbtn.click();
		loginemail.sendKeys(un);
		loginpwd.sendKeys(pwd);
		loginsubmit.click();
		Thread.sleep(2000);
	}
	
	
	public boolean alertmsg() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		 return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert alert-danger js-error-alert')]"))).isDisplayed();	
	}
	
	
}

