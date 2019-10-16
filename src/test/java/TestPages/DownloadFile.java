package TestPages;

import java.io.File;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadFile {
	
	WebDriver driver;
	File folder;
	
	@BeforeMethod
	public void setup(){
		
			folder=new File(UUID.randomUUID().toString());
			folder.mkdir();
			
		//firefox
			System.setProperty("webdriver.gecko.driver",
					"E:\\SeleniumPract\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			
			FirefoxProfile profile=new FirefoxProfile();
			profile.setPreference("browser.download.dir", folder.getAbsolutePath());
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"image/jpeg, application/pdf, application/octet-stream");
			profile.setPreference("browser.download.manager.shownWenStarting", false);
			profile.setPreference("pdfjs.disabled", true);
			
			
			
			FirefoxDriver driver=new FirefoxDriver();
			
			
		//Chrome
	
			/*System.setProperty("webdriver.chrome.driver","E:\\SeleniumPract\\Chromedriver\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			
			Map<String,Object> prefs=new HashMap<String,Object>();
			prefs.put("profile_default_content_settings.popups", 0);
			prefs.put("download.default_directory", folder.getAbsolutePath());
			
			options.setExperimentalOption("prefs",prefs);
			DesiredCapabilities dc=DesiredCapabilities.chrome();
			
			dc.setCapability(ChromeOptions.CAPABILITY, options);
			driver=new ChromeDriver(dc);*/
			
	}
	
	@Test
	public void downloadfileTest() throws InterruptedException{
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		
		Thread.sleep(2000);
		
		File listofFiles[]=folder.listFiles();
		Assert.assertTrue(listofFiles.length>0);
		
		for(File file:listofFiles){
			Assert.assertTrue(file.length()>0);
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		for(File file:folder.listFiles()){
			file.delete();
		}
		folder.delete();
	}
	

}











