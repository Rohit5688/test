package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageElements.LandingPageElements;
import commonmethods.ActionSelenium;

public class LandingPageActions {

	static WebDriver driver;
	LandingPageElements landingPageElements;

	public LandingPageActions(WebDriver driver) {
		this.driver = driver;
		landingPageElements= new LandingPageElements();
		landingPageElements.driverInit(driver);
	}

	public static void openLandingPage(String url) {
		ActionSelenium.OpenBrowser(driver, url);
		ActionSelenium.setMainWindow(driver.getWindowHandle());
	}

	public static void searchItem(String text) {
		ActionSelenium.Type(driver, text, LandingPageElements.searchBoxLandingPage);
		ActionSelenium.click(driver, LandingPageElements.searchButton);
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
		Assert.assertTrue(ActionSelenium.getPageTitle(driver).equals(text));
	}

}
