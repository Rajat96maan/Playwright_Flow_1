package com.qa.angara.pages;

import java.util.Properties;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CartPage {

	private Page page;
	protected Properties prop;
	
	private String heading = "div.hlOrWo h1.heading";
	private String coupanCodeField = "#coupon_code";
	private String secureCheckoutButton = ".f-sf3 span.secure_text";
	private String checkoutArea = ".right-section";
	private String firstName = "#shipping-firstName";
	private String lastName = "#shipping-lastName";
	private String streetAddress = "#shipping-streetName";
	private String city = "#shipping-city";
	private String state = "#shipping-state";
	private String paymentButton = "#continue-payment";
	private String zipCode = "#shipping-postalCode";
	private String emailAddress = "#shipping-email";
	private String phoneNo = "#shipping-phone";
	private String cardMethod = "#shipping-phone";
	private String placeOrder = "#submit";
	private String fl = "iframe[title='Secure payment input frame']";
	

	public CartPage(Page page) 
	{
		this.page = page;
	}
	
	public String getCartPageTitle()
	{
		return page.title();
	}
	
	public String getCartPageURL()
	{
		return page.url();
	}
	public String getCartPageHeading()
	{
		return page.locator(heading).textContent();
	}
	public Boolean getCoupanCodeOfCart()
	{
		Boolean coupanText = page.locator(coupanCodeField).first().textContent().isBlank();
		return coupanText;
	}
	public Boolean checkoutButtonEnability()
	{
		Boolean checkoutButton = page.locator(secureCheckoutButton).isEnabled();
		return checkoutButton;
	}
	public String navToCheckoutPage()
	{
		page.click(secureCheckoutButton);
		page.waitForLoadState();
		page.locator(checkoutArea).isVisible();
		return page.url();
	}
	public void shippingDetails()
	{
		page.fill(firstName, "Rajat");
		page.fill(lastName, "Maan");
		page.fill(streetAddress,"1215 Kennedy Road");
		page.fill(city, "Anderson");
		
		page.selectOption(state, "Alaska");
		page.fill(zipCode, "46011");
		page.fill(emailAddress, "rajat.maan@angara.com");
		page.fill(phoneNo, "4567899876");
		
	}
	
	public void navToSecondStepOfCheckout()
	{
		page.click(paymentButton);
		page.waitForSelector(cardMethod);
		
		//Locator lc = page.locator("iframe[title='Secure payment input frame']");
		//FrameLocator loc = page.frameLocator("iframe[title='Secure payment input frame']");
		//FrameLocator loc = FrameLocator.frameLocator("iframe[title='Secure payment input frame']");		
		  page.frameLocator(fl).getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Card")).click();
	      page.frameLocator(fl).getByPlaceholder("1234 1234 1234 1234").click();
	      page.frameLocator(fl).getByPlaceholder("1234 1234 1234 1234").fill("4242 4242 4242 4242");
	      page.frameLocator(fl).getByPlaceholder("1234 1234 1234 1234").press("Tab");
	      page.frameLocator(fl).getByPlaceholder("MM / YY").fill("05 / 256");
	      page.frameLocator(fl).getByPlaceholder("MM / YY").press("Tab");
	      page.frameLocator(fl).getByPlaceholder("CVC").fill("6327");
	      page.click(placeOrder);
	      page.waitForSelector(".container h1").isVisible();

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
