Feature: User Registration
  I want to check that the user can register in our e-commerce website.

  Scenario Outline: User Registration
    Given  the user in the home page
    When user clicks on register button
    And I entered "<firstname>","<lastname>","<email>","<pass>"
    Then the registration page is displayed successfully
    Examples:
      |firstname  | lastname | email | pass |
      | ali       | ahmed    |ali3@ahmed.com| 123456789|
      | amira     | galal    |amira@galal.com|123456789|


