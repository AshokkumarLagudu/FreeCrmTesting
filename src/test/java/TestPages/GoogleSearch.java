package TestPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseClass.Baseclass;

public class GoogleSearch extends Baseclass{
	
	GoogleSearch(){
		initialisation();
	}
	
	@Test
	public void enterUrl(){
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("aviva");
		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).click();
		List<WebElement> links=driver.findElements(By.xpath("//span[@class='mn-dwn-arw' ]/ancestor::span/parent::div/a/h3/parent::a"));
		for(WebElement link:links){
			System.out.println(link.getAttribute("href"));
		}
		
		System.out.println(links.size());
	}

}






//a/following-sibling::span/div[@class='action-menu ab_ctl']/parent::span/preceding-sibling::a

//span/div[@class='action-menu ab_ctl']/parent::span/preceding-sibling::a


//span[@class='mn-dwn-arw' ]/ancestor::span/parent::div/a/h3/parent::a