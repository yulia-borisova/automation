#Token access is inserted manually in SpotifyApiStep
Feature: Sending Get requests to /me endpoint
  Description: The purpose of the tests is to check GET requests to  https://api.spotify.com/v1/me

  Background: User generates Authorization token
    Given User is authorized

  Scenario Outline: Authorized user is able to send  Get request
    When User sends Get request to <endpoint>
    Then Response status OK is received
    And required fields with valid data are present in the response: birthdate, country, email

    Examples: 
      | endpoint |
      | /v1/me   |
