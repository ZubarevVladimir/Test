package com.yammer.cucumber.stepDefs;

import com.yammer.business.objects.User;
import com.yammer.steps.CommentSteps;
import com.yammer.steps.GroupSteps;
import com.yammer.steps.MessageSteps;
import com.yammer.steps.PostSteps;
import com.yammer.steps.SearchSteps;
import com.yammer.steps.UserSteps;

public class AbstractStepDef {

  private final String USERNAME_PROPERTY = "username";
  private final String PASSWORD_PROPERTY = "password";
  private User user;
  protected CommentSteps commentSteps;
  protected GroupSteps groupSteps;
  protected MessageSteps messageSteps;
  protected PostSteps postSteps;
  protected SearchSteps searchSteps;
  protected UserSteps userSteps;

  public AbstractStepDef(){
    user = User.getInstance(System.getProperty(USERNAME_PROPERTY), System.getProperty(PASSWORD_PROPERTY));
    commentSteps = new CommentSteps();
    groupSteps = new GroupSteps();
    messageSteps = new MessageSteps();
    postSteps = new PostSteps();
    searchSteps = new SearchSteps();
    userSteps = new UserSteps();
  }

  protected User getUser() {
    return user;
  }

  protected void setUser(User user) {
    this.user = user;
  }
}
