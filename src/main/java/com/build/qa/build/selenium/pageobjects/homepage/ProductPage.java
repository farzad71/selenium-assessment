package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import com.build.qa.build.selenium.pageobjects.BasePage;

public class ProductPage extends BasePage {
	
	private By productPageWrapper;
	
	@FindBy(xpath =  "//span[conatains(text(),'Part #M6702BN')]")
	public WebElement assert_productID;
	
	@FindBy(xpath = "//span[@itemprop = 'productID']")
	public WebElement product_id;
	
	@FindBy(xpath = "//div[@id='sku7289400']//p[@class='button js-modal-operating'][normalize-space()='Add to Cart']")
	public WebElement add_Product_ID;
	
	@FindBy(xpath = "//button[@class='button mainly jq-quick-view-add-to-cart']")
	public WebElement popup_AddToCartButton;

	public ProductPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		productPageWrapper = By.cssSelector("#wrapper.productdetail-new");
	}
	
	public boolean onProductPage() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(productPageWrapper)) != null;
	}
	
	public String  getText () {
		return driver.findElement((By) product_id).getText();
	}
	
	
	
	
}
