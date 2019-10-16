package com.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JSMethods {
	
	//static WebDriver driver=null;
	static JavascriptExecutor jse=null;
	
	public static void highlightElement(WebDriver driver,WebElement element){
		
		jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].setAttribute('style','border: solid 2px red')", element);	
	}
	
	public static void clickElement(WebDriver driver,WebElement element){
		jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
	}
	
	public static void scrollByElement(WebDriver driver,WebElement element){
		
		jse=(JavascriptExecutor)driver;
		jse.executeScript("argument[0].scrollIntoView();",element);
		
	}
	
	public static void scrollByPixels(WebDriver driver,String pixels){
		jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+pixels+")");
	}
	
	public static void scrollToEnd(WebDriver driver){
		
		jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHight)");
	}
	
	public static void moveToElementAndClick(WebDriver driver,WebElement element){
		Actions ac=new Actions(driver);
		ac.moveToElement(element).click().build().perform();
	}
	
	

}
