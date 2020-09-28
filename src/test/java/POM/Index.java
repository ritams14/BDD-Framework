package POM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import STEPDEF.ReadProperties;

/**
 * @author Ritam
 * Class to search by search param of Flights in Make My Trip
 */
public class Index {

	static By toElementCliclk = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/label");
	static By searchBox = By.xpath("//*[@id=\"react-autowhatever-1\"]/div[1]/ul");
	static By submitBtn = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a");
	static By slidrBtn = By.xpath("//*[@id=\"Offers_Listing\"]/div[2]/div/button[2]");
	public static By tofld = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input");
	
	public static void toElementCliclk(WebDriver driver) 
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(toElementCliclk));
	}

	public static void searchBox(ReadProperties prop, WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(tofld));
		driver.findElement(tofld).sendKeys(prop.readPropfie().getProperty("SEARCHKEY"));		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		List<WebElement> allElements = driver.findElements(searchBox);
		  
		for (WebElement element : allElements) 
		  { 			  			  
			  if(element.getText().trim().contains("Mumbai"))
			  { 
				  wait.until(ExpectedConditions.elementToBeClickable(element));
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);				  
				  JavascriptExecutor jse = (JavascriptExecutor) driver;
				  jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]/p[1]")));
				  break;
			  }		  
		  }		 		  
	}
	
	public static void submitBtn(WebDriver driver)
	{
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(submitBtn));
	}
	
	public static void slidrBtn(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(slidrBtn));
	}
	
}
