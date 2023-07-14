package com.qa.angara.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.angara.base.BaseTest;

public class CartPageTest extends BaseTest {

	@Test(priority=0)
	public void cartPageNavTest() throws InterruptedException{
		landingPage = homePage.navToLandingPage();
		Thread.sleep(3000);
		productPage = landingPage.navToProductPage();
		Thread.sleep(3000);
		cartPage = productPage.navToCartPage();
		Thread.sleep(3000);
		String title = cartPage.getCartPageTitle();
		Assert.assertEquals(title, "Angara Secure Shopping Cart");
		
	}
	@Test(priority=1)
	public void cartPageURLTest()
	{
		String url = cartPage.getCartPageURL();
		Assert.assertEquals(url, "https://frontend.v2.qa.angara.com/checkout/cart");
	}
	@Test(priority=2)
	public void cartPageHeadingTest()
	{
		String heading = cartPage.getCartPageHeading();
		Assert.assertEquals(heading, "Secure Shopping Cart");
	}
	@Test(priority=3)
	public void cartPageCouponTest()
	{
		Boolean heading = cartPage.getCoupanCodeOfCart();
		Assert.assertTrue(heading);
	}
	
	@Test(priority=4)
	public void checkoutButtontest()
	{
		Boolean button = cartPage.checkoutButtonEnability();
		Assert.assertTrue(button);
	}
	@Test(priority=5)
	public void checkoutPageUrlTest()
	{
		String checkoutUrl = cartPage.navToCheckoutPage();
		Assert.assertEquals(checkoutUrl, "https://frontend.v2.qa.angara.com/onestepcheckout");
	}
	
	@Test(priority=6)
	public void shippingAddressTest()
	{
		cartPage.shippingDetails();
		System.out.println("Details submitted successfully");
	}
	
	@Test(priority=7)
	public void paymentMethodTest()
	{
		cartPage.navToSecondStepOfCheckout();
		System.out.println("*****************");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
