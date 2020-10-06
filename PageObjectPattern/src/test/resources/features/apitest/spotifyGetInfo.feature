# Application token is used for authorization
#
Feature: Getting  Information by sending API call
  
  Description: The purpose of the tests is to check GET requests to  https://api.spotify.com/ to retrieve shared data

  Background: User generates app Authorization token
    Given User has app token on spotify website

  Scenario Outline: User sends Get request to retrieve new releases
    When User sends request to newreleases endpoint
    Then status code 200 is received
    And all required fields are present: <albumId> <albumType> <name>

    Examples: 
      | albumId                | albumType | name      |
      | 41MozSoPIsD1dJM0CLPjZF | album     | BLACKPINK |
