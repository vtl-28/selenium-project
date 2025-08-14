package com.selenium_assignment.SeleniumAssignment.Pages;

import org.openqa.selenium.By;

public class CartPage extends HomePage {
	private By signInButton = By.xpath("//span[contains(text(),'Sign in to your account')]");
	private By signUpButton = By.xpath("//span[contains(text(),'Sign up now')]");

	public String getSignInButtonText() {
		String signInText = find(signInButton).getText().replace("\"", "").trim();
		return signInText;
	}

	public String getSignUpButtonText() {
		String signUpText = find(signUpButton).getText().replace("\"", "").trim();
		return signUpText;
	}

}
