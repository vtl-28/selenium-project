package com.selenium_assignment.SeleniumAssignment.BaseFiles.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium_assignment.SeleniumAssignment.BaseFiles.BaseTest;
import com.selenium_assignment.SeleniumAssignment.Pages.AmazonPayPage;

public class CheckAmazonPayBalance extends BaseTest {
	public Logger logger = LogManager.getLogger(CheckAmazonPayBalance.class);

	@Test
	public void testVerifyAmazonPayBalance() {
		AmazonPayPage amazonPay = homePage.goToPayPage();
		logger.info("Amazon pay page retrieved");

		double availableBalance = amazonPay.getAmazonPayBalance();
		logger.info("Amazon pay available balance retrieved");
		logger.info("amazon pay balance: " + availableBalance);

		boolean IsAvailable = availableBalance >= 0.00;
		Assert.assertTrue(IsAvailable);
	}

}
