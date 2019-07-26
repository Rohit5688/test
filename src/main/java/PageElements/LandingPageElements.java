package PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageElements {
	static WebDriver driver;
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	public static WebElement searchBoxLandingPage;

	@FindBy(xpath = "//input[@value='Go']")
	public static WebElement searchButton;

	public void driverInit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
