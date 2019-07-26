package PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPageElements {
	static WebDriver driver;
	@FindBy(xpath = "//input[@title='Add to Shopping Cart']")
	public static WebElement addtocartbutton;

	public void driverInit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
