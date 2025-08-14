package com.selenium_assignment.SeleniumAssignment.Pages;

import org.openqa.selenium.By;

public class AmazonPayPage extends HomePage {

	private By amazonPayBalance = By.xpath("//span[@class='currency-green']");

	public double getAmazonPayBalance() {
		String balance = find(amazonPayBalance).getText().replace("₹", "").trim();
		double convertedBalance = Double.parseDouble(balance);
		return convertedBalance;
	}

}
