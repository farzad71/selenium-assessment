package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import com.build.qa.build.selenium.pageobjects.BasePage;

public class CartPage extends BasePage{
	
	private By cartPageWrapper;
	public CartPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		cartPageWrapper = By.cssSelector("#wrapper.cart");
	}
	public boolean onCartPage() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(cartPageWrapper)) != null;
	}
}