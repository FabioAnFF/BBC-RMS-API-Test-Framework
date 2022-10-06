Feature: Test to ensure BBC RMS API Health

  #Scenario 1
  Scenario: Check API status code and response time
    When a GET request is made to ottplatform media api endpoint
    Then response code should be 200
    And response time should be less than 1000 ms