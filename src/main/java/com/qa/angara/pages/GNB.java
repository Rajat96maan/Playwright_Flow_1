package com.qa.angara.pages;

import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;


public class GNB 
{

	public static void main(String[] args) throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		Browser browser = playwright.chromium().launch(lp);
		//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
		Page page = browser.newPage();
		String baseUrl = "https://www.angara.com";
		page.navigate(baseUrl);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		Locator gnbHeaders = page.locator(".nav.navigation a>>nth=0");
		gnbHeaders.hover();
		gnbHeaders.last().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(3000));
		Locator gnbRingsLinks = page.locator(".sub-nav-options ul li a");
		 IntStream.range(0, gnbRingsLinks.count()).forEach(i -> 
		 {
			String link = gnbRingsLinks.nth(i).getAttribute("href");
			String url = baseUrl + link;
			page.navigate(url);
			page.setDefaultTimeout(1200000);
			page.waitForLoadState(LoadState.NETWORKIDLE);
			if(link.startsWith("/create-with-angara"))
			{
				String prdtName = page.locator(".card-title .lc2 >>nth=0").textContent();
				System.out.println("Product Name is : " +prdtName);
				page.waitForLoadState(LoadState.NETWORKIDLE);
			}
			else 
			{
			String productName = page.locator(".p-re .product-name>>nth=0").textContent();
			System.out.println("Product Name is : " + productName);
			page.waitForLoadState(LoadState.NETWORKIDLE);
			}
			Locator gnbHeaders1 = page.locator(".nav.navigation a>>nth=0");
			gnbHeaders1.hover();
	
		});
		browser.close();	
	}
}







