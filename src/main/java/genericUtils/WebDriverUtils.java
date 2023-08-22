package genericUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePackage.BaseClass;


public class WebDriverUtils {
	
	WebDriver driver;
	public WebDriverUtils(WebDriver driver){
		this.driver=driver;
	}
	
	/*
	 * Maximizing Window
	 */
	public void maximiseWindow() {
		driver.manage().window().maximize();
	}

	/*
	 * Launching Browser
	 */
	public void getUrl(String URL) {
		
		driver.get(URL);
	}
	/*
	 * Clicking Element
	 */

	public void clickElement(WebElement element) {
		element.click();
	}

	/*
	 * Sending data to webelement
	 */
	public void sendDatatoElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	/*
	 * method for get text
	 */

	public void getdata(WebElement element) {
		String data = element.getText();
		System.out.println("message:" + data);
	}
	/*
	 * Method for implicity wait
	 */

	public void implicityWait() {
		BaseClass.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/*
	 * Multiple Window handles
	 */

	public void windowHandling(WebDriver driver, int index) {

		Set<String> allwindows = driver.getWindowHandles();
		ArrayList<String> particularWindow = new ArrayList<String>(allwindows);
		driver.switchTo().window(particularWindow.get(index));
	}
	/*
	 * JavaScript Scroll action
	 */

	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
	}

	/*
	 * Actions class mousehover
	 */
	public static void mouseHover(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

	}

	/*
	 * Actions class click action
	 */
	public static void ClickAction(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.click(ele).build().perform();

	}

	/*
	 * WebDriver wait for visibility of element
	 */

	public void waitForElementToLoad(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/*
	 * JavaScript Click method
	 */
	public void javascriptClick(WebElement ele, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0],click();", ele);

	}

	public void displayed(WebElement element) {
		boolean value = element.isDisplayed();
	}
public void acceptAlert() {
	driver.switchTo().alert().accept();
}
	/*
	 * Screenshots method
	 */
	public void addScreenShots(WebDriver driver, String screenShotName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\ScreenShots\\" + screenShotName + ".png" + new JavaUtility().getSystemDateInFormat();
		File destination = new File(path);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/*
	 * Assert euals method
	 */
	public void assertEqualsValidation(WebElement ele1, WebElement ele2) throws IOException  {
		String expect=ele1.getText();
		String actual=ele2.getText();
		Assert.assertEquals(expect, actual);
		System.out.println("Assertion passed: TRUE");
	}
	
	/*
	 * Assert equls validation with 2 strings
	 */
	
	public void expectedactualValidation(String Expected,String Actual) {
		assertionEqualswithdata(Expected,Actual);
	}
	
	/*
	 * 
	 */
	public void assertionEqualswithdata(String expected, String actual) {
		Assert.assertEquals(expected, actual);
		
	}
	/*
	 * Assert true method
	 */
	
	public void assertTrueValidation(WebElement ele) {
		boolean value=ele.isDisplayed();
		Assert.assertTrue(value);
		System.out.println("Assertion passed");
	}
	/*
	 * Assert true with no element
	 */
	public void assertTrueValidationNoElement(WebElement ele) {
		boolean value=!ele.isDisplayed();
		Assert.assertTrue(value);
		System.out.println("Assertion passed");
	}
	/*
	 * Assert false method
	 */
	public void assertFalseValidation(WebElement ele) {
		boolean value=ele.isDisplayed();
		Assert.assertFalse(value);
		System.out.println("Assertion failed");
	}


}
