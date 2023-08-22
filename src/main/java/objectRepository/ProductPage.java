package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;
import genericUtils.ExcelUtility;

public class ProductPage extends BaseClass {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.ProductDescriptionPage__content")
	public WebElement zoomedImage;
	@FindBy(css = "#pg-zoom-image")
	public WebElement normalImage;
	@FindBy(xpath = "//span[text()='ADD TO BAG']")
	public WebElement addtocart;
	@FindBy(css = ".DesktopHeader__myBagShow")
	public WebElement cart;
	@FindBy(css = ".CartItemForDesktop__informationTextWithBolder")
	public WebElement ActualCost;

	public void imageVerification() {
		webUtils.windowHandling(driver, 1);
		webUtils.mouseHover(driver, normalImage);
		webUtils.assertTrueValidation(zoomedImage);
		webUtils.implicityWait();
		webUtils.mouseHover(driver, zoomedImage);
		webUtils.assertTrueValidation(normalImage);
	}

	public void productpricevalidation() {
		webUtils.scrollAction(driver);
		webUtils.clickElement(addtocart);
		webUtils.clickElement(cart);
		String data=cart.getText();
		webUtils.assertionEqualswithdata(ExcelUtility.getdata(1, 1), data);

	}
}
