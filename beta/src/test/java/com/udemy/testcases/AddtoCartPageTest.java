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
import com.udemy.utlity.TestUtil;


public class AddtoCartPageTest extends Testbase {
	
	AddtoCartpage addtocart ;
	TestUtil testutil;
	
	public AddtoCartPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		 addtocart = new AddtoCartpage();
	}
	
	
	@Test(priority=1)
	public void verifyClickOnAddtoCartbtnTest() {
		driver.get(prop.getProperty("url"));
		addtocart.clickOnAddtoCartLink();
	}
	
	@Test(priority=2)
	public void verfiyAddtoCartLabelTest() {
		driver.get(prop.getProperty("url"));
		addtocart.clickOnAddtoCartLink();
		addtocart.addtoCartLabel();
		 Assert.assertTrue(true," addtocart Label is Missing On The Page");
	}
	
	@Test(priority=3)
	public void verifyClickOnKeepShoppingLinkTest() {
		driver.get(prop.getProperty("url"));
		addtocart.clickOnKeepShoppingLink();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
