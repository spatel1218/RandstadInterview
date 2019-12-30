package utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Utils {
	
	public static WebDriver driver;
	public static boolean result=false;
	
	public void invokebrowser() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\libs\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("marionette", true);
		capabilities.setCapability("acceptInsecureCerts", true);
		capabilities.setCapability("javascriptEnabled", true);
		// System.setProperty("webdriver.gecko.driver","E:\\\\geckodriver.exe");
		// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		// driver= new FirefoxDriver(capabilities);

		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		System.out.println("\nBrowser invoked and navigated to the URL\n");

	}
	
	public static void elementtobeClickable(WebElement ele) throws Exception {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static boolean verifyElement(WebElement ele) {
		
		try {
			WebDriverWait wait=new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(ele));
			result=true;
		}catch(Exception e) {
			result=false;
		}
		return result;
		
	}
	
	public static void clickWebelement(WebElement ele,String message) throws Exception {
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);
			//ele.click();
			System.out.println(message+" button is clicked");
		}catch(Exception e) {
			e.printStackTrace();
			screenshot(message);
			throw new Exception();
		}
	}
	
	public static void sendText(WebElement ele,String message) throws Exception {
		try {
			ele.sendKeys(message);
			System.out.println(message+" is entered in to textbox");
		}catch(Exception e) {
			e.printStackTrace();
			screenshot(message);
			throw new Exception();
		}
	}
	
	public static void screenshot(String message) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"\\screenShots\\"+message+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}
	
	
}
