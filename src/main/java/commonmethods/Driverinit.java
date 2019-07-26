package commonmethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import PageActions.LandingPageActions;
import PageActions.ProductDetailPage;
import PageActions.ProductResultPage;
import PageActions.ShoppingCartPage;

public class Driverinit {
	static WebDriver driver = null;

	public static WebDriver init(String Browser) {
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver_Win.exe");
			ChromeOptions chromeoptions = new ChromeOptions();
			// chromeoptions.setBinary("C:\\Program Files
			// (x86)\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			chromeoptions.setPageLoadStrategy(PageLoadStrategy.NONE);
			chromeoptions.addArguments("start-maximized");
			chromeoptions.addArguments("enable-automation");
			// options.addArguments("--headless");
			chromeoptions.addArguments("--no-sandbox");
			chromeoptions.addArguments("--disable-infobars");
			chromeoptions.addArguments("--disable-dev-shm-usage");
			chromeoptions.addArguments("--disable-browser-side-navigation");
			chromeoptions.addArguments("--disable-gpu");
			chromeoptions.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(chromeoptions);
			Driverinit.initPage(driver);
			return driver;
		} else if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver_Win.exe");
			ProfilesIni prof = new ProfilesIni();
			FirefoxProfile ffProfile = prof.getProfile("default");
			FirefoxOptions ffoptions = new FirefoxOptions();
			ffoptions.setProfile(ffProfile);
			ffoptions.setAcceptInsecureCerts(true);
			ffoptions.setCapability("marionette", true);
			ffoptions.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new FirefoxDriver(ffoptions);
			Driverinit.initPage(driver);
			return driver;
		}
		else if (Browser.equalsIgnoreCase("edge")) {
			EdgeOptions edgeoptions = new EdgeOptions();
			driver = new EdgeDriver(edgeoptions);
			Driverinit.initPage(driver);
			return driver;
		}
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}

	public static void initPage(WebDriver driver) {
		LandingPageActions landingPageActions = new LandingPageActions(driver);
		ProductResultPage productResultPage = new ProductResultPage(driver);
		ProductDetailPage productDetailPage = new ProductDetailPage(driver);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
	}

	public static WebDriver Gridinit(String Browser) {
		String nodeURL = "http://192.168.43.100:5566/wd/hub";
		String browser = Browser;
		ChromeOptions chromeoptions = null;
		FirefoxOptions ffoption = null;
		EdgeOptions edgeoptions = null;
		if (browser.equalsIgnoreCase("chrome")) {
			chromeoptions = new ChromeOptions();
			DesiredCapabilities d = DesiredCapabilities.chrome();
			d.setBrowserName("chrome");
			d.setPlatform(Platform.WINDOWS);
			chromeoptions.setPageLoadStrategy(PageLoadStrategy.NONE);
			chromeoptions.addArguments("start-maximized");
			chromeoptions.addArguments("enable-automation");
			// options.addArguments("--headless");
			chromeoptions.addArguments("--no-sandbox");
			chromeoptions.addArguments("--disable-infobars");
			chromeoptions.addArguments("--disable-dev-shm-usage");
			chromeoptions.addArguments("--disable-browser-side-navigation");
			chromeoptions.addArguments("--disable-gpu");
			chromeoptions.setAcceptInsecureCerts(true);
			chromeoptions.merge(d);
			try {
				driver = new RemoteWebDriver(new URL(nodeURL), chromeoptions);
				Driverinit.initPage(driver);
				return driver;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			ffoption = new FirefoxOptions();
			DesiredCapabilities d = DesiredCapabilities.firefox();
			d.setBrowserName("firefox");
			d.setPlatform(Platform.WINDOWS);
			ffoption.addArguments("start-maximized");
			ffoption.setCapability(FirefoxDriver.MARIONETTE, true);
			ffoption.merge(d);
			try {
				driver = new RemoteWebDriver(new URL(nodeURL), ffoption);
				Driverinit.initPage(driver);
				return driver;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (browser.equalsIgnoreCase("edge")) {
			edgeoptions = new EdgeOptions();
			DesiredCapabilities d = DesiredCapabilities.edge();
			d.setBrowserName("MicrosoftEdge");
			d.setPlatform(Platform.WINDOWS);
			edgeoptions.merge(d);
			try {
				driver = new RemoteWebDriver(new URL(nodeURL), edgeoptions);
				Driverinit.initPage(driver);
				return driver;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return driver;
	}
}
