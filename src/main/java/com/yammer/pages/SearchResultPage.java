package com.yammer.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends AbstractPage {

  private final By USERS_FOLDER_LOCATOR = By.xpath("//button[@data-type='users']");
  private final By GROUPS_FOLDER_LOCATOR = By.xpath("//button[@data-type='groups']");
  private final By LIST_USERS_LOCATOR = By
      .xpath("//*[@id='tab-users']//a[@class='yammer-object yj-hovercard-link ']");
  private final By FIRST_GROUP_NAME_LOCATOR = By
      .xpath("//a[@href and @data-resource-model = 'group']");

  public SearchResultPage clickUsersFolder() {
    browser.click(USERS_FOLDER_LOCATOR);
    return this;
  }

  public SearchResultPage clickGroupsFolder() {
    browser.click(GROUPS_FOLDER_LOCATOR);
    return this;
  }

  public List<WebElement> getUsersList() {
    return browser.getElements(LIST_USERS_LOCATOR);
  }

  public boolean checkGroupConsistInResult(String nameGroup) {
    String currentResultGroup = browser.getElement(FIRST_GROUP_NAME_LOCATOR).getText();
    return nameGroup.equals(currentResultGroup);
  }

  public GroupPage openFirstGroup() {
    browser.click(FIRST_GROUP_NAME_LOCATOR);
    return new GroupPage();
  }
}
