package com.yammer.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProfilePage extends AbstractPage {

  private final By BOOKMARKS_FOLDER_LOCATOR = By
      .xpath("//a[@data-tab-type='bookmarks']");
  private final By LAST_BOOKMARK_IN_FOLDER_LOCATOR = By.xpath(
      "//li[contains(@class,'yj-first-message')]//div[contains(@class,'yj-thread-starter')]");
  private final By BUTTTON_FOLLOWING_USERS_PAGE_LOCATOR = By
      .xpath("//div[@class='yj-user-profile--following']//button");
  private final By FOLLOWING_USERS_LOCATOR = By
      .xpath("//li[@class='yj-follow-item follow-user']");
  private final By BUTTON_UNFOLLOW_USERS_LOCATOR = By
      .xpath("./div/button");
  private final By LIST_BOOKMARKS_LOCATOR = By
      .xpath("//li[contains(@class,'yj-thread-list-item-extended')]");
  private final By GROUP_NAME_IN_BOOKMARK_LOCATOR = By
      .xpath("//span[@class='yj-group-callout--name']");

  public ProfilePage openBookmarksFolder() {
    browser.click(BOOKMARKS_FOLDER_LOCATOR);
    return this;
  }

  public List<WebElement> getFollowingList() {
    return browser.getElements(FOLLOWING_USERS_LOCATOR);
  }

  public ProfilePage clickUnfollowUserButton(String userName) {
    for (WebElement user : getFollowingList()) {
      if (user.getText().contains(userName)) {
        user.findElement(BUTTON_UNFOLLOW_USERS_LOCATOR).click();
        break;
      }
    }
    browser.refresh();
    return this;
  }

  public ProfilePage openFollowingUsers() {
    browser.click(BUTTTON_FOLLOWING_USERS_PAGE_LOCATOR);
    return this;
  }

  public boolean isPostInBookmark() {
    return browser.getElements(LIST_BOOKMARKS_LOCATOR).size() > 0
        && browser.isDisplayed(GROUP_NAME_IN_BOOKMARK_LOCATOR);
  }
}
