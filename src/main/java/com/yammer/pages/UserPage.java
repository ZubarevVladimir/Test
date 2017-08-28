package com.yammer.pages;

import org.openqa.selenium.By;

public class UserPage extends AbstractPage {

  private final By BUTTON_FOLLOW_LOCATOR = By
      .xpath("//*[@class='yj-user-profile-header--follow-button']/button");

  public UserPage clickFollowButton() {
    browser.click(BUTTON_FOLLOW_LOCATOR);
    return this;
  }
}
