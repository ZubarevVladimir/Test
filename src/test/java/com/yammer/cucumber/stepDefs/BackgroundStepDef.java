package com.yammer.cucumber.stepDefs;

import com.yammer.steps.LoginSteps;
import com.yammer.utils.Browser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BackgroundStepDef extends AbstractStepDef {

  private final String YAMMER_HOME_PAGE = "https://yammer.com/epam.com";

  @Given("^I open yammer site in browser$")
  public void open() {
    Browser.getBrowserInstance().open(YAMMER_HOME_PAGE);
  }

  @And("^Sign-in with my credentials from system property$")
  public void signIn() {
    new LoginSteps().login(super.getUser());
    RemoteWebDriver autoitDriver = Browser.getAutoitDriver();
    autoitDriver.switchTo().window("Authentication Required");
    new Actions(autoitDriver)
        .sendKeys(super.getUser().getUserName() + "{TAB}" + super.getUser().getPassword()
            + "{TAB}{ENTER}").build().perform();
  }

  @And("^close browser$")
  public void tearDown() {
    Browser.kill();
  }
}
