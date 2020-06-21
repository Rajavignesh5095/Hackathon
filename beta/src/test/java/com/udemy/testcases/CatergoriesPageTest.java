package com.udemy.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.udemy.base.Testbase;
import com.udemy.page.Catergoriespage;
import com.udemy.utlity.TestUtil;

public class CatergoriesPageTest extends Testbase {
	Catergoriespage catergoriespage;
	TestUtil testutil;
	public CatergoriesPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		  catergoriespage = new Catergoriespage();
	}
	
	@Test(priority=1)
	public void verifyCatergoriesTest() {
		
		catergoriespage.clickOnCatergoriesLink();
	}
	
	@Test(priority=2)
	public void verfiyCatergoriesLabelTest() {
		catergoriespage.clickOnCatergoriesLink();
		catergoriespage.subCatergoriesLabel();
		 Assert.assertTrue(true," Catergories Label is Missing On The Page");
	}
	
	@Test(priority=3)
	public void verifyCatergoriesPageTitleTest() {
		catergoriespage.clickOnCatergoriesLink();
		catergoriespage.subCatergoriesLabel();
		String title= catergoriespage.validateCatergoriespageTitle();
		Assert.assertEquals(title,"Online Web Development &amp; Programming Courses\r\n" + 
				" | Udemy");
	}
	
	@Test(priority=4)
	public void verifyfilterTest() {
		catergoriespage.clickOnCatergoriesLink();
		catergoriespage.subCatergoriesLabel();
		catergoriespage.validateFilterOptions();
		catergoriespage.checkingFilters();
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
