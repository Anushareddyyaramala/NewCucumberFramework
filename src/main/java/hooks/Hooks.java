package hooks;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import basePackage.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Hooks extends BaseClass{
    
	@Before
	public void launch_Browser() {
		String Browser="Edge";
		if(Browser.equalsIgnoreCase("CHROME")) {
			
			WebDriverManager.chromedriver().setup();
//			ChromeOptions options=new ChromeOptions();
//			options.addArguments("--disabled -- all notifications");
			driver=new ChromeDriver();
			
			
		}else if (Browser.equalsIgnoreCase("EDGE")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
	}
	
//	
//	@After
//	public void closeAllBrowsers() {
//		driver.quit();
//	}
	
}
