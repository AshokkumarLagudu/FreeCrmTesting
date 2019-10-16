package ScreenShotsConcept;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.Baseclass;

public class ScreeenShotTest extends Baseclass {
	public static WebDriver driver;
	@BeforeMethod
	public void setup(){
		initialisation();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void loginpageTest(){
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void homePageTest(){
		Assert.assertEquals(false, true);
	}
	@Test
	public void contactPageTest(){
		Assert.assertEquals(false, true);
	}

}
