package com.selenium_assignment.SeleniumAssignment.BaseFiles.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium_assignment.SeleniumAssignment.BaseFiles.BaseTest;
import com.selenium_assignment.SeleniumAssignment.Pages.SignInPage;

public class UnknownUserEmailTest extends BaseTest {
	public Logger logger = LogManager.getLogger(UnknownUserEmailTest.class);

	@Test
	@Parameters("unknowUserEmail")
	public void testUnknownUserEmail(String unknowUserEmail) {
		SignInPage signInPage = homePage.goToSignIn();
		logger.info("Sign In page retrieved");

		signInPage.focusInputBox();
		logger.info("set focus on the input box");

		signInPage.fillInputBox(unknowUserEmail);
		logger.info("Enter email in input box");

		signInPage.signIn();
		logger.info("Click sign in button");

		String actualInfoText = signInPage.getInfoTextConfirmingUnknownUser();
		String expectInfoText = "Looks like you are new to Amazon";

		Assert.assertEquals(actualInfoText, expectInfoText);

	}

}
