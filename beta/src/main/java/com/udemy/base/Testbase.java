package com.udemy.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.udemy.utlity.TestUtil;
import com.udemy.utlity.WebEventListener;

public class Testbase {
	public static WebDriverWait wait = null;
    public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	@CacheLookup
	@FindBy(xpath="//img[@class='udemy-logo']")
	WebElement logo;
	
	public Testbase() 
	{
		try{
			 prop = new Properties();
			FileInputStream ip =new FileInputStream(".\\src\\main\\java\\com\\udemy\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() throws InterruptedException {
		 String browsername=prop.getProperty("browser");
		 if (browsername.equalsIgnoreCase("Firefox")) {
				// to invoke firefox browser
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\eclipse-workspace\\beta\\src\\main\\resources\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
				//Thread.sleep(1000);
			
			} else if (browsername.equalsIgnoreCase("chrome")) {
				// to invoke chrome browser
				System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
				//Thread.sleep(1000);
				
	}
		 
		 e_driver = new EventFiringWebDriver(driver);
		 eventlistener = new WebEventListener();
		 e_driver.register(eventlistener);
		 driver=e_driver;
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 //driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 
		 
	     driver.get(prop.getProperty("url"));
	     
//	   // WebDriverWait wait = new WebDriverWait(driver,3);
//		 if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"udemy\"]/div[2]/div[4]/div[2]/div[2]/div/div/div/div[1]/div[1]"))).isDisplayed()) {
//		 }else {
//			  driver.get(prop.getProperty("url"));
//		 }
		 
	
	
	
}
}
