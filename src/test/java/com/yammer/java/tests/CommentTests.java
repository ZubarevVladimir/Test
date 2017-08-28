package com.yammer.java.tests;

import static org.testng.Assert.assertEquals;

import com.yammer.business.objects.Comment;
import com.yammer.business.objects.Group;
import com.yammer.business.objects.Post;
import com.yammer.business.objects.User;
import com.yammer.steps.CommentSteps;
import com.yammer.steps.GroupSteps;
import com.yammer.steps.LoginSteps;
import com.yammer.steps.PostSteps;
import com.yammer.utils.Browser;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CommentTests {

  private CommentSteps commentSteps;
  private GroupSteps groupSteps;
  private PostSteps postSteps;
  private User user;
  private Group wildBamboleosGroup;
  private Process process;

  @BeforeClass
  public void beforeClass() {
    String name = System.getProperty("username");
    String password = System.getProperty("password");
    user = User.getInstance(name, password);
    wildBamboleosGroup = new Group("Wild Bamboleos");
  }

  @BeforeMethod
  public void setUp() throws IOException {
    commentSteps = new CommentSteps();
    groupSteps = new GroupSteps();
    postSteps = new PostSteps();

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
  public void createCommentTest() {
    user.setPost(new Post("CreateCommentTest"));
    user.setComment(new Comment("CreateCommentTest"));
    groupSteps.openGroup(wildBamboleosGroup);
    postSteps.createPost(user.getPost());
    commentSteps.createComment(user.getComment());
    assertEquals(commentSteps.getLastCommentText(), user.getComment().getBody());
    commentSteps.deleteLastComment();
    postSteps.deleteLastPost();
  }

  @Test
  public void deleteCommentTest() {
    user.setPost(new Post("DeleteCommentTest"));
    user.setComment(new Comment("DeleteCommentTest"));
    groupSteps.openGroup(wildBamboleosGroup);
    postSteps.createPost(user.getPost());
    commentSteps.createComment(user.getComment());
    assertEquals(commentSteps.getLastCommentText(), user.getComment().getBody());
    commentSteps.deleteLastComment();
    postSteps.deleteLastPost();
  }

  @AfterMethod
  public void tearDown() {
    process.destroy();
    Browser.kill();
  }
}
