package com.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {

	public static WebDriver driver;
	public static Properties prop;
	private static WebDriverWait wait;

	public Baseclass() {
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream("C:\\Users\\ASHOK\\workspace\\FreeCrmTesting"
					+ "\\src\\main\\java\\com\\Config\\config.properties");

			prop.load(fis);
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialisation() {
          
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumPract\\Chromedriver\\chromedriver.exe");
            driver=new ChromeDriver();
            wait=new WebDriverWait(driver, 30);
		}
		else if(browsername.equals("firefox")){
			
			System.setProperty("webdriver.gecko.driver","E:\\SeleniumPract\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			wait=new WebDriverWait(driver, 30);
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));
		driver.get("https://go.discovery.com/");
		
		
	}
	
	
	
	public void failTest(String testMethodName){
		
		
		File takeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(takeScreenShot,new File("\\Users\\ASHOK\\workspace\\FreeCrmTesting\\ScreenShots"
		      +testMethodName+"_"+".jpg"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}

















