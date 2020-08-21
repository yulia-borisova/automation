@smoketest
Feature: New User Registration

  Scenario Outline: User creates a new account
    Given New User is on Home Page
    And Clicks SignIn
    When New User Inputs <email>
    And Clicks Create an Account
    Then User is redirected to SignIn Form Page

    Examples: 
      | email                        |
      | newuser120935@mailinator.com |
