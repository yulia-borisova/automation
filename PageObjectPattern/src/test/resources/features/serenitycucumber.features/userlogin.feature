@chrome
Feature: User Login

  Scenario Outline: User is able to login with valid credentials
    Given Unauthenticated User is on Login Page
    When User inserts <login> , <password>
    And Clicks Login button
    Then User gets logged in

    Examples: 
      | login                          | password |
      | ytestautomation@mailinator.com | Test1234 |
