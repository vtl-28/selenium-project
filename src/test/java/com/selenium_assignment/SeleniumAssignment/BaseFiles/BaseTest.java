package com.selenium_assignment.SeleniumAssignment.BaseFiles;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-plugins");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors");
        options.addArguments("--disable-logging");
        options.addArguments("--silent");
        
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		if (nameOfBrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
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
