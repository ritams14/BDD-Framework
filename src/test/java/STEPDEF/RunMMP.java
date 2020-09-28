package STEPDEF;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.Index;
import POM.ReviewBooking;
import POM.SearchDetails;

public class RunMMP {

	static WebDriver driver = null;
	public static ReadProperties prop = new ReadProperties();	
	
	@Before
	public void setUP()  
	{
		// TODO Auto-generated method stub
		String classpath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", classpath+"/src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(prop.readPropfie().getProperty("URL"));
		driver.manage().window().maximize();
		openBrowser();

	}
	
	@Test
	public void openBrowser()
	{
						
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Index.toElementCliclk(driver);		
		
		Index.searchBox(prop, driver);
		
		Index.slidrBtn(driver);
		
		Index.submitBtn(driver);
		
		try 
		{
			Thread.sleep(5000);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SearchDetails.viewPrize(driver);
						
		try 
		{
			Thread.sleep(5000);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
								
		String currentWindow = driver.getWindowHandle(); 
		ArrayList<String> handleList = new ArrayList<String>(driver.getWindowHandles());
		  
		for(String item: handleList) 
		{ 
			driver.switchTo().window(item);
		}		 		
		
		System.out.println("Expected Result :"+prop.readPropfie().getProperty("EXPECTEDTEEXT"));
		System.out.println("Actual Result :"+ReviewBooking.actualText(driver));
		assertEquals(prop.readPropfie().getProperty("EXPECTEDTEEXT"), ReviewBooking.actualText(driver));
					
	}
	
	@After
	public  void tearDown()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
