package com.selenium_assignment.SeleniumAssignment.BaseFiles.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium_assignment.SeleniumAssignment.BaseFiles.BaseTest;
import com.selenium_assignment.SeleniumAssignment.Pages.SignInPage;

public class UnknownUserNumberTest extends BaseTest {
	public Logger logger = LogManager.getLogger(UnknownUserNumberTest.class);

	@Test
	@Parameters("unknowUserNumber")
	public void testUnknownUserNumber(String unknowUserNumber) {
		SignInPage signInPage = homePage.goToSignIn();
		logger.info("Sign In page retrieved");

		signInPage.focusInputBox();
		logger.info("set focus on the input box");

		signInPage.fillInputBox(unknowUserNumber);
		logger.info("Enter number in input box");

		signInPage.signIn();
		logger.info("Click sign in button");

		String actualErrorMessageText = signInPage.getErrorMessageText();
		String expectedErrorMessageText = "Invalid mobile number";

		Assert.assertEquals(actualErrorMessageText, expectedErrorMessageText);

	}
}
