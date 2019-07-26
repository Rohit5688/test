package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageElements.ShoppingCartPageElements;
import commonmethods.ActionSelenium;

public class ShoppingCartPage {
	static WebDriver driver;
	ShoppingCartPageElements shoppingCartPageElements;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		shoppingCartPageElements = new ShoppingCartPageElements();
		shoppingCartPageElements.driverInit(driver);
	}

	public void driverInit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public static void clickOnProceedToBuyButton() {
		ActionSelenium.click(driver, ShoppingCartPageElements.proceedtobuybutton);
	}

	public static void closeCurrentTab() {
		ActionSelenium.closeWebDriver(driver);
		ActionSelenium.switchToMainWindow(driver);

	}

}
