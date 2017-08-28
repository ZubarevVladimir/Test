package com.yammer.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {

  private final By BUTTON_SETTING_AND_MORE_LOCATOR = By
      .xpath("//button[@title='Setting and More']");
  private final By BUTTON_USER_PAGE_LOCATOR = By
      .xpath("//a[@class='yj-global-sidebar--nav-user--name']");
  private final By BUTTON_CREATE_GROUP_LOCATOR = By
      .xpath("//button[@title='Create a new group']");
  private final By SEARCH_FIELD_LOCATOR = By
      .xpath("//div[@class='yj-nav-menu--search']/input");
  private final By BUTTON_INBOX_PAGE_LOCATOR = By.xpath("//a[@title = 'Inbox']");
  private final By LIST_OF_GROUPS_LOCATOR = By
      .xpath("//*[contains(@class,'text-wrapper') and ancestor::li[contains(@class,'group')]]");

  public ProfilePage openProfilePage() {
    browser.getElement(BUTTON_SETTING_AND_MORE_LOCATOR).click();
    browser.getElement(BUTTON_USER_PAGE_LOCATOR).click();
    browser.refresh();
    return new ProfilePage();
  }

  public CreationGroupPage clickCreateGroupButton() {
    browser.getElement(BUTTON_CREATE_GROUP_LOCATOR).click();
    return new CreationGroupPage();
  }

  public SearchResultPage search(String searchString) {
    browser.type(SEARCH_FIELD_LOCATOR, searchString);
    browser.type(SEARCH_FIELD_LOCATOR, Keys.PAUSE);
    browser.type(SEARCH_FIELD_LOCATOR, Keys.ENTER);
    return new SearchResultPage();
  }

  public InboxPage clickInboxPageButton() {
    browser.click(BUTTON_INBOX_PAGE_LOCATOR);
    return new InboxPage();
  }

  public GroupPage openGroupByName(String groupName) {
    List<WebElement> groups = browser.getElements(LIST_OF_GROUPS_LOCATOR);

    for (WebElement group : groups) {
      if (group.getText().equals(groupName)) {
        group.click();
        break;
      }
    }
    browser.refresh();
    return new GroupPage();
  }

}
