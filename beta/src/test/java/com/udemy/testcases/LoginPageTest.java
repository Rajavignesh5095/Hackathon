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
import com.udemy.utlity.TestUtil;

public class LoginPageTest extends Testbase {
	Loginpage loginpage;
	TestUtil testutil;
	public LoginPageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		 loginpage =new Loginpage();
	}
   
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginpage.validateLoginpageTitle();
		Assert.assertEquals(title,"Online Courses - Learn Anything, On Your Schedule | Udemy");
	}
	
	@Test(priority=2)
	public void udemylogotest() {
		boolean flag = loginpage.validateUdemyLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginValidEmailInvalidPasswordTest() throws InterruptedException {
		loginpage.login(prop.getProperty("validemail"), prop.getProperty("invalidpassword"));
		Thread.sleep(2000);
		boolean flag=loginpage.alertmsg();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void loginInvalidEmailValidPasswordTest() throws InterruptedException{
		loginpage.login(prop.getProperty("invalidemail"), prop.getProperty("validpassword"));
		boolean flag=loginpage.alertmsg();
		Assert.assertTrue(flag);
	}
	@Test(priority=5)
	public void loginInvalidEmailInvalidPasswordTest() throws InterruptedException{
		loginpage.login(prop.getProperty("invalidemail"), prop.getProperty("invalidpassword"));
		boolean flag=loginpage.alertmsg();
		Assert.assertTrue(flag);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
