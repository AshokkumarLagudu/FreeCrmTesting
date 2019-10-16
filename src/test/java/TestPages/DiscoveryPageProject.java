package TestPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BaseClass.Baseclass;
import com.Utils.JSMethods;

public class DiscoveryPageProject extends Baseclass{

	WebDriverWait wait;
	List<String> showTitles=new ArrayList<String>();
	private static List<String> apolloURL;
	@BeforeTest
	public void setup(){
		initialisation();
		wait=new WebDriverWait(driver, 30);
	}
	
	@Test(priority=1)
	public void selectShows(){
		JSMethods.scrollByPixels(driver, "300");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Shows']")));
		driver.findElement(By.xpath("//span[text()='Shows']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("See All Shows")));
		driver.findElement(By.linkText("See All Shows")).click();
	}
	
	//get all apollo shows URL's
	@Test(priority=2)
	public void get_Apollo_Shows_links() throws InterruptedException{
		apolloURL=new ArrayList<String>();
		
		Thread.sleep(5000);
		
		JSMethods.scrollByPixels(driver, "2600");
		//wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//img[@class='showGridTile__showLogoImage']/parent::div/parent::a"), 30));
		
		wait.until(ExpectedConditions.attributeContains(By.xpath("//img[@class='showGridTile__showLogoImage']/parent::div/parent::a"), "href", "/tv-shows/confessions-from-space-apollo"));
		
		//Thread.sleep(7000);
		List<WebElement> links=driver.findElements(By.xpath("//img[@class='showGridTile__showLogoImage']/parent::div/parent::a"));
         System.out.println("No Of Links :"+links.size());
		for(WebElement element:links){
			System.out.println(element.getAttribute("href"));
			String s=element.getAttribute("href");
			if(s.contains("apollo")){
				
				System.out.println("Apollo : "+element.getAttribute("href"));
				int n=element.getAttribute("href").indexOf("/tv-shows");
				apolloURL.add(element.getAttribute("href").substring(n));
				
				}
				
		}
		
		System.out.println("Apollo shows url's :"+apolloURL.size());

   }
	
	@Test(priority=3)
	public void click_on_Apollo_Shows() throws InterruptedException{
	
		//Iterating all apolloURL's stored in list "apolloURL"
		for(String apollourl:apolloURL){
			
			Thread.sleep(5000);
			
			WebElement apolloElement=driver.findElement(By.xpath("//img[@class='showGridTile__showLogoImage']/parent::div/parent::a[@href='"+apollourl+"']"));

			JSMethods.moveToElementAndClick(driver, apolloElement);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img")));
			String apolloShowTitle=driver.findElement(By.xpath("//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img")).getAttribute("alt");
			Thread.sleep(3000);
			
			if(apolloShowTitle.contains("Apollo")){
				System.out.println("Shows Name :"+apolloShowTitle);
				
				WebElement status=driver.findElement(By.xpath("//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img/parent::div//div/span/i"));
				String favoriteStatus=status.getAttribute("class");
			
			    if(favoriteStatus.equals("flipIconCore__icon icon-plus ")){
			    	
			    	System.out.println("Favorites Status : +");
			    	status.click();
			    	showTitles.add(apolloShowTitle);
			    	
			    	Thread.sleep(3000);
			    	
			    	WebElement afterClickstatus=driver.findElement(By.xpath("//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img/parent::div//div/span/i"));
					String  favoritestatus=afterClickstatus.getAttribute("class");
					System.out.println("After click :"+favoritestatus);
					
			    }else if(favoriteStatus.equals("flipIconCore__icon icon-minus ")){
			    	
			    	System.out.println("Favorites Status : -");
			    	status.click();
			    	
			    	Thread.sleep(3000);
			    	
			    	WebElement afterClickstatus=driver.findElement(By.xpath("//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img/parent::div//div/span/i"));
					String favoritestatus=afterClickstatus.getAttribute("class");
					System.out.println("After click :"+favoritestatus);
			    }
			    
			    
			 
			    driver.navigate().back();
			
			}
		}
	}
	
	
	@Test(priority=4)
	public void verify_Favorite_Shows_Titles(){
		driver.navigate().to("http://go.discovery.com/my-videos");
		List<WebElement> favoriteShowsTitles=driver.findElements(By.xpath("//h2[text()='Favorite Shows']/parent::div//div[@class='showTileSquare__content']/h3/div"));
		System.out.println("favoriteShowsTitles size :"+favoriteShowsTitles.size());
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



/*
 * JSMethos
 * public static void moveToElementAndClick(WebDriver driver,WebElement element){
	Actions ac=new Actions(driver);
	ac.moveToElement(element).click().build().perform();
}*/











