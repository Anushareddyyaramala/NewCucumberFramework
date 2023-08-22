package steps;

import basePackage.BaseClass;
import genericUtils.ExcelUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.HomePage;
import objectRepository.ProductPage;

public class ProductVerification extends BaseClass {

	@Given("User Navigates to the homepage using Url")
	public void user_navigates_to_the_homepage_using() {
		String Url=ExcelUtility.getdata(0, 1);
		System.out.println(Url);
		webUtils.getUrl(Url);
		webUtils.maximiseWindow();
				
	}

	@When("User enters the {string} in searchbar")
	public void user_enters_the_in_searchbar(String product) {
		homePage=new HomePage(driver);
		homePage.handleNotification();
		homePage.EnterDataTosearchbar(product);
	}

	@When("User selects the required product")
	public void user_selects_the_required_product() {
		homePage.selectWatch();
	    
	}

	@Then("verify the zoomed product is visible when mousehover on it")
	public void verify_the_zoomed_product_is_visible_when_mousehover_on_it() {
		ProductPage productpage=new ProductPage(driver);
		productpage.imageVerification();
		
	}
	
	

}
