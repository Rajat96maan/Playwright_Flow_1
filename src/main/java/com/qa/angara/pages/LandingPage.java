package com.qa.angara.pages;

import com.microsoft.playwright.Page;

public class LandingPage {
	
	private Page page;
	private String pageHeading = ".container .mb8:has-text(\"Personalized Name Necklaces\")";
	private String Image1 = ".d-flex .product-card .image img";
	private String Image2 = ".d-flex .product-card .image img>>nth=1";
	private String Image3 = ".d-flex .product-card .image img";
	private String shopButton = "a.shop-button>>nth=1";

	
	public LandingPage(Page page) {
		// TODO Auto-generated constructor stub
		this.page=page;
	}
	
	public String getURL() {
		String landingUrl = page.url();
		System.out.println(landingUrl);
		return landingUrl;
	}
	
	public String getTitle() {
		String title = page.title();
		System.out.println(title);
		return title;
	}
	
	public String getPageHeading() {
		String landingPageHeader = page.textContent(pageHeading);
		System.out.println(landingPageHeader);
		return landingPageHeader;
	}
	
	public String getDiamondNNImages() {
		String imgSrc1 = page.locator(Image1).first().getAttribute("src");
		return imgSrc1;	
	}
	public String getClassicNNImages() {
		String imgSrc2 = page.locator(Image2).getAttribute("src");
		return imgSrc2;	
	}
	public String getPaperChainNNImages() {
		String imgSrc3 = page.locator(Image3).last().getAttribute("src");
		return imgSrc3;	
	}
	public ProductPage navToProductPage() throws InterruptedException
	{
		page.waitForLoadState();
		page.click(shopButton);
		return new ProductPage(page);
	}
	
}
