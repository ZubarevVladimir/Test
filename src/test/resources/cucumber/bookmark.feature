Feature: Bookmark

  Background:
    Given I open yammer site in browser
    And  Sign-in with my credentials from system property

    Scenario: Add post to bookmark
      Given I open group with "Wild Bamboleos" name
      When I try to add last post to bookmark
      And go to the profile page
      Then I check that post in my bookmarks folder
      And delete post from bookmark
      And close browser