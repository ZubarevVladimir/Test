package com.yammer.steps;

import com.yammer.pages.HomePage;
import com.yammer.pages.ProfilePage;
import com.yammer.pages.UserPage;
import org.openqa.selenium.WebElement;

public class UserSteps {

  private HomePage homePage;
  private UserPage userPage;
  private ProfilePage profilePage;

  public UserSteps() {
    homePage = new HomePage();
    userPage = new UserPage();
    profilePage = new ProfilePage();
  }

  public void goToProfile() {
    homePage.openProfilePage();
  }

  public void follow() {
    userPage.clickFollowButton();
  }

  public void unfollow(String userName) {
    profilePage.clickUnfollowUserButton(userName);
  }

  public boolean checkUserInFollowings(String followingUserName) {
    for (WebElement user : profilePage.getFollowingList()) {
      if (user.getText().contains(followingUserName)) {
        return true;
      }
    }
    return false;
  }

  public void openBookmarksFolder() {
    profilePage.openBookmarksFolder();
  }

  public boolean isPostInBookmark() {
    return profilePage.isPostInBookmark();
  }

  public void openFollowingUsers() {
    profilePage.openFollowingUsers();
  }
}
