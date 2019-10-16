package TestPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BaseClass.Baseclass;
import com.Utils.JSMethods;

public class DiscoveryPageTest extends Baseclass {
	List<String> showTitles=new ArrayList<String>();
	private static List<String> apollolinks;
	@BeforeTest
	public void setup(){
		initialisation();
	}
	
	@Test(priority=1)
	public void selectShows(){
		JSMethods.scrollByPixels(driver, "300");
		driver.findElement(By.xpath("//span[text()='Shows']")).click();
		driver.findElement(By.linkText("See All Shows")).click();
	}
	@Test
	public void get_Apollo_links() throws InterruptedException{
		
		
		Thread.sleep(5000);
		
		List<WebElement> links=driver.findElements(By.xpath("//img[@class='showGridTile__showLogoImage']/parent::div/parent::a"));
		
		JSMethods.scrollByPixels(driver, "2600");
		
		Thread.sleep(7000);
		
		for(WebElement element:links){
			System.out.println(element.getAttribute("href"));
			String s=element.getAttribute("href");
			if(s.contains("apollo")){
				
				System.out.println("Apollo : "+element.getAttribute("href"));
				apollolinks=new ArrayList<String>();
				apollolinks.add(element.getAttribute("href"));
				
				}
				
				
			
		}

   }
	@Test(priority=2)
	public void selectAppolo() throws InterruptedException{
				
		
		
		for(String element:apollolinks){
			WebElement apolloElement=driver.findElement(By.xpath("//img[@class='showGridTile__showLogoImage']/parent::div/parent::a[@href='"+element+"]"));
			String s=apolloElement.getAttribute("href");
			if(s.contains("apollo")){
				System.out.println("Apollo : "+apolloElement.getAttribute("href"));
				
				JSMethods.moveToElementAndClick(driver, apolloElement);
				String apollo=driver.findElement(By.xpath("//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img")).getAttribute("alt");
				Thread.sleep(3000);
				if(apollo.contains("Apollo")){
					System.out.println("Shows Name :"+apollo);
					
					WebElement status=driver.findElement(By.xpath("//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img/parent::div//div/span/i"));
					String fvrtstatus=status.getAttribute("class");
				
				    if(fvrtstatus.equals("flipIconCore__icon icon-plus ")){
				    	System.out.println("Favorites Status : +");
				    	status.click();
				    	showTitles.add(apollo);
				    	Thread.sleep(3000);
				    	WebElement astatus=driver.findElement(By.xpath("//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img/parent::div//div/span/i"));
						String afvrtprintlnstatus=status.getAttribute("class");
						System.out.println("After click :"+afvrtprintlnstatus);
						
				    }else{
				    	System.out.println("Favorites Status : -");
				    	status.click();
				    	
				    	Thread.sleep(3000);
				    	WebElement astatus=driver.findElement(By.xpath("//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img/parent::div//div/span/i"));
						String afvrtprintlnstatus=status.getAttribute("class");
						System.out.println("After click :"+afvrtprintlnstatus);
				    }
				    
				    
				 
				    driver.navigate().back();
				
				}
				
				
			}
		}
		//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img
		
		//class="flipIconCore__icon icon-minus "
		//class="flipIconCore__icon icon-plus "
		
		
		
		//h2[text()='Favorite Shows']/parent::div//div[@class='showTileSquare__content']/h3/div		
		//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img/parent::div//div/span/i
	}
	
	@Test(priority=3)
	public void verify_Favorite_Shows_Titles(){
		driver.navigate().to("http://go.discovery.com/my-videos");
		List<WebElement> fvtTitles=driver.findElements(By.xpath("//h2[text()='Favorite Shows']/parent::div//div[@class='showTileSquare__content']/h3/div"));
		System.out.println("fvtTitles size :"+fvtTitles);
	//	driver.findElement(By.xpath("//div[contains(text(),'Apollo: The Forgotten Films')]"));
		////div[contains(text(),'Confessions From Space: Apollo')]
		for(String title:showTitles){
			
			if(driver.findElement(By.xpath("//div[contains(text(),'"+title+"')]"))!=null){
				
				System.out.println(title+" is in favourit list");
			}else{
				System.out.println(title+" is not in favourit list");
			}
		}
	}
	

}


/*for(WebElement title:fvtTitles){
	System.out.println("===== "+title.getText()+" =====");
	if(showTitles.contains(title.getText())){
		System.out.println(title.getText()+" is in favourit list");
	}else{
		System.out.println(title.getText()+" is not in favourit list");
	}
}
*/














