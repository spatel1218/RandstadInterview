package com.java.test;

import org.testng.annotations.Test;

import com.java.pages.LoginPage;
import com.java.pages.SearchPage;
import com.java.pages.SignUpPage;

import utils.Utils;

public class Testcases extends Utils{
	
	@Test(priority=1)
	public void loginErrorMessages() throws Exception {
		
		invokebrowser();
		new LoginPage().clickLoginlink();
		new LoginPage().loginErrorMessages();
		
	}
	
	@Test(priority=2)
	public void login() throws Exception {
		
		invokebrowser();
		new LoginPage().clickLoginlink();
		new LoginPage().logintoapplocation();
		
	}
	
	@Test(priority=3)
	public void SignUpErrorMessages() throws Exception {
		
		invokebrowser();
		new LoginPage().clickCreateAccountButton();
		new SignUpPage().verifyErrorMessages();
		
	}
	
	@Test(priority=4)
	public void createAccount() throws Exception {
		
		invokebrowser();
		new LoginPage().clickCreateAccountButton();
		new SignUpPage().createAccount();
		
	}

	
	@Test(priority=5)
	public void SearchforProduct() throws Exception {
		
		invokebrowser();
		new SearchPage().searchProduct("Mobiles");
		new SearchPage().addToCart();
		
	}
	
	@Test(priority=6)
	public void checkoutProduct() throws Exception {
		
		invokebrowser();
		new SearchPage().searchProduct("Mobiles");
		new SearchPage().addToCart();
		new SearchPage().clickCartIcon();
		new SearchPage().checkout();
		new LoginPage().logintoapplocation();
	}
	
	
}
