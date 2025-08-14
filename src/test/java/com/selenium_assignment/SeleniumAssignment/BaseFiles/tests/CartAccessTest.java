package com.selenium_assignment.SeleniumAssignment.BaseFiles.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium_assignment.SeleniumAssignment.BaseFiles.BaseTest;
import com.selenium_assignment.SeleniumAssignment.Pages.CartPage;

public class CartAccessTest extends BaseTest {

	public Logger logger = LogManager.getLogger(CartAccessTest.class);

	@Test
	@Parameters({"expectedSignInText", "expectedSignUpText"})
	public void testCartAccess(String expectedSignInText, String expectedSignUpText) {
		CartPage cart = homePage.goToCart();
		logger.info("Cart page retrieved");

		String actualSignInText = cart.getSignInButtonText();
		String actualSignUpText = cart.getSignUpButtonText();
		
		logger.info("Actual sign in text: " + actualSignInText);
		logger.info("Actual sign up text: " + actualSignUpText);
		
		logger.info("Expected sign in text: " + expectedSignInText);
		logger.info("Expected sign up text: " + expectedSignUpText);

		Assert.assertEquals(actualSignInText, expectedSignInText);
		Assert.assertEquals(actualSignUpText, expectedSignUpText);

	}
}
