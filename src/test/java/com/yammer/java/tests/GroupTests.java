package com.yammer.java.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.yammer.business.objects.Group;
import com.yammer.business.objects.User;
import com.yammer.steps.GroupSteps;
import com.yammer.steps.LoginSteps;
import com.yammer.steps.SearchSteps;
import com.yammer.utils.Browser;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupTests {

  private GroupSteps groupSteps;
  private SearchSteps searchSteps;
  private User user;
  private Process process;

  @BeforeClass
  public void beforeClass() {
    String name = System.getProperty("username");
    String password = System.getProperty("password");
    user = User.getInstance(name, password);  }

  @BeforeMethod
  public void setUp() throws IOException {
    groupSteps = new GroupSteps();
    searchSteps = new SearchSteps();

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
  public void createGroupTest() {
    user.setGroup(new Group("New_group_for_check_creatingTest"));
    groupSteps.createGroup(user.getGroup());
    assertTrue(groupSteps.checkGroupName(user.getGroup()));
    groupSteps.deleteGroup();
  }

  @Test
  public void deleteGroupTest() {
    user.setGroup(new Group("New_group_for_check_creatingTest"));
    groupSteps.createGroup(user.getGroup());
    assertTrue(groupSteps.deleteGroup());
  }

  @Test
  public void joinGroupTest() {
    user.setSearchQuery("Hakuna-Matata");
    searchSteps.search(user.getSearchQuery());
    searchSteps.openGroupsFolder();
    searchSteps.openGroup();
    groupSteps.joinGroup();
    assertTrue(groupSteps.isGroupMember());
    groupSteps.leaveGroup();
  }

  @Test
  public void leaveGroupTest() {
    user.setSearchQuery("Hakuna-Matata");
    searchSteps.search(user.getSearchQuery());
    searchSteps.openGroupsFolder();
    searchSteps.openGroup();
    groupSteps.joinGroup();
    groupSteps.leaveGroup();
    assertFalse(groupSteps.isGroupMember());
  }

  @AfterMethod
  public void tearDown() {
    process.destroy();
    Browser.kill();
  }
}
