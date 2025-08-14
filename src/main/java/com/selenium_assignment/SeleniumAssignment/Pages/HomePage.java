package com.selenium_assignment.SeleniumAssignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.selenium_assignment.SeleniumAssignment.Base.BasePage;
import com.selenium_assignment.SeleniumAssignment.Pages.NavbarElements.SearchInputBox;

import static com.selenium_assignment.SeleniumAssignment.Utilities.JavaScriptActions.scrollToElementJS;
import static com.selenium_assignment.SeleniumAssignment.Utilities.JavaScriptActions.scrollToElementJSWithOffset;

public class HomePage extends BasePage {

	private By searchInput = By.xpath("//input[@id='twotabsearchtextbox']");
	private By signInAccountsAndLists = By.xpath("//div[@id='nav-link-accountList']//a[1]");
	private By signInButton = By.xpath("//span[contains(@class,'nav-action-inner')]");
	private By bestSellers = By.xpath("//a[normalize-space()='Bestsellers']");
	private By defaultLanguage = By.xpath("//span[@class='icp-nav-link-inner']");
	private By cart = By.xpath("//a[@id='nav-cart']");
	private By affiliate = By.xpath("//a[normalize-space()='Become an Affiliate']");
	private By pressRelease = By.xpath("//a[normalize-space()='Press Releases']");
	private By amazonPay = By.xpath("//a[text()='Amazon Pay']");

	Actions act = new Actions(driver);

	public SearchInputBox goToSearchInput() {
		scrollToElementJS(searchInput);
		click(searchInput);
		return new SearchInputBox();
	}

	public SignInPage goToSignIn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(signInAccountsAndLists));

		scrollToElementJS(signInAccountsAndLists);

		try {
			act.moveToElement(find(signInAccountsAndLists)).perform();
			Thread.sleep(1000);
		} catch (Exception e) {

			click(signInAccountsAndLists);
		}

		wait.until(ExpectedConditions.elementToBeClickable(signInButton));

		try {
			click(signInButton);
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInButton);
		}

		return new SignInPage();
	}

	public BestSellersPage goToBestSellers() {
		//scrollToElementJS(bestSellers);
		click(bestSellers);
		return new BestSellersPage();
	}

	public DefaultLanguagePage goToDefaultLanguage() {
		scrollToElementJS(defaultLanguage);
		act.moveToElement(find(defaultLanguage)).perform();
		return new DefaultLanguagePage();
	}

	public CartPage goToCart() {
		scrollToElementJS(cart);
		click(cart);
		return new CartPage();
	}

	public AffiliatePage goToAffiliatePage() {
		scrollToElementJSWithOffset(affiliate);
		click(affiliate);
		return new AffiliatePage();
	}

	public PressReleasePage goToPressReleasePage() {
		scrollToElementJSWithOffset(pressRelease);
		click(pressRelease);
		return new PressReleasePage();
	}

	public AmazonPayPage goToPayPage() {
		scrollToElementJS(amazonPay);
		click(amazonPay);
		return new AmazonPayPage();
	}

}
