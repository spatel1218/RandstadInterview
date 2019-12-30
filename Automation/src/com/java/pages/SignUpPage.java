package com.java.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.Utils;

public class SignUpPage extends Utils{
	
	@FindBy(xpath="//*[@id='ap_customer_name']")
	private static WebElement UserName;

	@FindBy(xpath="//*[@id='ap_email']")
	private static WebElement Email;

	@FindBy(xpath="//*[@id='ap_password']")
	private static WebElement Password;

	@FindBy(xpath="//*[@id='ap_password_check']")
	private static WebElement Confirmpassword;

	@FindBy(xpath="//*[@id='continue']")
	private static WebElement SubmitButton;

	@FindBy(xpath="//*[@id='auth-customerName-missing-alert']")
	private static WebElement UserNameErrorMessage;

	@FindBy(xpath="//*[@id='auth-email-missing-alert']")
	private static WebElement EmailErrorMessage;

	@FindBy(xpath="//*[@id='auth-password-missing-alert']")
	private static WebElement PasswordErrorMessage;
	
	
	
	public SignUpPage() {
		 PageFactory.initElements(driver, this);
	}
	
	public void createAccount() throws Exception {
		
		elementtobeClickable(UserName);
		sendText(UserName,"Tester");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		LocalDateTime now = LocalDateTime.now();  
		
		sendText(Email,"testing"+dtf.format(now)+"@gmail.com");
		sendText(Password,"Testing@123");
		sendText(Confirmpassword,"Testing@123");
		clickWebelement(SubmitButton,"Submit");
	}
	
	public void verifyErrorMessages() throws Exception {
		elementtobeClickable(UserName);
		clickWebelement(SubmitButton,"Submit");
		Assert.assertEquals(Utils.verifyElement(UserNameErrorMessage), true);
		Assert.assertEquals(Utils.verifyElement(EmailErrorMessage), true);
		Assert.assertEquals(Utils.verifyElement(PasswordErrorMessage), true);
	}

}
