Feature: Creating contacts
@cont
  Scenario: Create contact using CREATE page
    Given I logged into suiteCRM
    And I open the create contact page
    And I enter the first name "Alex" and the last name "Kotlyar"
    And I enter the phone number "201-000-0000"
    And I enter the department "IT"
    When click on the save button
    Then I should see contact information for "Alex Kotlyar"

 
  Scenario Outline: Create multiple contacts
    Given I logged into suiteCRM
    And I open the create contact page
    And I enter the first name "<firstname>" and the last name "<lastname>"
    And I enter the phone number "<phonenumber>"
    And I enter the department "<department>"
    When click on the save button
    Then I should see contact information for "<firstname> <lastname>"
   
    Examples: 
      | firstname | lastname | phonenumber | department |
      | Satoshi   | Nakamuro |  9878754512 | IT         |
      | Jenny     | Emmy     | 21321346546 | IT         |
      | Rajesh    | Trewedy  |   465465897 | IT         |
