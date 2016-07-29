package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ReadProperties;

public class Driver extends ReadProperties {
	public static WebDriver driver;
	public static String chromeDriverPath;

	public void setDriver(String browserType, String appUrl) {

		if (browserType.equalsIgnoreCase("firefox")) {
			initFirefox();
		} else if (browserType.equalsIgnoreCase("chrome")) {
			initChrome(chromeDriverPath);
		} else {
			initFirefox();
		}

		setDriverProperty();
		driver.get(appUrl);

	}

	public void setDriverProperty() {
		driver.manage().window().maximize();
	}

	private void initChrome(String chromeDriverPath) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();

	}

	private void initFirefox() {
		driver = new FirefoxDriver();
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
