package com.selenium_assignment.SeleniumAssignment.Pages;

import org.openqa.selenium.By;
import static com.selenium_assignment.SeleniumAssignment.Utilities.GetElementTextActions.getElementText;

public class DefaultLanguagePage extends HomePage {
	private By defaultLanguage = By
			.xpath("//div[@id='nav-flyout-icp']//span[contains(@dir,'ltr')][normalize-space()='English']");

	public String getDefaultLanguageText() {
		String languageText = getElementText(defaultLanguage);
		return languageText;
	}
}
