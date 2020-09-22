# Application token is used for authorization
#
Feature: Getting  Information by sending API call
  
  Description: The purpose of the tests is to check GET requests to  https://api.spotify.com/ to retrieve shared data

  Background: User generates app Authorization token
    Given User has app access token

  Scenario Outline: User sends Get request to retrieve shared info
    When User sends request to <endpoint>
    Then response 200Ok is received
    And all required fields are present: artist.id, album type,name

    Examples: 
      | endpoint                |
      | /v1/browse/new-releases |
