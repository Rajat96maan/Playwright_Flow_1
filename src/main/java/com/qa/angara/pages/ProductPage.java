package com.qa.angara.pages;

import com.microsoft.playwright.Page;

public class ProductPage {
	
	private Page page;
	
	private String productImage = ".media-inner .hide-small img";
	
	private String addToCartButton = ".cart-btn-wrap .add-to-cart";
	private String textField = "//input[@placeholder='Enter a name or text']";
	private String selectFont = "#Damion";
	private String selectMetalTab = ".accordion-title img>>nth=1";
	private String selectMetal = "//div[@id='14K Rose Gold']";
	private String selectThickness = "#Exclusive";
	private String selectChainTab = ".accordion-title>>nth=2";
	private String selectChainStyle = "(//div[@id='Exclusive'])[2]";
	private String selectChainLength = "#chain_length22";
	private String selectCharmsTab = ".accordion-title>>nth=3";
	private String selectCharm = "#Hamsa";
	
	
	
	public ProductPage(Page page)
	{
		this.page=page;
	}
	
	public String getProductPageTitle() 
	{
		return page.title();
	}
	
	public String getProductPageURL() 
	{
		return page.url();
	}
	
	public String getProductImage()
	{
		String img = page.locator(productImage).getAttribute("class");
		return img;
	}
	
	public Boolean getAddCartButton()
	{
		Boolean button = page.locator(addToCartButton).isEnabled();
		return button;
	}
	
	public Boolean customizeProduct()
	{
		page.locator(textField).fill("Rajat");
		page.waitForSelector(addToCartButton);
		page.click(selectFont);
		page.waitForSelector(addToCartButton);
		page.click(selectMetalTab);
		page.waitForSelector(addToCartButton);
		page.click(selectMetal);
		page.waitForSelector(addToCartButton);
		page.click(selectThickness);
		page.click(selectChainTab);
		page.waitForSelector(addToCartButton);
		page.click(selectChainStyle);
		page.waitForSelector(addToCartButton);
		page.click(selectChainLength);
		page.click(selectCharmsTab);
		page.waitForSelector(addToCartButton);
		page.click(selectCharm);
		page.waitForSelector(addToCartButton);
		Boolean buttonEnabled = page.locator(addToCartButton).isEnabled();
		return buttonEnabled;	
	}
	
	public CartPage navToCartPage()
	{
		page.click(addToCartButton);
		return new CartPage(page);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
