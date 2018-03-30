Feature: Note on Dashboard

Background:
Given I logged into suiteCRM

  Scenario: Post a note on Dashboard
    Given I logged into suiteCRM
    When I post "Hello Everyone!!!"
    Then Post should be displayed
    Then I logout from the application

  Scenario: Post a note on Dashboard
    Given I logged into suiteCRM
    When I post "Hello all!!!"
    Then Post should be displayed
    Then I logout from the application
