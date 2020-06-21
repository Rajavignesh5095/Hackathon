package com.udemy.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.udemy.base.Testbase;
import com.udemy.page.Loginpage;
import com.udemy.page.Signuppage;
import com.udemy.utlity.TestUtil;

public class SignupPageTest extends Testbase{
	
	Signuppage signuppage;
	Loginpage loginpage;
	TestUtil testutil;
	
	
	public SignupPageTest() {
		super();
	}
 

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		  testutil= new TestUtil();
		  signuppage = new Signuppage();
		   loginpage = new Loginpage();
	}
	
	
	
	@Test(priority=1)
	public void verifySignupLabel() {
		//testutil.switchToFrame();
		signuppage.signupLabel();
		Assert.assertTrue(true," SignUp Label is Missing On The Page");
		
	}
	
	@Test(priority=1)
	public void verifySignupTest() {
		signuppage.signupTest(prop.getProperty("fullname"), prop.getProperty("validemail"),prop.getProperty("invalidpassword"));
		boolean flag=signuppage.alertmsg();
		Assert.assertTrue(flag);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
}
