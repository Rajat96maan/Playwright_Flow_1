package com.qa.angara.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.angara.base.BaseTest;

public class ProductPageTest extends BaseTest {

	@Test(priority=0)
	public void productPageNavTest() throws InterruptedException{
		landingPage = homePage.navToLandingPage();
		Thread.sleep(3000);
		productPage = landingPage.navToProductPage();
		Thread.sleep(3000);
		String imgTest = productPage.getProductImage();
		Assert.assertEquals(imgTest, "MainImage__Image-kKeSQc ampUz");	
	}
	
	@Test(priority=1)
	public void productPageCartButtonTest() 
	{
		Boolean cartButton = productPage.getAddCartButton();
		Assert.assertTrue(cartButton);
	}
	
	@Test(priority=2)
	public void productPageTitleTest() 
	{
		String PPURL = productPage.getProductPageTitle();
		System.out.println("Title of Product Page is: "+ PPURL);
		Assert.assertEquals(PPURL, "Personalized Name Necklace in 10K Yellow Gold");
	}
	
	@Test(priority=3)
	public void productPageUrlTest()
	{
		String productUrl = productPage.getProductPageURL();
		System.out.println(productUrl);
		Assert.assertEquals(productUrl, "https://frontend.v2.qa.angara.com/p/personalized-name-necklace-np0101");
	}
	@Test(priority=4)
	public void productPageCustomization()
	{
		Boolean cartButton = productPage.customizeProduct();
		Assert.assertTrue(cartButton);	
	}
}
