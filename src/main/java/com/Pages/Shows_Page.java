package com.Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseClass.Baseclass;
import com.Utils.JSMethods;

public class Shows_Page extends Baseclass {
	public static WebDriverWait wait=new WebDriverWait(driver, 30);
	@FindBy(xpath = "//img[@class='showGridTile__showLogoImage']/parent::div/parent::a")
	private List<WebElement> allShowsLinks;

	By status=By.xpath("//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img/parent::div//div/span/i");
	
	By showTitle=By.xpath("//span[@class='tooltip-wrapper']/i/parent::span/parent::div/parent::div/img");
	
	Shows_Page() {
		PageFactory.initElements(driver, this);
	}

	// By.xpath("//img[@class='showGridTile__showLogoImage']/parent::div/parent::a")
	public List<String> get_All_Shows_Links(By locator) {

		List<String> links = new ArrayList<String>();
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 30));

		List<WebElement> linkElements = driver.findElements(locator);

		for (WebElement element : linkElements) {
			String link = element.getAttribute("href");
			links.add(link);
		}

		return links;
	}

	public List<String> getShowLinkContainsText(List<String> links, String text) {

		List<String> apolloURL = new ArrayList<String>();
		Iterator itr = links.iterator();
		while (itr.hasNext()) {
			String link = itr.next().toString();

			if (link.contains(text)) {

				int n = link.indexOf("/tv-shows");
				apolloURL.add(link.substring(n));

			}
		}

		return apolloURL;
	}

	public List<WebElement> getShowElementsContainsText(By locator,String text) {
		List<WebElement> textURL = new ArrayList<WebElement>();
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 30));
		
		Iterator<WebElement> showlinks = driver.findElements(locator).iterator();

		while (showlinks.hasNext()) {
			WebElement element = showlinks.next();

			String s = element.getAttribute("href");
			if (s.contains(text)) {
				
				textURL.add(element);

			}
		}

		return textURL;

	}
	
	public void verify_show_title(By locator,String title){
		waitforElement(locator);
		String apolloShowTitle=driver.findElement(locator).getAttribute("alt");
	}
	
	public void click_On_Favorite_Icon(By locator){
		waitforElement(locator);
		WebElement status=driver.findElement(locator);
	    status.click();
	}
	
	public String getStatus_Of_Favorite_Icon(By locator){
		
		String st="";
		waitforElement(locator);
		WebElement status=driver.findElement(locator);
		String favoriteStatus=status.getAttribute("class");
		if(favoriteStatus.equals("flipIconCore__icon icon-plus ")){
			 st+="+";
		}else if(favoriteStatus.equals("flipIconCore__icon icon-minus ")){
			st+= "-";
		}
		
		return st;
		
	}
	
	public void click_On_Show(WebElement element){
		waitforElement(element);
		JSMethods.moveToElementAndClick(driver, element);
	}
	
	
	public void waitforElement(WebElement element){
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitforElement(By locator){
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void moveToElementAndClick(WebDriver driver,WebElement element){
		Actions ac=new Actions(driver);
		ac.moveToElement(element).click().build().perform();
	}

}
