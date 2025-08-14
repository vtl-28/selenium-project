package com.selenium_assignment.SeleniumAssignment.Pages;

import static com.selenium_assignment.SeleniumAssignment.Utilities.WaitActions.explicitWaitUntilVisible;
import static com.selenium_assignment.SeleniumAssignment.Utilities.GetElementTextActions.getElementText;

import org.openqa.selenium.By;

public class SignInPage extends HomePage {
	private By mobileNumberOrEmailInput = By.xpath("//input[@id='ap_email_login']");
	private By continueButton = By.xpath("//input[@type='submit']");
	private By infoTextConfirmingUnknownUser = By.xpath("//h1[contains(text(),'Amazon')]");
	private By errorMessage = By.xpath("//div[contains(text(),'Invalid mobile number')]");

	public void focusInputBox() {
		click(mobileNumberOrEmailInput);
	}

	public void fillInputBox(String unknowUserEmailOrNumber) {
		set(mobileNumberOrEmailInput, unknowUserEmailOrNumber);
	}

	public void signIn() {
		click(continueButton);
	}

	public String getInfoTextConfirmingUnknownUser() {
		explicitWaitUntilVisible(2, infoTextConfirmingUnknownUser);
		String infoText = find(infoTextConfirmingUnknownUser).getText().replace("\"", "").trim();
		return infoText;
	}

	public String getErrorMessageText() {
		explicitWaitUntilVisible(2, errorMessage);
		String errorText = getElementText(errorMessage);
		return errorText;
	}
}
