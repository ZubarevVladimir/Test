package com.yammer.java.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.yammer.business.objects.User;
import com.yammer.steps.LoginSteps;
import com.yammer.steps.SearchSteps;
import com.yammer.steps.UserSteps;
import com.yammer.utils.Browser;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests {

  private SearchSteps searchSteps;
  private UserSteps userSteps;
  private User user;
  private Process process;

  @BeforeClass
  public void beforeClass() {
    String name = System.getProperty("username");
    String password = System.getProperty("password");
    user = User.getInstance(name, password);
  }

  @BeforeMethod
  public void setUp() throws IOException {
    searchSteps = new SearchSteps();
    userSteps = new UserSteps();

    try {
      File autoIt = new File("src/main/resources/login.exe");
      process = Runtime.getRuntime().exec(autoIt.getAbsolutePath()
          + " " + user.getUserName()
          + " " + user.getPassword());
    } catch (IOException ex){
      System.err.println("File execution exception: " + ex.getLocalizedMessage());
    }
    Browser.getBrowserInstance().open("https://yammer.com/epam.com");
    new LoginSteps().login(user);
  }

  @Test
  public void searchGroupTest() {
    user.setSearchQuery("Wild Bamboleos");
    searchSteps.search(user.getSearchQuery());
    searchSteps.openGroupsFolder();
    assertTrue(searchSteps.checkGroupInResult(user.getSearchQuery()));
  }

  @Test
  public void unfollowTest() {
    user.setSearchQuery("Maksim Zaretski");
    searchSteps.search(user.getSearchQuery());
    searchSteps.chooseUser();
    userSteps.follow();
    userSteps.goToProfile();
    userSteps.unfollow(user.getSearchQuery());
    assertFalse(userSteps.checkUserInFollowings(user.getSearchQuery()));
  }

  @Test
  public void followTest() {
    user.setSearchQuery("Maksim Zaretski");
    searchSteps.search(user.getSearchQuery());
    searchSteps.chooseUser();
    userSteps.follow();
    userSteps.goToProfile();
    assertTrue(userSteps.checkUserInFollowings(user.getSearchQuery()));
    userSteps.unfollow(user.getSearchQuery());
  }

  @AfterMethod
  public void tearDown() {
    process.destroy();
    Browser.kill();
  }
}
