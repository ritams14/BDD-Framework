package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class second {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create object of DesiredCapabilities class
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		 
		// Set ACCEPT_SSL_CERTS  variable to true
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 
		// Set the driver path
		String Classpath = "C:\\Users\\RITAM PC\\Desktop\\SeleniumDriver\\";
		System.setProperty("webdriver.chrome.driver", Classpath+"chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.merge(cap);
		// Open browser with capability
		WebDriver driver=new ChromeDriver();
		driver.get("https://cacert.org/");
		System.out.println("Done");
	}

}
