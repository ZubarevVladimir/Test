package com.yammer.steps;

import com.yammer.business.objects.User;
import com.yammer.pages.LoginPage;

public class LoginSteps {

  private LoginPage loginPage;

  public LoginSteps() {
    loginPage = new LoginPage();
  }

  public void login(User user) {
    loginPage.login(user.getUserName(), user.getPassword());
  }
}
