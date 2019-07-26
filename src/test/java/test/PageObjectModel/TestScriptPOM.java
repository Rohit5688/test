package test.PageObjectModel;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageActions.LandingPageActions;
import PageActions.ProductDetailPage;
import PageActions.ProductResultPage;
import PageActions.ShoppingCartPage;
import commonmethods.Driverinit;
import commonmethods.ReadExcel;

public class TestScriptPOM {

	WebDriver driver;
	String url = "https://www.amazon.in/";
	ArrayList<String> value;

	@BeforeTest
	@Parameters("browser")
	public void init(@Optional("edge") String Browser) throws IOException {
		driver = Driverinit.Gridinit(Browser);
		value = ReadExcel.readData("src/test/java/resources", "Test.xlsx", "Mobile");
	}

	@Test
	public void searchProduct() {
		for (String input : value) {
			LandingPageActions.openLandingPage(url);
			LandingPageActions.verifyPageTitle(
					"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
			LandingPageActions.searchItem(input);
			ProductResultPage.verifyPageTitle("Amazon.in: " + input);
			ProductResultPage.isSearchedProductPresent(input);
			ProductResultPage.clickonFirstResult(input);
			ProductDetailPage.clickOnAddToCartButton();
			ShoppingCartPage.clickOnProceedToBuyButton();
			ShoppingCartPage.closeCurrentTab();
		}

	}

	@AfterTest
	public void shutDown() {
		driver.quit();
	}

	@AfterClass
	public void cleanUp() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver_Win.exe /T");
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver_Win.exe /T");
			Runtime.getRuntime().exec("taskkill /F /IM Microsoft Edge.exe /T");
		} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace();

		}
	}
}
