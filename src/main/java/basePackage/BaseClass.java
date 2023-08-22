package basePackage;

import org.openqa.selenium.WebDriver;

import genericUtils.JavaUtility;
import genericUtils.WebDriverUtils;
import objectRepository.HomePage;
import objectRepository.ProductPage;

public class BaseClass {

	public static WebDriver driver;
	public WebDriverUtils webUtils=new WebDriverUtils(BaseClass.driver);
	public JavaUtility javaUtil=new JavaUtility();
	public HomePage homePage;	
	public ProductPage productpage;
	}
