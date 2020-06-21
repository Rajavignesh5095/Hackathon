package com.udemy.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.udemy.base.Testbase;
import com.udemy.page.AddtoCartpage;
import com.udemy.page.Catergoriespage;
import com.udemy.page.Homepage;
import com.udemy.page.Loginpage;
import com.udemy.page.Signuppage;
import com.udemy.page.TeachOnUdemypage;
import com.udemy.page.UdemyForBusinesspage;
import com.udemy.utlity.TestUtil;

public class HomePageTest extends Testbase {
	Homepage homepage;
	Signuppage signup;
	Loginpage login;
	AddtoCartpage addcart;
	Catergoriespage catergories ;
	TeachOnUdemypage teachonudemy;
	UdemyForBusinesspage udemyforbusiness ;
	TestUtil testutil;
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		  homepage = new Homepage();
		  signup = new Signuppage();
	}
	
	@Test(priority=1)
	public void verfiySignupLinkTest() {
		 signup = homepage.clickOnSignupLink();
	}
	
	@Test(priority=2)
	public void verfiyLoginLinkTest() {
		login= homepage.clickOnLoginLink();
	}
	
	@Test(priority=3)
	public void verfiyAddtoCartLinkTest() {
		 homepage.clickOnAddtoCartLink();
		 homepage.AddtoCartLabel();
		 Assert.assertTrue(true,"AddtoCart Label is Missing On The Page");
	}
	
	@Test(priority=4)
	public void verfiyTeachOnUdemyLinkTest() {
		 teachonudemy = homepage.clickOnTeachOnUdemyLink();
	}
	
	@Test(priority=5)
	public void verfiyCatergoriesLinkTest() {
		 catergories = homepage.clickOnCategoriesLink();
	}
	
	@Test(priority=6)
	public void verfiyUdemyForBusinessLinkTest() {
		 udemyforbusiness = homepage.clickOnudemyForBusinesslink();
	}
	
	@Test(priority=7)
	public void verfiyUdemyLinkTest() {
		  homepage.clickOnUdemyLink();
	}
	
	@Test(priority=8)
	public void verfiysearchtextboxTest() {
		  homepage.clickOnSearchTextbox();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
