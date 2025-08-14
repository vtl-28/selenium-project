package com.selenium_assignment.SeleniumAssignment.BaseFiles.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium_assignment.SeleniumAssignment.BaseFiles.BaseTest;
import com.selenium_assignment.SeleniumAssignment.Pages.NavbarElements.SearchInputBox;

public class SearchInputTest extends BaseTest {
	public Logger logger = LogManager.getLogger(SearchInputTest.class);

	@Test
	@Parameters("expectedProductFound")
	public void testVerifySearchFunctionality(String expectedProductFound) {
		SearchInputBox searchPage = homePage.goToSearchInput();
		logger.info("Search input box retrieved");

		searchPage.setSearchInputBox("Lenovo");
		logger.info("Enter item in search box");

		searchPage.searchProduct();
		logger.info("Search item");

		String actualProductFound = searchPage.getFoundProducts();
		logger.info("actual and expected item found");

		Assert.assertEquals(actualProductFound, expectedProductFound);

	}

}
