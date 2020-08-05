#Author: Yulia
Feature: User Login
  As a User I am able to login to a website with valid credentials

  Scenario Outline: User login with valid credentials
    Given User is on login page
    When User inputs valid <email> and <password>
    And clicks Login button
    Then User is navigated to My Account page

    Examples: 
      | email                             | password |
      | 123ytestautomation@mailinator.com | Test1234 |
      | 511ytestautomation@mailinator.com | Test1234 |
