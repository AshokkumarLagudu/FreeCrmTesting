package ScreenShotsConcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SeleniumPractice {
	
	static WebDriver driver;
	
	@Test
	public static void openBrowser(){
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--headless");
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumPract\\Chromedriver\\chromedriver.exe");
        driver=new ChromeDriver(co);   
        
        driver.get("http://amazon.com");
        System.out.println(driver.getTitle());
	}

}
