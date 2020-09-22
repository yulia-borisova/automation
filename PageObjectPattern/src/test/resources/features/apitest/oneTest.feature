#Primitive scenario for creating CommonStepDeffinition Class (TestCommonStepDefinition Class)
Feature: Sending Api request

  Scenario: User is sending api call to  https://api.spotify.com/v1/browse/new-releases endpoint
    Given User has app token on spotify website
    When user sends request to new-releases endpoint
    Then status code 200 is received

