package com.yammer.java.tests;

import static org.testng.Assert.assertTrue;

import com.yammer.business.objects.Message;
import com.yammer.business.objects.User;
import com.yammer.steps.LoginSteps;
import com.yammer.steps.MessageSteps;
import com.yammer.utils.Browser;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MessageTests {

  private MessageSteps messageSteps;
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
    messageSteps = new MessageSteps();

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
  public void privateMessageTest() {
    messageSteps.openInboxPage();
    user.setMessage(new Message("Maksim Zaretski", "MessageTest"));
    messageSteps.sendNewPrivateMessage(user.getMessage());
    assertTrue(messageSteps.checkSentMessage(user.getMessage()));
  }

  @AfterMethod
  public void tearDown() {
    process.destroy();
    Browser.kill();
  }
}
