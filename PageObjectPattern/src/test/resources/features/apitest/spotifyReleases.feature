# Application token is used for authorization
#
Feature: Integration tests for /v1/browse/new-releases endpoing
  
  Description: The purpose of the tests is to check GET requests to  https://api.spotify.com/ to retrieve shared data

  Background: User generates app Authorization token
    Given User has app token on spotify website

  Scenario: User sends Get request to retrieve new releases
    When User sends request to newreleases endpoint
    Then status code 200 is received
    Then Fields id, type and name are not null and present in the response
  
