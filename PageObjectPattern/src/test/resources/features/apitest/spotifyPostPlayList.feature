#access token is generated manually
Feature: Sending POST requests
  Description: The purpose of the test is to check POST requests with valid data

  Background: User generates Auth token
    Given User has Auth token

  Scenario Outline: User sends POST request to create a new PlayList
    When post request is sent to <endpoint> with <playListName>
    Then response with <expectedResult> is received
    And new <playListName> name and all required fields are present in the response: id, limit, display_name

    Examples: 
      | endpoint                                      | expectedResult | playListName |
      | /v1/users/czc11mg48dvwd16aeq0jofr3j/playlists |            201 | Hurra        |
