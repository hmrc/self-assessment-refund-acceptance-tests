##WIP as new service E2E journey details yet to be finalised. Building framework.
#
#Feature: Error Message Scenarios
#
#  Scenario: Error Scenario - No selection on Select Amount Page
#    Given The user starts a journey with Nino AA111111A
#    And the user click continue
#    Then the choice required error shows
#
#  Scenario: Error Scenario - no amount entered on Select Amount Page
#    Given The user starts a journey with Nino AA111111A
#    And the user click on the other amount .
#    And the user click continue
#    Then the enter amount error shows
#
#  Scenario: Error Scenario - 0 in Other Amount
#    Given The user starts a journey with Nino AA111111A
#    When the user click on the other amount 0
#    And the user click continue
#    Then the invalid amount error shows
#
#  Scenario: Error Scenario - Over fullAmount in Other Amount
#    Given The user starts a journey with Nino AA111111A
#    When the user click on the other amount 123.46
#    And the user click continue
#    Then the invalid amount error shows
