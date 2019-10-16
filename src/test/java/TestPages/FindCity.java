package TestPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FindCity {
	WebDriver driver;
	String currentDate = "";

	@Test
	public void bookTickets() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ASHOK\\workspace\\FreeCrmTesting\\Browser_Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");

		driver.findElement(By.xpath("//div[@class='makeFlex']/ul/li[text()='Round Trip']")).click();
		driver.findElement(By.xpath("//label[@for='fromCity']//span[contains(text(),'From')]")).click();
		driver.findElement(By.xpath("//div[@role='combobox']//input")).sendKeys("Hydarabad");
		Thread.sleep(2000);
		WebElement firstSuggest = driver.findElement(
				By.xpath("//p[text()='SUGGESTIONS ']//parent::div/following-sibling::ul//li[1]/div/div/p[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(firstSuggest).click().build().perform();

		
		
		driver.findElement(By.xpath("//label[@for='toCity']//span[contains(text(),'To')]")).click();
		driver.findElement(By.xpath("//div[@role='combobox']//input")).sendKeys("kerala");

		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//p[text()='SUGGESTIONS ']//parent::div/following-sibling::ul//li[1]/div/div/p[1]")).click();
		// action.moveToElement(firstSuggest).click().build().perform();

		// action.moveByOffset(95, 312).click().build().perform();
		// System.out.println(firstSuggest.getLocation());
	}
}
