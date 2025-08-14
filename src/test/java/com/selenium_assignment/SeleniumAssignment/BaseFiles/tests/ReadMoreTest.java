package com.selenium_assignment.SeleniumAssignment.BaseFiles.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium_assignment.SeleniumAssignment.BaseFiles.BaseTest;
import com.selenium_assignment.SeleniumAssignment.Pages.PressReleasePage;

public class ReadMoreTest extends BaseTest {
	public Logger logger = LogManager.getLogger(ReadMoreTest.class);

	@Test
	@Parameters("expectedStoryHeadlineText")
	public void testCheckReadMoreFunctionality(@Optional("53% surveyed experience sleep-related disorders without a consistent bedtime routine: YouGov and Amazon Alexa Study") 
		String expectedStoryHeadlineText) {
		PressReleasePage pressRelease = homePage.goToPressReleasePage();
		logger.info("Press release page retrieved");

		pressRelease.clickReadMore();
		logger.info("Click article read more button to open the article");

		String actualStoryHeadlineText = pressRelease.getStoryHeadlineText();
		logger.info("actual and expected headline text of article found");

		Assert.assertEquals(actualStoryHeadlineText, expectedStoryHeadlineText);
	}
}
