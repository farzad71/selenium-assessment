package com.build.qa.build.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;
import com.build.qa.build.selenium.pageobjects.homepage.ProductPage;

public class FergTest extends BaseFramework {

	/**
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 */
	@Test
	public void navigateToHomePage() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		softly.assertThat(homePage.onHomePage())
		.as("The website should load up with the Build.com desktop theme.")
		.isTrue();
		softly.assertThat(homePage.getPageTitle()).isEqualTo("Plumbing Supplies, HVAC Parts, Pipe, Valves & Fittings – Ferguson");
	}

	/**
	 * Search for the Moen m6702bn from the search bar
	 * @assert: That the product page we land on is what is expected by checking the product brand and product id
	 * @difficulty Easy
	 */
	@Test
	public void searchForProductLandsOnCorrectProduct() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		homePage.search_Product.sendKeys("m6702bn");
		homePage.search_button.click();
		ProductPage productPage = new ProductPage(driver, wait);
		softly.assertThat(productPage.onProductPage())
		.as("Product Page")
		.isTrue();
		System.out.println(productPage.getText());
		softly.assertThat(productPage.getText()).isEqualTo("Part #M6702BN");
	
	}

	/**
	 * Go to the Bathroom Sinks category directly
	 * (https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3)
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
	@Test
	public void addProductToCartFromCategoryDrop() {
		
		driver.get("https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3");
		WebElement category=driver.findElement(By.xpath("//div[@id='sku7289400']//p[@class='button js-modal-operating'][normalize-space()='Add to Cart']"));
		String expectedValue=category.getText();
		category.click();
		driver.findElement(By.xpath("//button[@class='button mainly jq-quick-view-add-to-cart']")).click();
		String actualValue= driver.findElement(By.xpath("//button[@class='button mainly jq-quick-view-add-to-cart']")).getText();
		//softly.assertThat("Your message", actualValue.contains(expectedValue));
		
		
	}

	/**
	 * Add two different finishes of a product (such as Moen m6702bn) to cart,
	 * change the quantity of each finish on the cart page
	 * @assert that the product and cart total update as expected when the quantity is changed
	 * @difficulty Medium-Hard
	 */
	@Test
	public void addMultipleCartItemsAndChangeQuantity() {
		// TODO: Implement this test
	}

	/**
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Brand=Brizo
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() {
		// TODO: Implement this test
	}
}
