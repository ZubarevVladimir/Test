package com.yammer.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Singleton AutoitDriver-class. Include many methods for implementation some actions (click, type,
 * refresh and more). Consist javascript executors methods.
 */
public class AutoitDriver {

  private static WebDriver autoitDriver;

  public static synchronized WebDriver getAutoitDriver() {
    if (autoitDriver != null) {
      return autoitDriver;
    } else {
      System.out.println("AUTOIT NULL");
      DesiredCapabilities autoItCapabilities = new
          DesiredCapabilities();
      autoItCapabilities.setCapability("browserName", "AutoIt");//10.6.132.40
      try {
        autoitDriver =
            new RemoteWebDriver(new URL("http://" + "10.6.132.40" +
                ":4723/wd/hub"), autoItCapabilities);
        System.out.println("AUTOIT -> "+autoitDriver);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }
    return autoitDriver;
  }

}