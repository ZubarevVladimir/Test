package com.yammer.pages;

import org.openqa.selenium.By;

public class GroupSettingsPage extends AbstractPage {

  private final By BUTTON_DELETE_GROUP_LOCATOR = By.xpath("//*[@class='group-actions']/a");
  private final By BUTTON_APPROVE_DELETE_GROUP_LOCATOR = By
      .xpath("//*[@class='buttons']/button");
  private final By MESSAGE_DELETE_GROUP_LOCATOR = By.xpath("//*[@class='notice']");
  private final String DELETE_GROUP_MESSAGE = "This group has been deleted.";

  public boolean deleteGroup() {
    browser.click(BUTTON_DELETE_GROUP_LOCATOR);
    browser.click(BUTTON_APPROVE_DELETE_GROUP_LOCATOR);
    return browser.getElement(MESSAGE_DELETE_GROUP_LOCATOR).getText().equals(DELETE_GROUP_MESSAGE);
  }
}
