package com.qa.angara.pages;

import java.util.List;
import java.util.stream.Collectors;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.impl.Stream;
import com.microsoft.playwright.options.LoadState;
import com.qa.angara.factory.PlaywrightFactory;

public class HomePage extends PlaywrightFactory{
	
	private Page page;
	private Browser browser;
	
	private String companyLogo=".angara-logo";
	private String selectCountry=".ttu";
	//private String selectUSCountry=".country-us >>nth=2";
	private String GNBNecklace=".navigation a:has-text('Necklaces')";
	private String gnbNameNecklace = ".catalogue-banners span.image-label.s2 span:has-text('Name Necklaces')";
	private String necklaceTab = ".tab-title:has-text('Necklaces')";
	private String nameNecklace = "//img[@alt='Name Necklaces']";
	private String ringsGNB = ".nav.navigation a>>nth=0";
	private String ringsGNBLinks = ".sub-navigation a";
	private String productPageFirstLink = ".p-re .product-image>>nth=0";
	

	public HomePage(Page page)
	{
		this.page=page;
	}
	
	public String getHomePageTitle() {
		return page.title();	
	}
	
	public boolean getLogo() {
		boolean compLogo=page.locator(companyLogo).first().isVisible();
		return compLogo;
	}
	
	public String getSelectedCountryName() {
		page.waitForLoadState();
		String countryName = page.locator(selectCountry).textContent();
		System.out.println(countryName);
		return countryName;
	}
	
	public Boolean GNBHeaders() {
		ElementHandle gnbHeader = page.querySelector(GNBNecklace);
		gnbHeader.hover();
		page.waitForTimeout(1000);  // Adjust the timeout value as needed
		ElementHandle desiredElement = page.querySelector(gnbNameNecklace);
		Boolean bannerNecklace = desiredElement.isVisible();
		return bannerNecklace;
	}
	
	public LandingPage navToLandingPage() throws InterruptedException
	{
		page.locator(necklaceTab).first().click();
		page.waitForLoadState();
		page.click(nameNecklace);
		page.waitForLoadState();
		return new LandingPage(page);
	}
	

}
