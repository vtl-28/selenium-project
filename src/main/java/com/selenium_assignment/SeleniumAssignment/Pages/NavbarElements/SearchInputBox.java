package com.selenium_assignment.SeleniumAssignment.Pages.NavbarElements;

import org.openqa.selenium.By;

import com.selenium_assignment.SeleniumAssignment.Pages.HomePage;
import static com.selenium_assignment.SeleniumAssignment.Utilities.WaitActions.*;

public class SearchInputBox extends HomePage {

	private By searchInput = By.xpath("//input[@id='twotabsearchtextbox']");
	private By searchButton = By.id("nav-search-submit-button");
	private By foundProducts = By.xpath("//span[contains(text(),'Lenovo')]");

	public void setSearchInputBox(String searchText) {
		set(searchInput, searchText);
	}

	public void searchProduct() {
		click(searchButton);
	}

	public String getFoundProducts() {
		explicitWaitUntilVisible(2, foundProducts);
		String product = find(foundProducts).getText().replace("\"", "").trim();
		return product;
	}
}
