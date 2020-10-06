Feature: Api GET request to v1/browse/categories endpoint

  Background: User generates Access Token
    Given User has app token

  Scenario: User is able to send Get request to v1/browse/categories
    When User sends  valid Get request
    Then status code 200 is received
    And field total with not null value is present in the response

  Scenario: User sends Get request with exceeded limit
    When Request equal or exceeds max limit 100
    Then status code 400 is received

  Scenario: User with invalid token sends request
    When request is sent with invalid token
    Then status code 401 is received
