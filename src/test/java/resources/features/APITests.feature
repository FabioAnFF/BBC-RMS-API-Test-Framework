Feature: Tests to verify data from the BBC RMS API

  #Scenario 2
  Scenario: Verify Id field and segment_type for each item
    When a GET request is made to ottplatform media api endpoint
    Then id field for every track has a value
    And segment_type is "music" for every track

  #Scenario 3
  Scenario: Verify that "primary" field in "title_list" exists
    When a GET request is made to ottplatform media api endpoint
    Then primary field in title_list of each track should have a value

  #Scenario 4
  Scenario: Verify that only one track is currently playing
    When a GET request is made to ottplatform media api endpoint
    Then only one track should have the now_playing field set to true

  #Scenario 5
  Scenario: Verify that Date value in response headers is valid
    When a GET request is made to ottplatform media api endpoint
    Then Date exists in response headers
    And Date response header value is not empty

#  # Part 2 - Scenario 1
#  Scenario: Verify that response returned from API call is in JSON to ensure parsing of response is simpl
#    When a GET request is made to ottplatform media api endpoint
#    Then response content-type should be "application/json"
#
#  # Part 2 - Scenario 2
#  Scenario: Verify that each track's end offset is greater than its start offset
#    When a GET request is made to ottplatform media api endpoint
#    Then each track's end offset is greater than its start offset
#
#  # Part 2 - Scenario 3
#  Scenario: Verify that each track's Id is unique
#    When a GET request is made to ottplatform media api endpoint
#    Then each track should have a unique Id