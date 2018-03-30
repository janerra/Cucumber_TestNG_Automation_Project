Feature: Contact details

  Agile story:
  As a user, I should be able to access the 
  contact's user personal information, 
  so that I have detailed information about that person

 
Scenario: Title of your scenario
Given I logged into suiteCRM
When I search for "John Doe"
Then link for user "John Doe" should be displayed
And I open contact "John Doe"
Then contact name should be "John Doe"
And contact email should be "johnDoe@example.org"