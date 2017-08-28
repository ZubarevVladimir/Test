Feature: Post

  Background:
    Given I open yammer site in browser
    And  Sign-in with my credentials from system property

  Scenario: Share post
    When I open group with "Wild Bamboleos" name
    And I try to share last post to "WB Group" group
    And I open group with "WB Group" name
    Then The post is presented in group
    And I delete last post
    And close browser


  Scenario: Create post
    When I open group with "Wild Bamboleos" name
    And I create post with "Test create post" text
    Then Last post text the similar to "Test create post"
    And I delete last post
    And close browser


  Scenario: Delete post
    When I open group with "Wild Bamboleos" name
    And I create post with "Test delete post" text
    And I delete last post
    Then Last post text not similar to "Test delete post"
    And close browser
