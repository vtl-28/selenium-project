package com.selenium_assignment.SeleniumAssignment.BaseFiles.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium_assignment.SeleniumAssignment.BaseFiles.BaseTest;
import com.selenium_assignment.SeleniumAssignment.Pages.AffiliatePage;
import com.selenium_assignment.SeleniumAssignment.Pages.CustomerSupportPage;

public class TestSendEmailToCustomerSupport extends BaseTest {

	public Logger logger = LogManager.getLogger(TestSendEmailToCustomerSupport.class);

	@Test
	public void testFillInFormBeforeSendingEmail() {
		AffiliatePage affiliatePage = homePage.goToAffiliatePage();
		logger.info("affiliate page retrieved");

		CustomerSupportPage customerSupport = affiliatePage.goToCustomerSupportPage();
		logger.info("customer support  page retrieved");

		customerSupport.submitForm();
		logger.info("submit form without filling it in");

		String actualNameRequireErrorText = customerSupport.getNameRequiredErrorText();
		String actualEmailRequireErrorText = customerSupport.getEmailRequiredErrorText();
		String actualSubjectRequireErrorText = customerSupport.getSubjectRequiredErrorText();
		String actualCommentsRequireErrorText = customerSupport.getCommentsRequiredErrorText();

		String expectedNameRequireErrorText = "This field is required";
		String expectedEmailRequireErrorText = "This field is required";
		String expectedSubjectRequireErrorText = "This field is required";
		String expectedCommentsRequireErrorText = "This field is required";

		Assert.assertEquals(actualNameRequireErrorText, expectedNameRequireErrorText);
		Assert.assertEquals(actualEmailRequireErrorText, expectedEmailRequireErrorText);
		Assert.assertEquals(actualSubjectRequireErrorText, expectedSubjectRequireErrorText);
		Assert.assertEquals(actualCommentsRequireErrorText, expectedCommentsRequireErrorText);

	}
}
