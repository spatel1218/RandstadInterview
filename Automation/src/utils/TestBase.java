package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class TestBase {

//	public static WebDriver driver;
//
//	public void invokebrowser() {
//
//		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		capabilities.setCapability("browserName", "chrome");
//		capabilities.setCapability("marionette", true);
//		capabilities.setCapability("acceptInsecureCerts", true);
//		capabilities.setCapability("javascriptEnabled", true);
//		// System.setProperty("webdriver.gecko.driver","E:\\\\geckodriver.exe");
//		// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		// driver= new FirefoxDriver(capabilities);
//
//		driver = new ChromeDriver(capabilities);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get("https://www.amazon.com/");
//
//	}
//	
//	@AfterMethod
//	public void closebrowser() {
//		driver.quit();
//	}
//	

}
