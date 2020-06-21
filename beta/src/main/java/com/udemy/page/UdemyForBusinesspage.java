package com.udemy.page;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.udemy.base.Testbase;





public class UdemyForBusinesspage extends Testbase {
	private Map<String, Object> vars;
	
	@FindBy(xpath="//a[@id='header.try-ufb']")
	WebElement udemyForBusinesslink;

	
	@FindBy(css="#FirstName")
	WebElement firstname;
	
	
	@FindBy(id="LastName")
	WebElement lastname;
	
	
	@FindBy(id="Email")
	WebElement emailId;
	
	
	@FindBy(id="Title")
	WebElement title;
	
	
	@FindBy(id="Company")
	WebElement company;
	

	@FindBy(id="Phone")
	WebElement phone;
	
	@FindBy(xpath="//button[@class='mktoButton']")
	WebElement getInTouchbtn;
	
	
	
	
	
	public UdemyForBusinesspage() {
		PageFactory.initElements(driver, this);
	}
	
	public String waitForWindow(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> whNow = driver.getWindowHandles();
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}
	public void form() throws InterruptedException {
		vars = new HashMap<String, Object>();
		driver.get(prop.getProperty("url"));
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("header.try-ufb")).click();
		vars.put("win8500", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win8500").toString());
		Thread.sleep(1000);
//		driver.findElement(By.cssSelector(".mktoFieldDescriptor:nth-child(1) .mktoLabel")).click();
//		driver.findElement(By.id("FirstName")).sendKeys("tbjhj");
//		POM2.form_firstnamet(driver).sendKeys(p.getProperty("FirstName"));
//		driver.findElement(By.cssSelector(".mktoFieldDescriptor:nth-child(2) .mktoLabel")).click();
//		POM2.form_lastname(driver).sendKeys(p.getProperty("LastName"));
//		driver.findElement(By.cssSelector(".mktoFormRow:nth-child(3) .mktoLabel")).click();
//		POM2.form_email(driver).sendKeys(p.getProperty("Email"));
//		driver.findElement(By.cssSelector(".mktoFormRow:nth-child(4) .mktoLabel")).click();
//		POM2.form_title(driver).sendKeys(p.getProperty("Title"));
//		driver.findElement(By.cssSelector(".mktoFormRow:nth-child(5) .mktoLabel")).click();
//		POM2.form_company(driver).sendKeys(p.getProperty("Company"));
//		driver.findElement(By.cssSelector(".mktoFormRow:nth-child(6) .mktoLabel")).click();
//		POM2.form_phone(driver).sendKeys(p.getProperty("Phone"));
//		POM2.form_submit(driver).click();
//		String errormessage = driver.findElement(By.xpath("//div[@class='tippy-content']")).getText();
//		System.out.println("\n" + "\n" + "ERROR MESSAGE");
//		System.out.println("Error message Displayed : " + errormessage);

	}

	public void createDemopage(String fname,String lname,String email,String phonenum,String companyname,String titlename) {
		
		firstname.sendKeys(fname);
		
		lastname.sendKeys(lname);
		
		emailId.sendKeys(email);
		
		title.sendKeys(titlename);
		
		company.sendKeys(companyname);
		
		phone.sendKeys(phonenum);
		
		getInTouchbtn.sendKeys(Keys.ENTER);
		
	}
	
	public String alertmsg() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		String errormsg =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tippy-content']"))).getText();	
		 System.out.println("Error message Displayed : " + errormsg);
		return errormsg;
	}
}
