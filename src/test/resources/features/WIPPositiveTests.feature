##WIP as new service E2E journey details yet to be finalised. Building framework.
#
# Feature: Happy Path Journeys
#
#  Scenario: Happy Path - Full Amount
#    Given The user starts a journey with Nino AA111111A
#    When the user click on the full amount .
#    And the user click continue
#
#  Scenario Outline: Happy Path - Other Amounts
#    Given The user starts a journey with Nino AA111111A
#    When the user click on the other amount <amount>
#    And the user click continue
#
#    Examples:
#      | amount |
#      | 0.01   |
#      | 545.32 |
#
#  Scenario: Happy Path - View and Change
#    Given the user go to the view change account page
#    And the user click on Claim a Refund
#    When the user click on the full amount .
#    And the user click continue
