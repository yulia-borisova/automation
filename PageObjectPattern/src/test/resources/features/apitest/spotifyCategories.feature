Feature: Integration tests for v1/browse/categories endpoint

  Background: User generates Access Token
    Given User has app token on spotify website

  Scenario: User sends Get request to v1/browse/categories
    When User sends Get request to Categoires endpoint
    Then status code 200 is received
    And field total with not null value is present in the response

  Scenario: User sends Get request to v1/browse/categories with exceeded limit
    When Request equals or exceeds max limit 100
    Then status code 400 is received

  Scenario: User sends Get request to v1/browse/categories with invalid token
  When app access token gets expired
    And User sends Get request with invalid token to retrieve categories
    Then status code 401 is received
