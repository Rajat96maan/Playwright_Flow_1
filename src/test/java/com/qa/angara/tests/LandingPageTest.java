package com.qa.angara.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.angara.base.BaseTest;
import com.qa.angara.constants.AppConstants;

public class LandingPageTest extends BaseTest {

	@Test(priority=0)
	public void landingPageNavTest() throws InterruptedException {
		landingPage = homePage.navToLandingPage();
		Thread.sleep(1000);
		String LPTitle = landingPage.getTitle();
		System.out.println("Title of Landing Page is: "+ LPTitle);
		Assert.assertEquals(LPTitle, AppConstants.LANDING_PAGE_TITLE);
	}
	
	@Test(priority=1)
	public void landingPageUrlTest()
	{
		String url = landingPage.getURL();
		Assert.assertEquals(url, "https://staging.angara.com/l/custom-name-necklaces");
	}
	
	@Test(priority=2)
	public void landingPageHeadingTest() {
		String LPHeading = landingPage.getPageHeading();
		Assert.assertEquals(LPHeading, "Personalized Name Necklaces");
	}
	@Test(priority=3)
	public void diamondNameNecklaceImageTest() {
		String LPImage1 = landingPage.getDiamondNNImages();
		Assert.assertEquals(LPImage1, "https://assets.angara.com/assets/nameplate/landing-page/diamond-main.jpg");
	}
	@Test(priority=4)
	public void classicNameNecklaceImageTest() {
		String LPImage2 = landingPage.getClassicNNImages();
		Assert.assertEquals(LPImage2, "https://assets.angara.com/assets/nameplate/landing-page/plain-main.jpg");
	}
	@Test(priority=5)
	public void paperChainNameNecklaceImageTest() {
		String LPImage3 = landingPage.getPaperChainNNImages();
		Assert.assertEquals(LPImage3, "https://assets.angara.com/assets/nameplate/landing-page/paper_clip_chain.jpg");
	}
}
