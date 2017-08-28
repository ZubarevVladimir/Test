Feature: Message

  Background:
    Given I open yammer site in browser
    And  Sign-in with my credentials from system property

  Scenario: Send private message
    Given I open inbox page
    When I try to send private message "TestMessage" to "Maksim Zaretski"
    Then I should see that message was sent
    And close browser
