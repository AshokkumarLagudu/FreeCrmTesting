package TestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Utils.JSMethods;

public class JavaScriptExecuterPract {

	WebDriver driver=null;
	WebDriverWait wait=null;
	Actions action=null;
	JavascriptExecutor jsExecuter=null;
	@Test
	public void jsPractice(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASHOK\\workspace\\FreeCrmTesting\\Browser_Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, 30);
		driver.get("http://www.globalsqa.com");
		WebElement testerHub=driver.findElement(By.xpath("//a[@class='no_border' and contains(text(),'Tester’s Hub')]"));
		WebElement demoSite=driver.findElement(By.xpath("//span[contains(text(),'Demo Testing Site')]"));
	    action=new Actions(driver);
		action.moveToElement(testerHub).build().perform();
		//action.click(demoSite).build().perform();
		jsExecuter=(JavascriptExecutor)driver;
		//jsExecuter.executeScript("arguments[0].click();",demoSite);
		//jsExecuter.executeScript("arguments[0].setAttribute('style','border: solid 2px red');", demoSite);
		JSMethods.highlightElement(driver, demoSite);
		
	}
	
}
