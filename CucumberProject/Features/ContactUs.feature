Feature: Contact Us Feature

  Scenario Outline: Contact Us Feature succusfull
    Given The user navigate to contactus page
    When The user enter Subject Heading, Email address, Order reference and Message by using excel "<rows>"
    Then The user click on send button
    And The user get the conformation message

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
