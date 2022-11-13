package risecodes.testcases;

import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import risecodes.utilities.ScreenShotCapture;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	
	public WebDriver driver;
	ScreenShotCapture scr;
  
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod() {
	  
	 driver = WebDriverManager.chromedriver().create();
	 driver.get("https://www.saucedemo.com/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod(ITestResult itestResult) throws IOException {
	  
	  if(itestResult.getStatus() == ITestResult.FAILURE)
	  {
		  scr = new ScreenShotCapture();
		  scr.captureScreenShot(driver, itestResult.getName());
	  }
	  
	  driver.close();
  }

}
