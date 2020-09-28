package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchDetails 
{

	static By viewPrize = By.xpath("//button[text()='View Prices']");
	static By bookNow = By.xpath("//button[text()='Book Now']");
	
	public static void viewPrize(WebDriver driver) 
	{	
		
		List<WebElement> booknowBUTTON = driver.findElements(bookNow);
		List<WebElement> viewPrizeBUTTON = driver.findElements(viewPrize);

		if(viewPrizeBUTTON.size() != 0)
		{
			for(WebElement viewbtn : viewPrizeBUTTON)
			{
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click()", viewbtn);
				break;
			}
		}
		
		else if(booknowBUTTON.size() != 0)
		{
			for(WebElement booknowbtn : booknowBUTTON)
			{
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click()", booknowbtn);
				break;
			}
			
		}
		
	}
	
}
