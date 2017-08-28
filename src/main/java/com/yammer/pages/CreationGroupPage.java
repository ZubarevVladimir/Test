package com.yammer.pages;

import org.openqa.selenium.By;

public class CreationGroupPage extends AbstractPage {

  private final By BUTTON_CREATE_GROUP_LOCATOR = By
      .xpath("//button[contains(@class, 'submit-button')]");
  private final By STATUS_CHECKING_GROUP_NAME_LOCATOR = By
      .xpath("//span[parent::div[contains(@class, 'name-status')]]");
  private final By FIELD_GROUP_NAME_LOCATOR = By
      .xpath("//input[@class='yj-create-group-form--name-input']");
  private final By BUTTON_PRIVATE_GROUP_LOCATOR = By
      .xpath("//input[contains(@aria-label, 'Private Access')]");

  public CreationGroupPage typeNameOfGroup(String nameOfGroup) {
    browser.type(FIELD_GROUP_NAME_LOCATOR, nameOfGroup);
    return this;
  }

  public CreationGroupPage choosePrivateGroupType() {
    browser.click(BUTTON_PRIVATE_GROUP_LOCATOR);
    return this;
  }

  public GroupPage clickCreateGroupButton() {
    browser.waitTextToBePresentInElement(STATUS_CHECKING_GROUP_NAME_LOCATOR, "Name is available.");
    browser.click(BUTTON_CREATE_GROUP_LOCATOR);
    return new GroupPage();
  }
}
