package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseClass.Baseclass;

public class MyVideos_Page extends Baseclass{
	
	private static WebDriverWait wait=new WebDriverWait(driver, 30);
	
	@FindBy(xpath="//h2[text()='Favorite Shows']/parent::div//div[@class='showTileSquare__content']/h3/div")
	private List<WebElement> favorite_Videos;
	
	@FindBy(xpath="")
	private WebElement favorite_Video_Title;
	
	MyVideos_Page(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean hasVideoWithTitle(String title){
		if(driver.findElement(By.xpath("//div[contains(text(),'"+title+"')]"))!=null){
			
			return true;
		}else{
			return false;
		}
	}
	By favorite_Video=By.xpath("//h2[text()='Favorite Shows']/parent::div//div[@class='showTileSquare__content']/h3/div");
	public int get_Total_favorite_Videos(){
		waitforElement(favorite_Video);
		return favorite_Videos.size();
	}
	
	public void waitforElement(WebElement element){
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitforElement(By locater){
		wait.until(ExpectedConditions.elementToBeClickable(locater));
	}

}
