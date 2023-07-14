package com.qa.angara.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.angara.factory.PlaywrightFactory;
import com.qa.angara.pages.CartPage;
import com.qa.angara.pages.HomePage;
import com.qa.angara.pages.LandingPage;
//import com.qa.opencart.pages.LoginPage;
//import com.qa.opencart.pages.ProductPage;
import com.qa.angara.pages.ProductPage;

public class BaseTest {
	PlaywrightFactory pf;
	Page page;
	protected HomePage homePage;
	protected LandingPage landingPage;
	protected ProductPage productPage;
	protected CartPage cartPage;
	protected Properties prop;
	
	//@Parameters({"browser"})
	@BeforeTest
	public void setup() //enter String browserName in browser to run via testNG file
	{
		
		pf = new PlaywrightFactory();
		prop = pf.init_prop();
		
//		if(browserName!=null)
//		{
//			prop.setProperty("browser", browserName);
//		}
		
		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
		
	}
	
//	@AfterTest
//	public void tearDown()
//	{
//		page.context().browser().close();
//	}
}
