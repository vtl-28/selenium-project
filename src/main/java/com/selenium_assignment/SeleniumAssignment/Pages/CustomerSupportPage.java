package com.selenium_assignment.SeleniumAssignment.Pages;

import org.openqa.selenium.By;
import static com.selenium_assignment.SeleniumAssignment.Utilities.JavaScriptActions.scrollToElementJS;
import static com.selenium_assignment.SeleniumAssignment.Utilities.GetElementTextActions.getElementText;

public class CustomerSupportPage extends AffiliatePage {
	private By sendEmailButton = By.xpath("//input[@type='submit']");
	private By nameRequired = By.xpath("//span[@for='ac-contact-form-name-input']");
	private By emailRequired = By.xpath("//span[@for='ac-contact-form-email-input']");
	private By subjectRequired = By.xpath("//span[@for='ac-contact-subject-input']");
	private By commentsRequired = By.xpath("//span[@for='ac-contact-form-comments-input']");

	public String getNameRequiredErrorText() {
		String errorText = getElementText(nameRequired);
		return errorText;
	}

	public String getEmailRequiredErrorText() {
		String errorText = getElementText(emailRequired);
		return errorText;
	}

	public String getSubjectRequiredErrorText() {
		String errorText = getElementText(subjectRequired);
		return errorText;
	}

	public String getCommentsRequiredErrorText() {
		String errorText = getElementText(commentsRequired);
		return errorText;
	}

	public void submitForm() {
		scrollToElementJS(sendEmailButton);
		click(sendEmailButton);
		scrollToElementJS(nameRequired);
	}

}
