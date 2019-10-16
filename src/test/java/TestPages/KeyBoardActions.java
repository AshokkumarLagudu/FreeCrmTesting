package TestPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyBoardActions {
	
	WebDriver driver;
	
	@Test
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumPract\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.hubspot.com");
		driver.switchTo().alert().dismiss();
		
		
	}
	
	@Test
	public void usingKeyBoard(){
		
		//WebElement login=driver.findElement(By.cssSelector("a.cta--secondary.cta--small"));
		WebElement login=driver.findElement(By.xpath("//a[@class='cta--secondary cta--small']"));
		login.click();
		Actions ac=new Actions(driver);
        ac.keyDown(Keys.CONTROL).keyDown(Keys.ENTER);
		
	}

} 

       
