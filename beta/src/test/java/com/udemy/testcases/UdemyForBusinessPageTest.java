package com.udemy.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.udemy.base.Testbase;
import com.udemy.page.Loginpage;
import com.udemy.page.Signuppage;
import com.udemy.page.UdemyForBusinesspage;
import com.udemy.utlity.TestUtil;

public class UdemyForBusinessPageTest extends Testbase {
	UdemyForBusinesspage udemyforbusinesspage;
	String sheetName= "Sheet1";
	TestUtil testutil;
	public UdemyForBusinessPageTest() {
		super();
	}
	

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		udemyforbusinesspage= new UdemyForBusinesspage();
//		  signuppage = new Signuppage();
//		   loginpage = new Loginpage();
	}

	
	@DataProvider
	public Object[][] getUserTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
 @Test(priority=1,dataProvider="getUserTestData")
 public void fillingFormTest(String First_Name, String Last_Name, String Work_Email, String Phone_Number,String Company_Name, String Job_Title) throws InterruptedException {
	 udemyforbusinesspage.form();
	
	 udemyforbusinesspage.createDemopage(First_Name, Last_Name, Work_Email, Phone_Number, Company_Name, Job_Title);
	  String msg=udemyforbusinesspage.alertmsg();
	
	 Assert.assertEquals(msg,"Please use a business email address");
 }
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
