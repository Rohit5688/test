package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageElements.ProductDetailPageElements;
import PageElements.ProductResultPageElements;
import commonmethods.ActionSelenium;

public class ProductDetailPage {
	static WebDriver driver;
	ProductDetailPageElements productDetailPageElements;

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		productDetailPageElements = new ProductDetailPageElements();
		productDetailPageElements.driverInit(driver);
	}

	public static void clickOnAddToCartButton() {
		ActionSelenium.click(driver, ProductDetailPageElements.addtocartbutton);
	}

}
