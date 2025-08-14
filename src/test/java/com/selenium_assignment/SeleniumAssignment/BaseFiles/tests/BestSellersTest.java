package com.selenium_assignment.SeleniumAssignment.BaseFiles.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium_assignment.SeleniumAssignment.BaseFiles.BaseTest;
import com.selenium_assignment.SeleniumAssignment.Pages.BestSellersPage;

public class BestSellersTest extends BaseTest {
	public Logger logger = LogManager.getLogger(BestSellersTest.class);

	@Test
	@Parameters("expectedHeaderText")
	public void testBestSellersNavigation(@Optional("Amazon Bestsellers") String expectedHeaderText) {
		BestSellersPage bestSellersPage = homePage.goToBestSellers();
		logger.info("Best sellers page retrieved");

		String actualHeaderText = bestSellersPage.getBestSellersHeader();
		logger.info("Actual and expected header text found");

		Assert.assertEquals(actualHeaderText, expectedHeaderText);
	}

}
