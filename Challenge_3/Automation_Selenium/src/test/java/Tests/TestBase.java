package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBase {
public static WebDriver driver;


@BeforeSuite
@Parameters({"Browser"})
public void startDriver(@Optional("firefox") String BrowserName)
{
	if (BrowserName.equalsIgnoreCase("chrome"))
	{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
	driver = new ChromeDriver();
	} else if (BrowserName.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	} else {}
	driver.navigate().to("https://www.saucedemo.com/");
	
}

@AfterMethod
public void takeScreenshotOnFail(ITestResult result)
{
	if (result.getStatus() == ITestResult.FAILURE) {
		System.out.println("Failure, Taking a screenshot.. ");
		Helper.captureScreenshot(driver, result.getName());
	}
}


@AfterSuite
public void stopDriver()
{
	driver.quit();
}
}
