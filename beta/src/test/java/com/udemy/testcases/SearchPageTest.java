package com.udemy.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.udemy.utlity.TestUtil;
import com.udemy.base.Testbase;
import com.udemy.page.AddtoCartpage;
import com.udemy.page.Searchpage;

public class SearchPageTest extends Testbase {
	Searchpage searchpage ;
	TestUtil testutil;
	public SearchPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		 searchpage = new Searchpage();
	}
	
	@Test(priority=1)
	public void verifycourse() throws InterruptedException {
		searchpage.validateCourse();
	}
	
	@Test(priority=2)
	public void verifyfilterTest() throws InterruptedException {
		searchpage.validatefilter();
	}
	
	@Test(priority=2)
	public void verfiyCourseLabelTest() throws InterruptedException {
		searchpage.validatecourseLabel();
		 Assert.assertTrue(true," course Label is Missing On The Page");
	}
	
	@Test(priority=3)
	public void verifySearchbtn() {
		searchpage.validatesearchboxbtn(); 
		
		}
	
	@Test(priority=4)
	public void verifyfilterbtn() throws InterruptedException {
		searchpage.validatefilterbtn();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
