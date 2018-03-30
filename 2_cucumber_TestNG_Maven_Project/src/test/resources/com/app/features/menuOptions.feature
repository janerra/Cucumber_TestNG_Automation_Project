Feature: SugarCRM menu options sugar

  Scenario: Verify Collaboration menu options_s
    Given I logged into suiteCRM
    When I hover over the Collaboration menu_s
    Then following menu_s options should be visible for Collaboration:
      | Home      |
      | Emails     |
      | Documents |
      | Projects  |

      @jane1
  Scenario: Verify Support menu options_s
    Given I logged into suiteCRM
    When I hover over the Support menu_s
    Then following menu_s options should be visible for Support:
      | Home      |
      | Emails     |
      | Documents |
      | Projects  |