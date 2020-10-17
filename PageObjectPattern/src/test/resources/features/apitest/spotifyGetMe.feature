#Token access is inserted manually in SpotifyApiStep
Feature: Integration tests for /me endpoint
  Description: The purpose of the tests is to check GET requests to  https://api.spotify.com/v1/me

  Background: User generates Authorization token
    Given User is authorized with manually retrieved token

  Scenario Outline: User sends GEt request to /v1/me endpoint
    When User sends Get request to me endpoint
    Then status code 200 is received
    And required fields with valid data are present in the response: <birthdate>, <country>, <email>

    Examples: 
      | birthdate  | country | email                       |
      | 1973-04-07 | PL      | yulia.borisowa.qa@gmail.com |
