package TestPages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Capsulecrm {
	
	WebDriver driver;
	public static WebDriverWait wait;
	
	@Test
	public void login(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ASHOK\\workspace\\FreeCrmTesting\\Browser_Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 30);
		driver.get("https://ashokkumar.capsulecrm.com/login");
		
		WebElement uname=driver.findElement(By.xpath("//div[@class='clearfix']/div[@id='login:usernameDecorate']//div[@class='prop']//span/input"));
		WebElement pwd=driver.findElement(By.xpath("//div[@class='clearfix']/div[@id='login:passwordDecorate']//div[@class='prop']//span/input"));
		WebElement login=driver.findElement(By.xpath("//input[@type='submit']"));
		
		
		uname.sendKeys("Ashokkumar");
		pwd.sendKeys("Ashok.236");
		login.click();
		
		WebElement people=driver.findElement(By.xpath("//div[@class='nav-bar-section nav-bar-main is-teams-launch']//nav[@role='navigation']//span[2]/a"));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='nav-bar-section nav-bar-main is-teams-launch']//nav[@role='navigation']//span[2]/a")))).click();
		/*try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<WebElement> ele=driver.findElements(By.tagName("a"));
		for(WebElement e:ele){
			System.out.println(e.getAttribute("href"));
		}
		*/
		//driver.findElement(By.xpath("//a[@href='/party/person/new']"));
		
		String xpath="//a[@href='/party/person/new']";
		WebElement element=ReuseMethods.fluentWait(driver, 1, 20, xpath);
		element.click();
			
		}
		/*System.out.println(addperson.getLocation());
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click()", addperson);
		*/
	
	
	

}
