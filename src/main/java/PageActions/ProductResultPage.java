package PageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageElements.ProductResultPageElements;
import commonmethods.ActionSelenium;

public class ProductResultPage {
	static List<WebElement> list;
	static WebDriver driver;
	ProductResultPageElements productResultPageElements;

	public ProductResultPage(WebDriver driver) {
		this.driver = driver;
		productResultPageElements = new ProductResultPageElements();
		productResultPageElements.driverInit(driver);
	}

	public static void isSearchedProductPresent(String text) {
		By results = By.xpath("//*[contains(text(),'" + text + "')]");
		list = driver.findElements(results);
		Assert.assertTrue(list.size() > 0);
	}

	public static void clickonFirstResult(String text) {
		By firstProduct = By.xpath("//span[contains(text(),'" + text + "')][contains(@class,'a-size-medium')]");
		ActionSelenium.click(driver, firstProduct);
		ActionSelenium.switchToWindow(driver, "window1");
	}

	public static void verifyPageTitle(String text) {
		ActionSelenium.waitUtilAtNextPage(text, driver);
		Assert.assertTrue(ActionSelenium.getPageTitle(driver).equals(text));
	}

}
