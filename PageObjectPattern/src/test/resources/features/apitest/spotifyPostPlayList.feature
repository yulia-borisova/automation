#access token is generated manually
Feature: Integration tests for /v1/users/{user_id}/playlists endpoint
  Description: The purpose of the test is to check POST requests with valid data

  Background: User generates Auth token
    Given User is authorized with manually retrieved token

  Scenario Outline: User sends POST request to create a new PlayList
    When post request is sent to playList endpoint with user id <id> and name <playListName>
    Then status code 201 is received
    And field name is not empty in the response
    And new <playListName> name and required fields are present in the response: <id>, <limit>, <display_name>

    Examples: 
      | playListName | id                        | limit | display_name |
      | test14       | czc11mg48dvwd16aeq0jofr3j |   100 | Yulia        |
