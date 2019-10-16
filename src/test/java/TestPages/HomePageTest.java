package TestPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.Baseclass;
import com.Pages.HomePage;
import com.Pages.LoginPage;

import XSSF_Files_Class.Xls_Reader;

public class HomePageTest extends Baseclass {
	LoginPage loginpage;
	HomePage homepage;
	String path="C:\\Users\\ASHOK\\workspace\\FreeCrmTesting\\MynewBook.xlsx";
	Write_File reader;
	Xls_Reader xlreader;
	public HomePageTest(){
		super();
			
	}
	
	@BeforeMethod
	public void setup(){
		initialisation();
		loginpage=new LoginPage();
		reader=new Write_File();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test
	public void testCalender(){
		
		try {
			homepage.openCalendar();
			
			String monthName=driver.findElement(By.xpath("//select[@name='slctMonth']/option[@selected]")).getText();
			List date=driver.findElements(By.xpath("//div[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[1]/td"));
			//System.out.println("Month Name : "+monthName);
			System.out.println("Size of first row: "+date.size());
			if(monthName.equalsIgnoreCase("August")){
				System.out.println("We are in Calendar Page");
				
			}
			
			int size=date.size();
			for(int i=1;i<7;i++){
				for(int j=1;j<size;j++){
				String weekName=
						driver.findElement(By.xpath("//div[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[1]/td["+j+"]")).getText();
				String dt=
						driver.findElement(By.xpath("//div[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				WebElement hover=driver.findElement(By.xpath("//div[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td["+j+"]"));
				try {
					
					//reader.write_Data(dt, i, j);
					xlreader.setCellData("NewSheet", "Calendar", 2, dt, path);
					//xlreader.setCellData(sheetName, colName, rowNum, data, url)
			
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(weekName.equalsIgnoreCase("sun")&&i!=1){
					System.out.println("");
					System.out.println("Week name is : "+weekName+" : "+dt);
					
					
				}else if(i!=1)
					homepage.highlightElement(driver,hover);
				System.out.println("Week name is : "+weekName+" : "+dt);
			}
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@AfterMethod
	public void terarsDown(){
		//driver.close();
	}
	

}
