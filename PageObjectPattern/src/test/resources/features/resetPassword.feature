Feature: Password Reset

  Scenario Outline: Registered User resets a password
    Given User is on Home page
    When User clicks Sign-in button
    And User clicks Forgot your passoword link
    And User inputs <email>
    And User clicks Retrieve password
    Then User gets a confirmation message

    Examples: 
      | email                          |
      | ytestautomation@mailinator.com |
