package com.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.Utils;

public class SearchPage extends Utils{
	
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	private static WebElement SearchTextBox;

	@FindBy(xpath="//input[@type='submit']")
	private static WebElement SearchButton;

	@FindBy(xpath="//*[@class='a-section aok-relative s-image-square-aspect']/*[@class='s-image']")
	private static WebElement FirstProduct;

	@FindBy(xpath="//*[@id='add-to-cart-button']")
	private static WebElement AddToCart;

	@FindBy(xpath="//*[@id='nav-cart-count']")
	private static WebElement CartNumbers;

	@FindBy(xpath="//*[@name='proceedToRetailCheckout']")
	private static WebElement ProcedToCheckout;
	
	
	
	public SearchPage() {
		 PageFactory.initElements(driver, this);
	}
	

	public void searchProduct(String product) throws Exception {
		elementtobeClickable(SearchButton);
		//SearchButton.click();
		sendText(SearchTextBox, product);
		Thread.sleep(2000);
		clickWebelement(SearchButton, "Search");
		clickWebelement(FirstProduct, "First Product");
	}
	
	public void addToCart() throws Exception {
		elementtobeClickable(AddToCart);
		clickWebelement(AddToCart, "Add to Cart");
		Assert.assertEquals(CartNumbers.getText().trim(), "1");
		System.out.println("Product is added to the cart successfully");
	}
	
	public void checkout() throws Exception {
		elementtobeClickable(ProcedToCheckout);
		clickWebelement(ProcedToCheckout, "Cart");
	}
	
	public void clickCartIcon() throws Exception {
		clickWebelement(CartNumbers, "Cart Icon");
	}
}
