package com.yammer.java.tests;

import static org.testng.Assert.assertTrue;

import com.yammer.business.objects.Group;
import com.yammer.business.objects.User;
import com.yammer.steps.GroupSteps;
import com.yammer.steps.LoginSteps;
import com.yammer.steps.PostSteps;
import com.yammer.steps.UserSteps;
import com.yammer.utils.Browser;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookmarkTests {

  private GroupSteps groupSteps;
  private PostSteps postSteps;
  private UserSteps userSteps;
  private Process process;
  private User user;
  private Group wildBamboleosGroup;

  @BeforeClass
  public void beforeClass() {
    String name = System.getProperty("username");
    String password = System.getProperty("password");
    user = User.getInstance(name, password);
    wildBamboleosGroup = new Group("Wild Bamboleos");
  }

  @BeforeMethod
  public void setUp() throws IOException {
    groupSteps = new GroupSteps();
    postSteps = new PostSteps();
    userSteps = new UserSteps();

    WebDriver autoitDriver = Browser.getBrowserInstance().getAutoitDriver();
    autoitDriver.switchTo().window("Authentication Required");
    new Actions(autoitDriver)
        .sendKeys(user.getUserName()+"{TAB}"+user.getPassword()+"{TAB}{ENTER}").build().perform();
    try {
      File autoIt = new File("src/main/resources/login.exe");
      process = Runtime.getRuntime().exec(autoIt.getAbsolutePath()
          + " " + user.getUserName()
          + " " + user.getPassword());
    } catch (IOException ex){
      System.err.println("File execution exception: " + ex.getLocalizedMessage());
    }
    Browser.getBrowserInstance().open("http://yammer.com/epam.com");
    new LoginSteps().login(user);
  }

  @Test
  public void bookmarkTest() {
    groupSteps.openGroup(wildBamboleosGroup);
    postSteps.addPostToBookmarks();
    userSteps.goToProfile();
    userSteps.openBookmarksFolder();
    assertTrue(userSteps.isPostInBookmark());
    postSteps.deletePostFromBookmark();
  }

  @AfterMethod
  public void tearDown() {
    process.destroy();
    Browser.kill();
  }
}
