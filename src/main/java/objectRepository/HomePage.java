package objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;
import genericUtils.WebDriverUtils;

public class HomePage extends BaseClass {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * webElements
	 */

	@FindBy(css = "#wzrk-confirm")
	public WebElement notification;
	@FindBy(css = "#search-text-input")
	public WebElement searchbar;
	@FindBy(xpath = "//div[contains(@id,'ProductModule')][1]")
	public WebElement watch;
	

	public void handleNotification() {
		webUtils.clickElement(notification);
	}

	public void EnterDataTosearchbar(String value) {
		webUtils.sendDatatoElement(searchbar, value);
		searchbar.sendKeys(Keys.ENTER);
	}

	public void selectWatch() {
		//webUtils.acceptAlert();
		webUtils.implicityWait();
		webUtils.clickElement(watch);
	}

	
}