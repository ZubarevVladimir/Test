package com.yammer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ShareConversationPage extends AbstractPage {

  private final By FIELD_ADDRESSEE_GROUP_LOCATOR = By
      .xpath("//input[@placeholder='Select a group']");
  private final By TEXTAREA_BODY_POST_LOCATOR = By
      .xpath("//div[@class='yj-tapf-textarea-container']/textarea");
  private final By BUTTON_SHARE_LOCATOR = By.xpath("//button[@data-qaid='post_button']");

  public ShareConversationPage setAddresseeGroup(String nameGroup) {
    browser.type(FIELD_ADDRESSEE_GROUP_LOCATOR, nameGroup);
    browser.type(FIELD_ADDRESSEE_GROUP_LOCATOR, Keys.TAB);
    return this;
  }

  public ShareConversationPage setBodyPost(String body) {
    browser.type(TEXTAREA_BODY_POST_LOCATOR, body);
    return this;
  }

  public GroupPage clickSharePost() {
    browser.click(BUTTON_SHARE_LOCATOR);
    browser.refresh();
    return new GroupPage();
  }
}
