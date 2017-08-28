package com.yammer.pages;

import org.openqa.selenium.By;

public class InboxPage extends AbstractPage {

  private final By BUTTON_NEW_MESSAGE_LOCATOR = By
      .xpath("//div[@class = 'yj-create-message-button']/button");
  private final By PRIVATE_MESSAGES_FOLDER_LOCATOR = By
      .xpath("//a[@data-feed-type = 'private']");
  private final By ALL_MESSAGES_FOLDER_LOCATOR = By
      .xpath("//a[@data-feed-type = 'all']");
  private final By LAST_SENT_MESSAGE_LOCATOR = By
      .xpath("//ul[@data-qaid='inbox-list-messages']/li[1]");

  public InboxPage openPrivateMessagesFolder() {
    browser.refresh();
    browser.click(PRIVATE_MESSAGES_FOLDER_LOCATOR);
    return this;
  }

  public MessagePage openLastSentMessage() {
    browser.refresh();
    browser.click(LAST_SENT_MESSAGE_LOCATOR);
    return new MessagePage();
  }

  public CreationMessagePage clickNewMessageButton() {
    browser.click(BUTTON_NEW_MESSAGE_LOCATOR);
    return new CreationMessagePage();
  }
}
