package com.yammer.cucumber.stepDefs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import com.yammer.business.objects.Comment;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommentStepDef extends AbstractStepDef{

  @When("^I create comment with \"([^\"]*)\" text$")
  public void iCreateComment(String commentText){
    super.getUser().setComment(new Comment(commentText));
    commentSteps.createComment(super.getUser().getComment());
  }

  @And("^I delete last comment$")
  public void iDeleteLastComment(){
    commentSteps.deleteLastComment();
  }


  @Then("^comment body the similar to given string$")
  public void commentBodyTheSimilarToGiven(){
    assertEquals(commentSteps.getLastCommentText(), super.getUser().getComment().getBody());
  }

  @Then("^comment body not similar to given string$")
  public void commentBodyNotSimilarToGiven(){
    assertNotEquals(commentSteps.getLastCommentText(), super.getUser().getComment().getBody());
  }
}
