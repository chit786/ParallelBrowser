Feature: UserFormFeature
  This feature deals with the userform functionality of the application

  @userForm
  Scenario: User Should be able to fill the Userform with correct details
    Given I am logged in to the application
      | username | password      |
      | admin    | adminpassword |
    And I should see the userform page
    And I fill following user details in the form
      | title | initial | firstName | middleName | gender | languages |
      | Mr.   | TT      | Tester    | tester     | Female | hindi     |
    And I click save button

  @userForm
  Scenario: User Should be able to fill the Userform with correct details try 2
    Given I am logged in to the application
      | username | password      |
      | admin    | adminpassword |
    And I should see the userform page
    And I fill following user details in the form
      | title | initial | firstName | middleName | gender | languages |
      | Mr.   | TT      | Tester    | tester     | Female | hindi     |
    And I click save button


  @userForm
  Scenario: User Should be able to fill the Userform with correct details try 3
    Given I am logged in to the application
      | username | password      |
      | admin    | adminpassword |
    And I should see the userform page
    And I fill following user details in the form
      | title | initial | firstName | middleName | gender | languages |
      | Mr.   | TT      | Tester    | tester     | Female | hindi     |
    And I click save button
