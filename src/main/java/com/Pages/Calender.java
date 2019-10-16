package com.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Baseclass;

public class Calender extends Baseclass{
	
	@FindBy(xpath="//a[@title='Calendar']")
	WebElement calender;
	
	public Calender(){
		PageFactory.initElements(driver, this);
	}
     
    
	
	
}
