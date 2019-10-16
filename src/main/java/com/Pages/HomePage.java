package com.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Baseclass;

public class HomePage extends Baseclass {
	@FindBy(xpath="//div[@id='navmenu']/ul/li[2]/a[@title='Calendar']")
     WebElement calendar;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public Calender openCalendar(){
		driver.switchTo().frame(1);
		//calendar.click();
		
		Actions actions=new Actions(driver);
		actions.moveToElement(calendar).build().perform();
		
		
		return new Calender();
	}
	public static void highlightElement(WebDriver driver,WebElement element){
    	
		JavascriptExecutor se=(JavascriptExecutor)driver; 
		  se.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red;');",element);	
			
    }

}
