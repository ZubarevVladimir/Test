package com.yammer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage extends AbstractPage {

  private final By FIELD_LOGIN_LOCATOR = By.id("cred_userid_inputtext");
  private final By FIELD_PASSWORD_LOCATOR = By.id("passwordInput");
  private final By BUTTON_SUBMIT_LOCATOR = By.id("submitButton");
  private final By LOAD_ELEMENT_LOCATOR = By.id("credentials");

  private LoginPage setPassword(String password) {
    browser.type(FIELD_PASSWORD_LOCATOR, password);
    return this;
  }

  private LoginPage setLogin(String login) {
    browser.type(FIELD_LOGIN_LOCATOR, login);
    browser.type(FIELD_LOGIN_LOCATOR, Keys.TAB);
    return this;
  }

  private boolean isLoad() {
    return browser.getElement(LOAD_ELEMENT_LOCATOR).isDisplayed();
  }

  private HomePage clickSubmit() {
    browser.click(BUTTON_SUBMIT_LOCATOR);
    return new HomePage();
  }

  public HomePage login(String userName, String pasword) {
    setLogin(userName);
    /*if (isLoad()) {
      setPassword(pasword);
      clickSubmit();
    }*/
    return new HomePage();
  }
}
