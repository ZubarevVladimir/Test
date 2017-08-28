package com.yammer.cucumber.stepDefs;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class UserStepDef extends AbstractStepDef {

  @And("^I follow user$")
  public void followUser(){
    userSteps.follow();
  }

  @And("^I unfollow user$")
  public void unfollowUser(){
    userSteps.unfollow(super.getUser().getSearchQuery());
  }

  @Then("^check \"([^\"]*)\" not exist in folowings$")
  public void checkUserNotExistInFollowings(String userName){
    assertFalse(userSteps.checkUserInFollowings(userName));
  }

  @Then("^check \"([^\"]*)\" exist in folowings$")
  public void checkUserExistInFollowings(String userName){
    assertTrue(userSteps.checkUserInFollowings(userName));
  }

  @And("^go to the profile page$")
  public void goToTheProfilePage() throws Throwable {
    userSteps.goToProfile();
  }

  @And("^open following users$")
  public void openFollowingUsers() {
    userSteps.openFollowingUsers();
  }

  @Then("^I check that post in my bookmarks folder$")
  public void iCheckThatPostInMyBookmarksFolder() throws Throwable {
    userSteps.openBookmarksFolder();
    assertTrue(userSteps.isPostInBookmark());
  }
}
