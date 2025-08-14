package com.selenium_assignment.SeleniumAssignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium_assignment.SeleniumAssignment.Utilities.JavaScriptActions.scrollToElementJSWithOffset;
import static com.selenium_assignment.SeleniumAssignment.Utilities.GetElementTextActions.getElementText;

import java.time.Duration;

public class PressReleasePage extends HomePage {
	private By readMore = By.xpath("//li[1]//div[1]//div[1]//div[2]//div[1]//a[1]//span[1]");
	private By storyHeadline = By.xpath("//h1[@class='PressReleasePage-headline']");
	private By radioButtonYear = By.xpath("//input[@value='2022']");
	private By articleYear = By.xpath("//div[@class='PromoCardSearchResults-date']");
	private By articleYear2022 = By.xpath("//div[text()='14 December 2022']");

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clickReadMore() {
		scrollToElementJSWithOffset(readMore);
		wait.until(ExpectedConditions.elementToBeClickable(readMore));
		click(readMore);
	}

	public String getStoryHeadlineText() {
		String storyHeadlineText = getElementText(storyHeadline);
		return storyHeadlineText;
	}

	public void clickYearRadioButton() {
		scrollToElementJSWithOffset(radioButtonYear);
		wait.until(ExpectedConditions.elementToBeClickable(radioButtonYear));
		click(radioButtonYear);
	}

	public String getYearOfRadioButton() {
		String year = getElementText(radioButtonYear);
		return year;
	}

	public String getYearOfArticles() {
		String year = getElementText(articleYear);
		return year;
	}

	public String getYearOfArticles2022() {
		String year = getElementText(articleYear2022);
		return year;
	}
}
