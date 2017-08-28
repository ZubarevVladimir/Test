package com.yammer.cucumber.stepDefs;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.yammer.business.objects.Group;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GroupStepDef extends AbstractStepDef {

  private boolean isDeleted = false;

  @And("^I open group with \"([^\"]*)\" name$")
  public void iOpenGroup(String groupName){
    super.getUser().setGroup(new Group(groupName));
    groupSteps.openGroup(super.getUser().getGroup());
  }

  @When("^I create group with \"([^\"]*)\" name$")
  public void iCreateGroup(String groupName){
    super.getUser().setGroup(new Group(groupName));
    groupSteps.createGroup(super.getUser().getGroup());
  }

  @When("^I delete this group$")
  public void iDeleteGroup(){
    isDeleted = groupSteps.deleteGroup();
  }

  @And("^I join this group$")
  public void iJoinGroup(){
    groupSteps.joinGroup();
  }

  @And("^I leave this group$")
  public void iLeaveGroup(){
    groupSteps.leaveGroup();
  }

  @Then("^group name the similar to given string$")
  public void groupNameTheSimilarToGiven(){
    assertTrue(groupSteps.checkGroupName(super.getUser().getGroup()));
  }

  @Then("^group was deleted$")
  public void groupWasDeleted(){
    assertTrue(isDeleted);
    isDeleted = false;
  }

  @Then("^I am group member$")
  public void iAmGroupMember(){
    assertTrue(groupSteps.isGroupMember());
    groupSteps.leaveGroup();
  }

  @Then("^I am not a group member$")
  public void iAmNotGroupMember(){
    assertFalse(groupSteps.isGroupMember());
  }
}

