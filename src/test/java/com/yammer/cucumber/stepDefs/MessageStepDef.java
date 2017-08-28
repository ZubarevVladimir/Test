package com.yammer.cucumber.stepDefs;

import static org.testng.Assert.assertTrue;

import com.yammer.business.objects.Message;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MessageStepDef extends AbstractStepDef {

  @Given("^I open inbox page$")
  public void iOpenInboxPage() throws Throwable {
    messageSteps.openInboxPage();
  }

  @When("^I try to send private message \"([^\"]*)\" to \"([^\"]*)\"$")
  public void iTryToSendPrivateMessageTo(String messageBody, String participant) throws Throwable {
    super.getUser().setMessage(new Message(participant, messageBody));
    messageSteps.sendNewPrivateMessage(super.getUser().getMessage());
  }

  @Then("^I should see that message was sent$")
  public void iShouldSeeThatMessageToWasSent()
      throws Throwable {
    assertTrue(messageSteps.checkSentMessage(super.getUser().getMessage()));
  }
}
