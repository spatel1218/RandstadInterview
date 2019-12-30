package com.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.Utils;

public class LoginPage extends Utils{
	
	
	@FindBy(xpath="//a[@id='nav-link-accountList']/span[text()='Hello, Sign in']")
	private static WebElement loginlink;

	@FindBy(xpath="//input[@id='ap_email']")
	private static WebElement UserName;

	@FindBy(xpath="//input[@id='continue']")
	private static WebElement ContinueButton;

	@FindBy(xpath="//input[@id='ap_password']")
	private static WebElement Password;

	@FindBy(xpath="//input[@id='signInSubmit']")
	private static WebElement signInSubmit;

	@FindBy(xpath="//a[@id='createAccountSubmit']")
	private static WebElement createAccountButton;

	@FindBy(xpath="//*[@id='auth-error-message-box']")
	private static WebElement LoginErrorMessage;
	
	
	public LoginPage() {
		 PageFactory.initElements(driver, this);
	}
	
	public void clickLoginlink() throws Exception {
		clickWebelement(loginlink, "Login link");
	}
	
	public void logintoapplocation() throws Exception {
		
		elementtobeClickable(UserName);
		sendText(UserName, "mobileautomationb2b@gmail.com");
		clickWebelement(ContinueButton, "Continue");
		
		elementtobeClickable(Password);
		sendText(Password,"Testing@123");
		clickWebelement(signInSubmit, "Sign in");
		Assert.assertEquals(Utils.verifyElement(loginlink), false);
		
	}

	public void clickCreateAccountButton() throws Exception {
		clickWebelement(loginlink,"Login");
		elementtobeClickable(createAccountButton);
		clickWebelement(createAccountButton,"Create Account");
	}
	
	public void loginErrorMessages() throws Exception {
		
		clickWebelement(loginlink, "Login link");
		Utils.elementtobeClickable(UserName);
		sendText(UserName, "6306781234");
		clickWebelement(ContinueButton, "Continue");
		Assert.assertEquals(Utils.verifyElement(LoginErrorMessage), true);
		System.out.println("Error messages are displayed");
	}
}
