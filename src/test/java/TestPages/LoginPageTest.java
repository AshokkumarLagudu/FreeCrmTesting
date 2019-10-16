package TestPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.Baseclass;
import com.Pages.HomePage;
import com.Pages.LoginPage;

public class LoginPageTest extends Baseclass {
	
	LoginPage loginpage;
	HomePage homepage;
	BrokenLinks brokenlinks;
	public LoginPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void setup(){
		
		initialisation();
		loginpage= new LoginPage();
		homepage=new HomePage();
		
	}
	@Test
	public void logintest(){
		
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		//brokenlinks.brokenlinks_Test();
	}
	@Test
	public void calender(){
		homepage.openCalendar();
		
	}
	
	@AfterMethod(enabled=false)
	public void teardown(){
		
		driver.quit();
	}

}
