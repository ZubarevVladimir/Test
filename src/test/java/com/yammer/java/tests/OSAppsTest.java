package com.yammer.java.tests;

import com.yammer.utils.AutoitDriver;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OSAppsTest {

  public WebDriver autoitDriver;
  public DesiredCapabilities capabilities;

  @Before
  public void setUp() throws Exception {
    capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName", "AutoIt");
    try {
      autoitDriver = AutoitDriver.getAutoitDriver();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @After
  public void tearDown() throws Exception {
    autoitDriver.quit();
  }

  @Test
  public void test() throws Exception {

    autoitDriver.get("C:\\Program Files\\Notepad++\\notepad++.exe");
    Thread.sleep(1000);
    autoitDriver.switchTo().window("Notepad++");
    new Actions(autoitDriver).sendKeys("{ALT}{ENTER}{N}").build().perform();
    new Actions(autoitDriver).sendKeys(
        "this is autoit typed text{ENTER}AutoItDriverServer moved the caret down{ENTER} and will open save file dialog{ALT}{ENTER}{s}")
        .build().perform();
    autoitDriver.switchTo().window("Save As");
    Thread.sleep(2000);
    autoitDriver.findElement(By.linkText("Cancel")).click();
    Thread.sleep(2000);
    autoitDriver.close();
  }
}

