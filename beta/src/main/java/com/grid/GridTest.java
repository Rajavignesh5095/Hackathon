package com.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridTest {

	public static void main(String[] args) throws MalformedURLException {
		
		System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\Driver\\geckodriver.exe");
		
		DesiredCapabilities dcap = new DesiredCapabilities();
		dcap.setCapability("browser", "Firefox");
		dcap.setPlatform(Platform.WIN10);
		
		FirefoxOptions options = new FirefoxOptions();
		((Capabilities) options).merge(dcap);
		
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.10:4444/wd/hub"),(Capabilities) options);
		
		driver.get("https://www.udemy.com/");
		System.out.println(driver.getTitle());
		
		}

}