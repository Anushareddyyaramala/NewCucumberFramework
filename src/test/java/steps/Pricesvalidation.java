package steps;

import basePackage.BaseClass;
import io.cucumber.java.en.Then;
import objectRepository.ProductPage;

public class Pricesvalidation extends BaseClass {

	
	@Then("verify the price of the product with ActualCost")
	public void verify_the_price_of_the_product_with_actual_cost() {
		productpage=new ProductPage (driver);
		productpage.productpricevalidation();
	}
}
