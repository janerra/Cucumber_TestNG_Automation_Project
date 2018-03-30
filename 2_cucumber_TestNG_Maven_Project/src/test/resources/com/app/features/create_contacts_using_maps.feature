Feature: Creating contact

  Scenario: Create contact using a map
    Given I logged into suiteCRM
    When I create a new contact:
      | first_name   | John         |
      | last_name    | Smith        |
      | cell_phone   | 801-222-4444 |
      | office_phone | 555-555666   |
    Then I should see contact information for "John Smith"
    
 @create_contact
  Scenario Outline: Create contact using a map
    Given I logged into suiteCRM
    When I create a new contact:
      | first_name   | <first_name>   |
      | last_name    | <lname>        |
      | cell_phone   | <cell_phone>   |
      | office_phone | <office_phone> |
    Then I should see contact information for "<first_name> <lname>"

    Examples: 
      | first_name | lname   | cell_phone   | office_phone |
      | Alex       | Kotlyar | 123-123-4567 | 000-4445658  |
      | Kate       | Are     | 500-5468987  | 800-56589874 |
      | Kalle      | Nicker  | 500-2222     | 800-7777     |
