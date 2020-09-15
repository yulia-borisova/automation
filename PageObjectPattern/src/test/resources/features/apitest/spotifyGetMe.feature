#Token access is inserted manually in SpotifyApiStep
Feature: Sending Get requests to /me endpoint
  Description: The purpose of the tests is to check GET requests to  https://api.spotify.com/v1/me

  Background: User generates Authorization token
    Given User is authorized

  Scenario Outline: Authorized user is able to send  Get request
    When User sends Get request to <endpoint>
    Then Status code OK is received as <expectedStatus>
    And all fields <requiredFields> with valid data <responseData> are present in the response

    Examples: 
      | endpoint                                      | requiredFields | responseData                | expectedStatus |
      | /v1/me                                        | email         | yulia.borisowa.qa@gmail.com |            200 |
   