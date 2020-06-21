package com.udemy.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.udemy.base.Testbase;
import com.udemy.page.Homepage;
import com.udemy.page.Signuppage;
import com.udemy.page.TeachOnUdemypage;
import com.udemy.utlity.TestUtil;

public class TeachOnUdemyPageTest extends Testbase {
	
	TeachOnUdemypage teachonudemy;
	TestUtil testutil;
	
	public TeachOnUdemyPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		teachonudemy = new TeachOnUdemypage();
		}
	
	@Test(priority=1)
	public void verifyTeachOnUdemyLinkTest() {
		teachonudemy.clickOnudemyForBusinessLink();
	}
	
	@Test(priority=2)
	public void verifyTeachOnUdemyTitleTest() {
		teachonudemy.clickOnudemyForBusinessLink();
		String title=teachonudemy.validateudemyForBusinesspageTitle();
		Assert.assertEquals(title, "Teach Online - Share your knowledge with millions of students across the globe and earn money");
	}
	
	@Test(priority=3)
	public void verifyTeachOnUdemyURLTest() {
		teachonudemy.clickOnudemyForBusinessLink();
		String title=teachonudemy.validateudemyForBusinesspageURL();
		Assert.assertEquals(title, "https://www.udemy.com/teaching/?ref=teach_header");
	}
	
	@Test(priority=4)
	public void verifyBecomeInstructorbtnTest() {
		teachonudemy.clickOnudemyForBusinessLink();
		teachonudemy.clickOnbecomeInstructorLink();
		teachonudemy.becomeInstructorLabel();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
