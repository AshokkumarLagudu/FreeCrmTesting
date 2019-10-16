package TestPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeInvestTest {
	WebDriver driver;
	 
    
    @Test
    public void changeSPDR() throws InterruptedException{
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASHOK\\workspace\\WeInvest\\Browser_Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
         
		driver.get("https://sfo-demo.herokuapp.com/explore_portfolio/1");
		
		driver.findElement(By.xpath("//a[text()='Customise']")).click();
		Thread.sleep(5000);
		
		WebElement spdr=driver.findElement(By.xpath("//div[@class='row constituent-row vertical-align']//a[text()='SPDR S&P 500 ETF TRUST  SPY US EQUITY']"));
		
		if(spdr.isDisplayed()){
		
		WebElement changeValue=driver.findElement(By.xpath("//div[@class='row constituent-row vertical-align']"
				+ "//a[text()='SPDR S&P 500 ETF TRUST  SPY US EQUITY']//parent::div"
				+ "//preceding-sibling::div[@class='col-md-3 ']//div[2]"));
		
		WebElement changeValue1=driver.findElement(By.xpath("//div[@class='row constituent-row vertical-align']"
				+ "//a[text()='SPDR S&P 500 ETF TRUST  SPY US EQUITY']//parent::div"
				+ "//preceding-sibling::div[@class='col-md-3 ']//div[2]/input"));
		
		String beforeChange=changeValue1.getAttribute("value");
		
		System.out.println(beforeChange);
		
		Actions ac=new Actions(driver);
		ac.moveToElement(changeValue).build().perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','50');",changeValue);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[text()='Rebalance']")).click();
		
		Thread.sleep(5000);
		
		WebElement afterChangeValue=driver.findElement(By.xpath("//div[@class='row constituent-row vertical-align']"
				+ "//a[text()='SPDR S&P 500 ETF TRUST  SPY US EQUITY']//parent::div"
				+ "//preceding-sibling::div[@class='col-md-3 ']//div[2]"));
		
		String afterChange=afterChangeValue.getAttribute("value");
		
		Assert.assertEquals(afterChange,"50");
		
		System.out.println(changeValue.getAttribute("value"));
		}else{
			System.out.println("SPDR S&P 500 ETF TRUST  SPY US EQUITY is not present");
		}
		
		driver.findElement(By.xpath("//a[text()='Invest Now']")).click();
    }
     
}
