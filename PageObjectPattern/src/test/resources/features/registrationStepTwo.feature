Feature: Filling Registration Form

  Scenario Outline: New User is filling a Registration Form
    Given User is on SignIn Form Page
    When User inputs <firstName>, <lastName>, <password>, <day>,<month>, <year>,<address>, <city>, <state>, <code>, <phone>, <alias>
    And Clicks Register button
    Then User is navigated to My Account Page

    Examples: 
      | firstName  | lastName      | password | day | month | year | address         | city     | state | code  | phone       | alias |
      | FNcucumber | LNCucumberoff | Test1234 |  10 |    10 | 2000 | Cucumber Street | New York | NY    | 10009 | 12312312312 | alias |
