package com.yammer.cucumber.stepDefs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import com.yammer.business.objects.Group;
import com.yammer.business.objects.Post;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PostStepDef extends AbstractStepDef {

  @When("^I try to add last post to bookmark$")
  public void iTryToAddLastPostToBookmark() throws Throwable {
    postSteps.addPostToBookmarks();
  }

  @When("^I create post with \"([^\"]*)\" text$")
  public void iCreatePost(String postText){
    super.getUser().setPost(new Post(postText));
    postSteps.createPost(super.getUser().getPost());
  }

  @And("^I delete last post$")
  public void iDeleteLastPost(){
    postSteps.deleteLastPost();
  }

  @And("^I try to share last post to \"([^\"]*)\" group$")
  public void iTryToShareLastPostToGroup(String nameGroup) throws Throwable {
    postSteps.sharePostToAnotherGroup(new Group(nameGroup));
  }

  @Then("^The post is presented in group$")
  public void thePostIsPresentedInGroup() {
    assertTrue(postSteps.checkSharedPostInGroup());
  }

  @Then("^Last post text the similar to \"([^\"]*)\"$")
  public void lastPostTextTheSimilarTo(String text) {
    assertEquals(postSteps.getLastPostText(), text);
  }

  @Then("^Last post text not similar to \"([^\"]*)\"$")
  public void lastPostTextNotSimilarTo(String text) {
    assertNotEquals(postSteps.getLastPostText(), text);
  }

  @And("^delete post from bookmark$")
  public void deletePostFromBookmark() throws Throwable {
    postSteps.deletePostFromBookmark();
  }
}
