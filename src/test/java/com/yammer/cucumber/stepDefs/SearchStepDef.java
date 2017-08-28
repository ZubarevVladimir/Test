package com.yammer.cucumber.stepDefs;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SearchStepDef extends AbstractStepDef{

  @And("^I search by \"([^\"]*)\" query$")
  public void iSearchByQuery(String searchQuery){
    super.getUser().setSearchQuery(searchQuery);
    searchSteps.search(super.getUser().getSearchQuery());
  }

  @Then("^check is search group exist in search results$")
  public void searchedGroupExistInResults(){
    searchSteps.openGroupsFolder();
    assertTrue(searchSteps.checkGroupInResult(super.getUser().getSearchQuery()));
  }

  @And("^I choose user in search results$")
  public void chooseUserInResults(){
    searchSteps.chooseUser();
  }

  @And("^open first group in the search page$")
  public void openFirstGroupInTheSearchPage() throws Throwable {
    searchSteps.openGroupsFolder();
    searchSteps.openGroup();
  }
}
