Feature: Comment

  Scenario: Add comment for last post
    Given I open yammer site in browser
    And  Sign-in with my credentials from system property
    And I open group with "Wild Bamboleos" name
    When I create post with "CreateComment" text
    And I create comment with "CreateComment" text
    Then comment body the similar to given string
    And I delete last comment
    And I delete last post
    And close browser

  Scenario: Delete comment from last post
    Given I open yammer site in browser
    And  Sign-in with my credentials from system property
    And I open group with "Wild Bamboleos" name
    When I create post with "DeleteComment" text
    And I create comment with "DeleteComment" text
    And I delete last comment
    Then comment body not similar to given string
    And I delete last post
    And close browser
