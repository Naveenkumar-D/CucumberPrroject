Feature: SignIn feature

  Scenario: Sign in Succussfully
    Given The user navigate to sign in page
    When The User enter email address
    Then The user click on create an account button
    And The user click on Gender
    And The user enter details into bellow feilds
      | firstName | Jhon     |
      | lastName  | David    |
      | password  | test@123 |
    And The user click on Register button
    And the user get the title of the SignIn page
