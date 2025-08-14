package com.selenium_assignment.SeleniumAssignment.Pages;

import static com.selenium_assignment.SeleniumAssignment.Utilities.JavaScriptActions.scrollToElementJS;

import org.openqa.selenium.By;

public class AffiliatePage extends HomePage {
	private By customerSupport = By.xpath("//a[normalize-space()='Contact us']");

	public CustomerSupportPage goToCustomerSupportPage() {
		scrollToElementJS(customerSupport);
		click(customerSupport);

		return new CustomerSupportPage();
	}
}
