package com.selenium_assignment.SeleniumAssignment.Utilities;

import org.openqa.selenium.By;

import com.selenium_assignment.SeleniumAssignment.Pages.HomePage;

public class GetElementTextActions extends HomePage {

	public static String getElementText(By locator) {
		return find(locator).getText().replace("\"", "").trim();
	}

}
