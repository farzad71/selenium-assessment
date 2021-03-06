package com.build.qa.build.selenium.pageobjects.homepage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import com.build.qa.build.selenium.pageobjects.BasePage;

public class HomePage extends BasePage {
	
	private By homePageWrapper;
	
	@FindBy(xpath = "(//input[@name ='search'])[1]")
	public WebElement search_Product;
	
	@FindBy(xpath =  "//a[@class='fg-icon-search']")
	public WebElement search_button;
	
	@FindBy(xpath = "")
	public WebElement page_title;
	
	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		homePageWrapper = By.cssSelector("#wrapper.homepage");
	}
	
	public boolean onHomePage() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(homePageWrapper)) != null;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
		
	}
	
	
}
