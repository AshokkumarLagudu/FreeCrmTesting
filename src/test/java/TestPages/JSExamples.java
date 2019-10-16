package TestPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExamples {
	WebDriver driver;
	JavascriptExecutor jse;
	
	@BeforeMethod
	public void init(){
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumPract\\Chromedriver\\chromedriver.exe");
        driver=new ChromeDriver(); 
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
	}
	
	@Test(enabled=false)
	public void jsMethod() throws InterruptedException{
		
		
		jse=(JavascriptExecutor)driver;
		jse.executeScript("alert('My Example alert')");
		
			Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
	}
	
	@Test
	public void history() throws InterruptedException{
		
		//driver.navigate().to("http://www.gmail.com");
		jse=(JavascriptExecutor)driver;
		jse.executeScript("window.location='http://www.thehindu.com'");
		String title1=jse.executeScript("return document.URL;").toString();
		System.out.println(title1);
		driver.findElement(By.xpath("//ul[@class=' hidden-xs']/li[2]")).click();
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		//jse.executeScript("arguments[0].click();",news);
		jse.executeScript("history.go(-2)");
		Thread.sleep(3000);
		String title=jse.executeScript("return document.URL;").toString();
		System.out.println(title);
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}

}








