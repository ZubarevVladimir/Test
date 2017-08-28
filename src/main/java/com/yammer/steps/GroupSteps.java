package com.yammer.steps;

import com.yammer.business.objects.Group;
import com.yammer.pages.GroupPage;
import com.yammer.pages.HomePage;

public class GroupSteps {

  private GroupPage groupPage;
  private HomePage homePage;

  public GroupSteps() {
    homePage = new HomePage();
    groupPage = new GroupPage();
  }

  public void createGroup(Group group) {
    homePage.clickCreateGroupButton().choosePrivateGroupType()
        .typeNameOfGroup(group.getGroupName()).clickCreateGroupButton();
  }

  public void joinGroup() {
    groupPage.clickJoinGroup();
  }

  public void leaveGroup() {
    groupPage.clickLeaveGroup();
  }

  public boolean deleteGroup() {
    return groupPage.openGroupSettingsPage().deleteGroup();
  }

  public boolean checkGroupName(Group group) {
    return groupPage.getGroupName().equals(group.getGroupName());
  }

  public void openGroup(Group group) {
    homePage.openGroupByName(group.getGroupName());
  }

  public boolean isGroupMember() {
    return groupPage.isMember();
  }
}
