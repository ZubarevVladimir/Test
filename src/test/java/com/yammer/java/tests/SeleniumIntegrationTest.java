package com.yammer.java.tests;

import com.yammer.utils.AutoitDriver;
import com.yammer.utils.GridInfoExtracter;
import java.security.Key;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.remote.*;


import org.openqa.selenium.interactions.*;
import java.net.URL;
import org.openqa.selenium.security.Credentials;

public class SeleniumIntegrationTest {

  public WebDriver webDriver;
  public RemoteWebDriver autoitDriver;
  public DesiredCapabilities autoItCapabilities;

  @Before
  public void setUp() throws Exception {

    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    String hubHost = "localhost";
    webDriver = new ChromeDriver();
    autoitDriver = AutoitDriver.getAutoitDriver();

  }

  @After
  public void tearDown() throws Exception {
    webDriver.close();
    autoitDriver.quit();
  }

  @Test
  public void test() throws Exception {
    // ### HTTP authentication dialog popup demo ###
    //autoitDriver.switchTo().window("Google Chrome");
    //new Actions(autoitDriver).sendKeys(Keys.ALT,Keys.TAB);
    webDriver.get("https://yammer.com/epam.com");
    Thread.sleep(5000);
    autoitDriver.switchTo().window("Sign in to your account");
    Thread.sleep(10000);
    webDriver.get("http://www.httpwatch.com/httpgallery/authentication/");
    webDriver.findElement(By.id("displayImage")).click(); // trigger the popup
    Thread.sleep(1000); // wait for popup to appear
    autoitDriver.switchTo().window("Authentication Required");
    new Actions(autoitDriver)
        .sendKeys("httpwatch{TAB}AutoItDriverServerAndSeleniumIntegrationDemo{TAB}").build()
        .perform();
    new Actions(autoitDriver).sendKeys("{ENTER}").build().perform
        ();

    // below is some demo code which should be adjusted for exact test data and site content
    // file upload demo is already implemented for real project code
    /*// ### file upload demo, also adapted from sample code of the test/target site ###
		webDriver.get("http://www.toolsqa.com/automation-practice-form");
		// webDriver.findElement(By.id("photo")).click(); // this doesn't seem to trigger file upload to popup
		WebElement elem = webDriver.findElement(By.id("photo"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",elem);
		Thread.sleep(5000); // wait for file upload dialog to appear
		autoitDriver.switchTo().window("File Upload");

		 FYI, on FF, Opera, (Windows Safari) filename field control ID may be 1152
		 * but on IE, Chrome, and Windows in general, should be control ID should be 1148 
		 
		//uncomment line below if want to transfer file from Selenium code execution machine A to remote node B before typing in actual file path at target node B
		//((RemoteWebDriver) autoitDriver).setFileDetector(new LocalFileDetector());
		autoitDriver.findElement(By.className("Edit1")).sendKeys("C:\\ReplaceWith\\PathTo\\AnActualFileOnRemoteNode.txt");
		Thread.sleep(2000);
		autoitDriver.findElement(By.className("Button1")).click();
		//new Actions(autoitDriver).sendKeys("{ENTER}").perform(); // another option to "click" Open/Upload
		//new Actions(autoitDriver).sendKeys("!o").perform(); // another option to invoke Open/Upload via keyboard shortcut ALT + O
		Thread.sleep(5000);
		
		// execute an AutoIt script from WebDriver
		((JavascriptExecutor) autoitDriver).executeScript("C:\\PathOnAutoItDriverServerHostMachineTo\\demo.au3","Hello","World");*/
  }

}
