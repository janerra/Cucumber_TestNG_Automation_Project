Feature: Creating contacts


  Scenario: Create contact
    Given I logged into suiteCRM
    When I save a new contact with been class:
      | firstName | lastName | department | officePhone | cellPhone | email           |
      | Steve     | Gates    | IT         |    51455556 | 456465464 | gates@apple.com |
    Then I should see contact information for "Steve Gates"

 @create_contact
  Scenario Outline: Create way more contacts
    Given I logged into suiteCRM
    When I save a new contact with been class:
      | firstName   | lastName   | department   | officePhone   | cellPhone   | email   |
      | <firstName> | <lastName> | <department> | <officePhone> | <cellPhone> | <email> |
    Then I should see contact information for "<firstName> <lastName>"

    Examples: 
      | firstName | lastName | department | officePhone | cellPhone | email             |
      | Admiral   | Kunkka   | navy       |     1111111 |   2222222 | admiral@valve.com |
      | John      | Smith    | IT         |     3333333 |   4444444 | john@valve.com    |
