# Application token is used for authorization
Feature: Getting  Information by sending API call
  
  Description: The purpose of the tests is to check GET requests to  https://api.spotify.com/ to retrieve shared data

  Background: User generates app Authorization token
    Given User has app access token

  Scenario Outline: User sends Get request to retrieve shared info
    When User sends request to <endpoint>
    Then <status> code is received
    And all required fields <requiredFields> are present

    Examples: 
      | endpoint                | status | requiredFields |
      | /v1/browse/new-releases |    200 | id             |
      | /v1/browse/categories    |    200 | id             |
