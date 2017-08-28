Feature: Group

  Background:
    Given I open yammer site in browser
    And  Sign-in with my credentials from system property

  Scenario: Create new group
    When I create group with "New_group_for_check_creatingTest" name
    Then group name the similar to given string
    And I delete this group
    And close browser

  Scenario: Delete group
    When I create group with "New_group_for_check_deletingTest" name
    And I delete this group
    Then group was deleted
    And close browser


  Scenario: Join the group
    When I search by "Hakuna-Matata" query
    And open first group in the search page
    And I join this group
    Then I am group member
    And I leave this group
    And close browser


  Scenario: Leave the group
    When I search by "Hakuna-Matata" query
    And open first group in the search page
    And I join this group
    And I leave this group
    Then I am not a group member
    And close browser
