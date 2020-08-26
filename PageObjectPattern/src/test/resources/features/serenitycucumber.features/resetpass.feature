Feature: Forgot password

  Scenario Outline: User retrieves password
    Given Unauthenticated User is on Home Page
    When User clicks SignIn button
    And Clicks Forgot Password Link on Login Page
    And Inputs <email> on Forgot Password Page
    And Clicks Retrieve Password button
    Then Password is retrieved and Confirmation message is received

    Examples: 
      | email                          |
      | ytestautomation@mailinator.com |
