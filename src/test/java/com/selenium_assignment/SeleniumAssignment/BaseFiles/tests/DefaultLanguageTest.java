package com.selenium_assignment.SeleniumAssignment.BaseFiles.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium_assignment.SeleniumAssignment.BaseFiles.BaseTest;
import com.selenium_assignment.SeleniumAssignment.Pages.DefaultLanguagePage;

public class DefaultLanguageTest extends BaseTest {
	public Logger logger = LogManager.getLogger(DefaultLanguageTest.class);

	@Test
	@Parameters("expectedDefaultLanguage")
	public void testVerifyDefaultLanguage(String expectedDefaultLanguage) {
		DefaultLanguagePage defaultLanguage = homePage.goToDefaultLanguage();
		logger.info("Language page retrieved");

		String actualDefaultLanguage = defaultLanguage.getDefaultLanguageText();
		logger.info("actual and expected default language found");

		Assert.assertEquals(actualDefaultLanguage.contains("English"), expectedDefaultLanguage.contains("English"));
	}
}
