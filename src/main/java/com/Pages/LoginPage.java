package com.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Baseclass;

public class LoginPage extends Baseclass  {
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uName,String pwd){
		
		username.sendKeys(uName);
		password.sendKeys(pwd);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginButton);
		
		return new HomePage();
	}
	
	

}
