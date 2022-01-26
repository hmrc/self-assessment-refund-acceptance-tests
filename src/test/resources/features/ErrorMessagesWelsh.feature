Feature: Happy Path

  Scenario: Welsh - Refund Amount Page Errors
    Given The user starts a personal journey with Nino AA111111A

    When the User toggles on Welsh language
    And the user is on the RefundAmountPage
    And the user click continue
    And the choice required error shows
#    And the enter amount error shows
#    And the invalid amount error shows
#    And the amount of 0 error shows
#    And the exceeded maximum amount error shows



