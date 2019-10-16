package TestPages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.Baseclass;
import com.Pages.HomePage;
import com.Pages.LoginPage;

public class BrokenLinks extends Baseclass {

	String url = "";
	String login = "https://classic.crmpro.com";
	HttpURLConnection htconn = null;
	int respCode = 200;
	LoginPage loginpage;
	HomePage homepage;
	
	public BrokenLinks(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		loginpage=new LoginPage();
		homepage= new HomePage();
	}
	@Test(enabled=false)
	public void logintest(){
		
	}

	@Test
	public void brokenlinks_Test() {
		//loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> iter = links.iterator();
		while (iter.hasNext()) {
			url = iter.next().getAttribute("href");
			System.out.println(url);
			if (url == null || url.isEmpty()) {
				System.out.println("URL not configured for anchor tag or it is empty");
				continue;
			}
			
			if (!url.startsWith(login)) {
				System.out.println("url belongs to another domain, skipped it");
				continue;
			}

			try {
				htconn = (HttpURLConnection)(new URL(url).openConnection());
				htconn.setRequestMethod("HEAD");
				htconn.connect();

				respCode = htconn.getResponseCode();
				System.out.println("Response Cose :"+respCode);

				if (respCode >= 400) {
					System.out.println(url + " is broken link");
				} else {
					System.out.println(url + " is valid link");
				}

			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();;
	}

}
