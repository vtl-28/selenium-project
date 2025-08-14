package com.selenium_assignment.SeleniumAssignment.Pages;

import static com.selenium_assignment.SeleniumAssignment.Utilities.WaitActions.explicitWaitUntilVisible;

import org.openqa.selenium.By;

public class BestSellersPage extends HomePage {

	private By bestSellersHeader = By.xpath("//h1[@id='zg_banner_text']");

	public String getBestSellersHeader() {
		explicitWaitUntilVisible(2, bestSellersHeader);
		String headerText = find(bestSellersHeader).getText().replace("\"", "").trim();
		return headerText;
	}
}
