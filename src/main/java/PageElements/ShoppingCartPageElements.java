package PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPageElements {

	static WebDriver driver;
	@FindBy(xpath = "//*[contains(text(),'Proceed to Buy')]")
	public static WebElement proceedtobuybutton;

	public void driverInit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
