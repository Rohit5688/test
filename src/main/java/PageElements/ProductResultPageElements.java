package PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductResultPageElements {
	static WebDriver driver;

	public void driverInit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
