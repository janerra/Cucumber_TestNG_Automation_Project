Feature: SugarCRM menu options sugar
@jane
  Scenario: Verify Collaboration menu options_s
    Given I logged into suiteCRM
    When I hover over the Collaboration menu_s
    Then following menu_s options should be visible for Collaboration:
      | Home      |
      | Emals     |
      | Documents |
      | Projects  |
