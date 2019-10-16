package TestPages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WindowHandling {
     WebDriver driver;
     String url="https://www.naukri.com";
	@Test
	public void windowHandling(){
		
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumPract\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
		
	      driver.get(url);
	      driver.manage().window().maximize();
	      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	     
	      
	    
		
		String parent=driver.getWindowHandle();
		System.out.println("Praent window id is: "+parent);
		/*driver.findElement(By.xpath("//a[contains(@href,'http://www.google.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'http://www.facebook.com')]")).click();
		*/
		Set<String> allWindows=driver.getWindowHandles();
		int size=allWindows.size();
		System.out.println("Total No of windows:"+size);
		for(String child:allWindows){
			if(!parent.equalsIgnoreCase(child)){
				driver.switchTo().window(child);
				System.out.println("Chils window title :"+driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		System.out.println("Parent window title: "+driver.getTitle());
		WebElement jobs=driver.findElement(By.xpath("//a[@title='Search Jobs']//div[@class='mTxt']"));
		Actions action=new Actions(driver);
		action.moveToElement(jobs).build().perform();
		
		WebElement submenu=driver.findElement(By.xpath("//div[@class='subMenu c2']//ul[1]//li[4]//a[@title='Register Now']"));
		action.click(submenu);
		driver.findElement(By.xpath("//div[@class='subMenu c2']//ul[1]//li[4]//a[@title='Register Now']")).click();
		
		
		
	}
	
}
