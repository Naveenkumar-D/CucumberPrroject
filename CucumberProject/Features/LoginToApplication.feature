Feature: LoginFeature

  Scenario Outline: Login Feature successfull
    Given The user navigate to login page
    When The user enter Email address and Password by using excel "<rows>"
    Then The user click on sign in button
    And The user should be redirect to the my account page
    And the user get the title of the login page

    Examples: 
      | rows |
      |    1 |
      |    2 |
      |    3 |
      |    4 |
      |    5 |
      |    6 |
      |    7 |
      |    8 |
      |    9 |
      |   10 |
