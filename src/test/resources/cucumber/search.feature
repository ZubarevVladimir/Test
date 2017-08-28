Feature: Search

  Background:
    Given I open yammer site in browser
    And  Sign-in with my credentials from system property

  Scenario: Follow for user
    When I search by "Maksim Zaretski" query
    And I choose user in search results
    And I follow user
    And go to the profile page
    And open following users
    Then check "Maksim Zaretski" exist in folowings
    And I unfollow user
    And close browser

  Scenario: Unfollow from user
    When I search by "Maksim Zaretski" query
    And I choose user in search results
    And I follow user
    And go to the profile page
    And open following users
    And I unfollow user
    And open following users
    Then check "Maksim Zaretski" not exist in folowings
    And close browser

  Scenario: Find group with search field
    And I search by "Wild Bamboleos" query
    Then check is search group exist in search results
    And close browser

