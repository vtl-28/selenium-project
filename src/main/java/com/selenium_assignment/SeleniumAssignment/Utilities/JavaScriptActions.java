package com.selenium_assignment.SeleniumAssignment.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptActions extends Utility {

	public static void scrollToElementJS(By locator) {
		WebElement element = driver.findElement(locator);
		String jsScript = "arguments[0].scrollIntoView();";
		((JavascriptExecutor) driver).executeScript(jsScript, element);
	}

	public static void scrollToElementJSWithOffset(By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("const yOffset = -200;"
				+ "const y = arguments[0].getBoundingClientRect().top + window.pageYOffset + yOffset;"
				+ "window.scrollTo({top: y, behavior: 'smooth'});", element);
	}
}
