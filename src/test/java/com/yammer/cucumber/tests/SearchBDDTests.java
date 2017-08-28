package com.yammer.cucumber.tests;

import com.yammer.cucumber.stepDefs.AbstractStepDef;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(features = "src/test/resources/cucumber/search.feature",
    glue = {"com.yammer.cucumber.stepDefs"})
public class SearchBDDTests extends AbstractTestNGCucumberTests {

  @BeforeMethod
  public void setUp(){
    new AbstractStepDef();
  }
}