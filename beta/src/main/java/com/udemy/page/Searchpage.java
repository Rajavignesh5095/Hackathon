package com.udemy.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.udemy.base.Testbase;




public class Searchpage extends Testbase {
	
	
	@FindBy(name="q")
	WebElement searchbox;
	 
	
	@FindBy(xpath="//button[@class='btn btn-link']")
	WebElement buttonsearch;
	 
	
	@FindBy(xpath="//button[@class='filter-button--filter-button--y-iVA btn btn-quaternary']")
	WebElement filtersearch;
	 
	 
	@FindBy(css=".filter--filter-container--1ftIU:nth-child(3) > .filter-option--checkbox--3Ar4b:nth-child(3) .toggle-control-label")
	WebElement filterscheckbox;
	 
	 
	@FindBy(css=".filter--filter-container--1ftIU:nth-child(4) > .filter-option--checkbox--3Ar4b:nth-child(2) .toggle-control-label")
	WebElement filterselect;
	 
	 
	@FindBy(xpath="//h1[contains(text(),'Web Development Courses')]")
	WebElement courselabel;
	
	@FindBy(xpath="//*[@id=\\\"filter-form--13\\\"]/fieldset[4]/button")
	WebElement seemore;
	
	@FindBy(xpath="//fieldset[@name='Language']//parent::div")
	WebElement languages;
	
	List<WebElement> course = driver.findElements(By.className("list-view-course-card--title--2pfA0"));
	List<WebElement> learninghours = driver.findElements(By.className("list-view-course-card--meta-item--1Pyfe"));
	List<WebElement> ratings = driver.findElements(By.className("ml5"));
	
	public Searchpage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void validatesearchboxbtn() {
		searchbox.sendKeys(prop.getProperty("coursename"));
		buttonsearch.click();
		}
	

	
	
	public void validatefilterbtn() throws InterruptedException {
		searchbox.sendKeys(prop.getProperty("coursename"));
		buttonsearch.click();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filtersearch);
		Thread.sleep(500); 
		filtersearch.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filtersearch);
		Thread.sleep(500); 
		filterscheckbox.click();
		
		
	}
	
	public void validateCourse() {
		searchbox.sendKeys(prop.getProperty("coursename"));
		buttonsearch.click();
		wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		filtersearch.click();
		filterscheckbox.click();
		filtersearch.click();
		filterselect.click();
		List<WebElement> course = driver.findElements(By.className("list-view-course-card--title--2pfA0"));
		List<WebElement> learninghours = driver.findElements(By.className("list-view-course-card--meta-item--1Pyfe"));
		List<WebElement> ratings = driver.findElements(By.className("ml5"));
		int a = 0;
		for (int i = 0; i < 2; i++) {
			wait.until(ExpectedConditions.visibilityOf(course.get(i)));

			for (int j = 1; j < 2; j++) {

				System.out.println("\n\n"+(a + 1) + " " + course.get(i).getText() + "\n" + "learning hours   "
						+ learninghours.get(j).getText() + "\n" + "ratings   " + ratings.get(i).getText());
				a++;
			}
		}
	}
	
	
	public void validatefilter() {
		searchbox.sendKeys(prop.getProperty("coursename"));
		buttonsearch.click();
		wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver
				.findElement(By.xpath("//button[@class='filter-button--filter-button--y-iVA btn btn-quaternary']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		filtersearch.click();
		WebElement Element1 = driver.findElement(By.xpath("//*[@id=\"filter-form--13\"]/fieldset[4]/button"));
		js.executeScript("arguments[0].scrollIntoView();", Element1);
		seemore.click();
		

		List<WebElement> language = driver.findElements(By.xpath("//fieldset[@name='Language']//parent::div"));
		int num = language.size();

		int a = 0;
		System.out.println("\n" + "\n" + "languages :");
		for (int i = 0; i < num; i++) {
			wait.until(ExpectedConditions.visibilityOf(language.get(i)));

			System.out.println((a + 1) + " " + language.get(i).getText());

			a++;

		}
		List<WebElement> level = driver.findElements(By.xpath("//fieldset[@name='Level']//parent::div"));
		int count = level.size();
		int b = 0;
		System.out.println("\n" + "\n" + "Level :");
		for (int i = 0; i < count; i++) {
			wait.until(ExpectedConditions.visibilityOf(level.get(i)));

			System.out.println(+(b + 1) + " " + level.get(i).getText());
			b++;
		}
	}
	
	
	public boolean validatecourseLabel() throws InterruptedException {
		searchbox.sendKeys(prop.getProperty("coursename"));
		buttonsearch.click();
		Thread.sleep(1000);
		return courselabel.isDisplayed();
	}
	
}
