package TestPages;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class ReuseMethods {
	
	public static WebElement fluentWait(WebDriver driver,int pollingTime,int timeout,final String xpath){
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.withTimeout(timeout, TimeUnit.SECONDS);
		WebElement element=wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver d) {
				
				WebElement ele=d.findElement(By.xpath(xpath));
				// Will capture the inner Text and will compare will WebDriver
				 
				// If condition is true then it will return the element and wait will be over
				 
				                     if (ele.getAttribute("href").equalsIgnoreCase("/party/person/new")) 
				                      {
				 
				                          System.out.println("Value is >>> " + ele.getAttribute("href"));
				 
				                          return ele;
				 
				                     }
				 
				// If condition is not true then it will return null and it will keep checking until condition is not true
				 
				else {
				        System.out.println("Value is >>> " + ele.getAttribute("href"));
				 
				return null;
				}
				
			}
		});
		
		return element;
		
	}

}
