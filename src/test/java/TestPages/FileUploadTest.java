package TestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadTest {
	
	WebDriver driver;
	
	@Test
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumPract\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.toolsqa.com/automation-practice-form");
		driver.findElement(By.id("photo")).sendKeys("C:\\Users\\Ashok\\Desktop\\photo.png");
		
	}

}
