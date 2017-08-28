package com.yammer.pages;

import org.openqa.selenium.By;

public class CreationMessagePage extends AbstractPage {

  private final By BUTTON_PRIVATE_MESSAGE_LOCATOR = By
      .xpath("//li[@data-name='userPublisher']/button");
  private final By FIELD_ADD_PARTICIPANTS_LOCATOR = By.xpath(
      "//div[contains(@class,'yj-global-recipient-input')]//input[@placeholder='Add participants']");
  private final By TEXT_AREA_MESSAGE_LOCATOR = By
      .xpath("//div[contains(@class,'yj-global-private-publisher')]//textarea");
  private final By BUTTON_SEND_MESSAGE_LOCATOR = By
      .xpath("//button[@class='yj-global-submit-button yj-btn']");
  private final By FIRST_PARTICIPANT_LOCATOR = By
      .xpath("//div[@class='yj-ta-result-list']//span[@class='yj-ta-name']/span");

  public CreationMessagePage clickPrivateMessageType() {
    browser.click(BUTTON_PRIVATE_MESSAGE_LOCATOR);
    return this;
  }

  public InboxPage clickSendMessageButton() {
    browser.click(BUTTON_SEND_MESSAGE_LOCATOR);
    return new InboxPage();
  }

  public CreationMessagePage fillMessage(String participant, String body) {
    browser.type(FIELD_ADD_PARTICIPANTS_LOCATOR, participant);
    browser.click(FIRST_PARTICIPANT_LOCATOR);
    browser.type(TEXT_AREA_MESSAGE_LOCATOR, body);
    return this;
  }
}
