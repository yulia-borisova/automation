Feature: Api GET request to v1/browse/categories endpoint

  Background: User generates Access Token
    Given User has app token

  Scenario: User is able to send Get request to v1/browse/categories
    When User sends  valid Get request
    Then response is received
    And fields present in the response

  Scenario: User sends Get request with exceeded limit
    When Request exceeds max limit
    Then Status code400 is received

  Scenario: User with invalid sends request
    When request is sent with invalid token
    Then Status code401 is received
