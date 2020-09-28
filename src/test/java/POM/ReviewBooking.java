package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewBooking {
	
	static By actualText = By.xpath("//*[@id=\"rev-header\"]/div/div/div/h4");
	
	public static String actualText(WebDriver driver) 
	{
		
		return driver.findElement(actualText).getText();
	}

}
