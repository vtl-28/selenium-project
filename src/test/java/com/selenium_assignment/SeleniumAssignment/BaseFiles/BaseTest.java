package com.selenium_assignment.SeleniumAssignment.BaseFiles;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium_assignment.SeleniumAssignment.Base.BasePage;
import com.selenium_assignment.SeleniumAssignment.Pages.HomePage;
import com.selenium_assignment.SeleniumAssignment.Utilities.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public Logger logger = LogManager.getLogger(BaseTest.class);
	protected BasePage basePage;
	protected HomePage homePage;

	@BeforeClass
	@Parameters({ "browser", "AUT" })
	public void setUp(@Optional("chrome") String nameOfBrowser, @Optional("https://www.amazon.in") String AUT) {
		logger.info("Starting test from the base file");
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless");
		if (nameOfBrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		if (nameOfBrowser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (nameOfBrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.get(AUT);
		basePage = new BasePage();
		basePage.setDriver(driver);
		homePage = new HomePage();
		homePage.setDriver(driver);
		Utility.setUtility();

	}

	@AfterClass
	public void tearDown() {
		logger.info("Ending test from the base file");
		driver.quit();
	}
}
