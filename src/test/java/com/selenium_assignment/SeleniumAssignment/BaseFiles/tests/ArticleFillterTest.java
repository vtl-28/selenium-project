package com.selenium_assignment.SeleniumAssignment.BaseFiles.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium_assignment.SeleniumAssignment.BaseFiles.BaseTest;
import com.selenium_assignment.SeleniumAssignment.Pages.PressReleasePage;

public class ArticleFillterTest extends BaseTest {
	public Logger logger = LogManager.getLogger(ArticleFillterTest.class);

	@Test
	@Parameters("expectedArticleYear")
	public void testFilterArticlesByYear(String expectedArticleYear) {
		PressReleasePage releasePage = homePage.goToPressReleasePage();
		logger.info("Press release page retrieved");

		releasePage.clickYearRadioButton();
		logger.info("Year radio button clicked to filter according to year");

		String actualArticleYear = releasePage.getYearOfArticles2022();
		logger.info("Actual: " + actualArticleYear);

		logger.info("Expected: " + expectedArticleYear);

		Assert.assertEquals(actualArticleYear, expectedArticleYear);
	}
}
