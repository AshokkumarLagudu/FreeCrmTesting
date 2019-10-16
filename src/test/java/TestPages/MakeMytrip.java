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


public class MakeMytrip {
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
		driver.findElement(By.xpath("//div[@role='combobox']//input")).sendKeys("VTZ");
		Thread.sleep(2000);
		WebElement firstSuggest=driver.findElement(By.xpath("//p[text()='SUGGESTIONS ']//parent::div/following-sibling::ul"));
		Actions action=new Actions(driver);
		action.moveToElement(firstSuggest).build().perform();
		
		/*driver.findElement(By
				.xpath("//div[@class='calc60']//p[@class='font16 appendBottom8' and contains(text(),'Visakhapatnam, India')]"))
				.click();*/

		driver.findElement(By.xpath("//label[@for='toCity']//span[contains(text(),'To')]")).click();
		driver.findElement(By.xpath("//div[@role='combobox']//input")).sendKeys("BLR");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='pushRight font14 lightGreyText latoBold' and text()='BLR']"))
				.click();

		/*
		 * driver.findElement(By.xpath(
		 * "//label[@for='departure']//span[text()='DEPARTURE']")).click();
		 * currentDate=driver.findElement(By.
		 * xpath("//div[@class='DayPicker-Day DayPicker-Day--today']//div//p")).
		 * getText(); System.out.println(currentDate);
		 * driver.findElement(By.xpath(
		 * "//label[@for='return']//span[text()='RETURN']")).click(); int
		 * returnDate=Integer.parseInt(currentDate)+20; String
		 * reDate=Integer.toString(returnDate); if(returnDate>31){
		 * 
		 * returnDate=returnDate-31; String returndateXpath =
		 * "//div[@class='dateInnerCell']//p[text()='"+reDate
		 * +"']//parent::div//parent::div[@aria-disabled='false']"; WebElement
		 * nextMonth=driver.findElement(By.
		 * xpath("//span[@aria-label='Next Month']")); nextMonth.click();
		 * 
		 * driver.findElement(By.xpath(returndateXpath)).click();
		 * 
		 * }
		 */

		driver.findElement(By.xpath("//a[text()='Search']")).click();
		try {
			Assert.assertEquals(driver.getTitle(), "Makemytrip");
		} catch (Exception e) {
			System.out.println("Page Titile is-> " + driver.getTitle());
			e.printStackTrace();
		}

		String flight = "//div[@class='splitVw-sctn pull-right']//div[2]//div[@class='fli-list splitVw-listing'][2]//label[@class='splitVw-radio clearfix cursor_pointer']/div[1]/span[1]/span";

		// UtilClass.scrollPage(driver,driver.findElement(By.xpath(flight)));
		WebElement radio = driver.findElement(By.xpath(flight));
		if (!radio.isSelected()) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click()", radio);
		}
	}

}
