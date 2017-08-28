package com.yammer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GroupPage extends AbstractPage {

  private final By BUTTON_JOIN_GROUP_LOCATOR = By
      .xpath("//button[@data-qaid = 'join_group_button']");
  private final By BUTTON_LEAVE_GROUP_LOCATOR = By
      .xpath("//button[@data-qaid = 'leave_group_button']");
  private final By LAST_POST_LOCATOR = By.xpath("//li[@data-qaid = 'thread'][1]");
  private final By BUTTON_NEW_POST_LOCATOR = By
      .xpath("//button[parent::li[@data-name = 'updatePublisher']]");
  private final By TEXT_AREA_NEW_POST_LOCATOR = By
      .xpath("//textarea[ancestor::div[contains(@class, 'update-publisher')]]");
  private final By BUTTON_POST_LOCATOR = By
      .xpath("//button[@data-qaid = 'post_button' and ancestor::div[contains(@class, 'update')]]");
  private final By BUTTON_SHARE_POST_LOCATOR = By
      .xpath("//button[contains(@class, 'share') and ancestor::div[contains(@class, 'starter')]]");
  private final By BUTTON_POST_OPTIONS_LOCATOR = By
      .xpath("//button[contains(@class, 'menu') and ancestor::div[contains(@class, 'starter')]]");
  private final By LAST_REPLY_LOCATOR = By
      .xpath("//li[contains(@class, 'thread-reply-list')][last()]");
  private final By BUTTON_REPLY_POST_LOCATOR = By
      .xpath("//*[@data-qaid = 'reply_action' and ancestor::div[contains(@class, 'starter')]]");
  private final By TEXT_FIELD_REPLY_LOCATOR = By
      .xpath("//textarea[ancestor::div[contains(@class, 'reply-publisher')]]");
  private final By BUTTON_REPLY_LOCATOR = By
      .xpath("//button[@data-qaid = 'post_button' and ancestor::div[contains(@class, 'reply')]]");
  private final By GROUP_SETTINGS_LOCATOR = By
      .xpath("//*[@data-qaid=\"settings_button\"]");
  private final By BUTTON_REPLY_OPTIONS_LOCATOR = By
      .xpath("//button[contains(@class, 'menu') and ancestor::div[contains(@class, 'replies')]]");
  private final By BUTTON_DELETE_LOCATOR = By
      .xpath("//button[@title='delete this message']");
  private final By BUTTON_UNBOOKMARK_POST_LOCATOR = By
      .xpath("//button[@title='remove this message from bookmarks']");
  private final By BUTTON_BOOKMARK_POST_LOCATOR = By
      .xpath("//button[@title='bookmark this message']");
  private final By GROUP_NAME_LOCATOR = By.xpath("//span[contains(@class, 'group-name')]");
  private final By MESSAGE_DELETE_GROUP_LOCATOR = By.xpath("//*[@class='notice']");
  private final By MESSAGE_TEXT_LOCATOR = By.xpath(".//span[@data-qaid = 'message-text']");

  public GroupPage clickJoinGroup() {
    browser.click(BUTTON_JOIN_GROUP_LOCATOR);
    return this;
  }

  public GroupPage clickLeaveGroup() {
    browser.click(BUTTON_LEAVE_GROUP_LOCATOR);
    return this;
  }

  public GroupPage createPost(String content) {
    browser.click(BUTTON_NEW_POST_LOCATOR);
    browser.type(TEXT_AREA_NEW_POST_LOCATOR, content);
    browser.click(BUTTON_POST_LOCATOR);
    browser.refresh();
    return this;
  }

  public GroupPage createReplyForLastPost(String content) {
    browser.refresh();
    browser.getElement(BUTTON_REPLY_POST_LOCATOR).click();
    browser.type(TEXT_FIELD_REPLY_LOCATOR, content);
    browser.click(BUTTON_REPLY_LOCATOR);
    return this;
  }

  public GroupSettingsPage openGroupSettingsPage() {
    browser.click(GROUP_SETTINGS_LOCATOR);
    return new GroupSettingsPage();
  }

  public GroupPage deletePost() {
    browser.refresh();
    browser.click(BUTTON_POST_OPTIONS_LOCATOR);
    browser.click(BUTTON_DELETE_LOCATOR);
    browser.submitAlert();
    return this;
  }

  public GroupPage deleteReply() {
    browser.refresh();
    browser.getElement(LAST_REPLY_LOCATOR).findElement(BUTTON_REPLY_OPTIONS_LOCATOR).click();
    browser.click(BUTTON_DELETE_LOCATOR);
    browser.submitAlert();
    return this;
  }

  public GroupPage addPostToBookmark() {
    browser.refresh();
    browser.click(BUTTON_POST_OPTIONS_LOCATOR);
    browser.click(BUTTON_BOOKMARK_POST_LOCATOR);
    return this;
  }

  public GroupPage removePostFromBookmark() {
    browser.refresh();
    browser.click(BUTTON_POST_OPTIONS_LOCATOR);
    browser.click(BUTTON_UNBOOKMARK_POST_LOCATOR);
    return this;
  }

  public String getGroupName() {
    return browser.getElement(GROUP_NAME_LOCATOR).getText();
  }

  public ShareConversationPage openShareConversationPage() {
    browser.click(BUTTON_SHARE_POST_LOCATOR);
    return new ShareConversationPage();
  }

  public String getDeletedGroupIdentifier() {
    return browser.getElement(MESSAGE_DELETE_GROUP_LOCATOR).getText();
  }

  public boolean checkPostInGroup() {
    return browser.isDisplayed(LAST_POST_LOCATOR);
  }

  public boolean isMember() {
    browser.refresh();

    try {
      return browser.getElement(BUTTON_LEAVE_GROUP_LOCATOR) != null;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public String getLastCommentBody() {
    browser.refresh();
    return browser.getElement(LAST_REPLY_LOCATOR).findElement(MESSAGE_TEXT_LOCATOR).getText();
  }

  public WebElement getLastPostComment() {
    browser.refresh();

    try {
      return browser.getElement(LAST_POST_LOCATOR).findElement(LAST_REPLY_LOCATOR);
    } catch (NoSuchElementException ex) {
      return null;
    }
  }

  public String getLastPostBody() {
    browser.refresh();
    return browser.getElement(LAST_POST_LOCATOR).findElement(MESSAGE_TEXT_LOCATOR).getText();
  }

  public WebElement getLastPost() {
    browser.refresh();

    try {
      return browser.getElement(LAST_POST_LOCATOR);
    } catch (NoSuchElementException ex) {
      return null;
    }
  }
}