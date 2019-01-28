package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class CartPage extends TestBase {

	@FindBy(xpath="//*[@id='header-navigation']/div[2]/div[4]/div/div[2]/a/i")
	WebElement cartLogo;
	
	@FindBy(xpath = "//*[@id='cart']/h1")
	WebElement shoppingCartContent;
	
	
	public CartPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean checkCartLogo(){
		try{
		return cartLogo.isDisplayed();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	
}
