package com.selenium_assignment.SeleniumAssignment.Utilities;

import org.openqa.selenium.WebDriver;

import com.selenium_assignment.SeleniumAssignment.Base.BasePage;

public class Utility {
	public static WebDriver driver;

	public static void setUtility() {
		driver = BasePage.driver;
	}
}
