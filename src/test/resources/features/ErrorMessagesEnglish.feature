Feature: Error Messages English

  Background:
    Given The user starts a personal journey with Nino AA111111A
    When the User toggles on English language
    And the user is on the RefundAmountPage

#  REFUND AMOUNT PAGE

  Scenario: English - Refund Amount Page - No Radio button selected
    And the user click continue
    And the choice required error shows

  Scenario: English - Refund Amount Page - Other Amount, no amount entered
    And the user clicks other amount
    And the user click continue
    And the enter amount error shows

  Scenario: English - Refund Amount Page - Other Amount, invalid amount
    And the user clicks other amount
    And the user enter an amount of !123
    And the user click continue
    And the invalid amount error shows

  Scenario: English - Refund Amount Page - Other Amount, zero
    And the user clicks other amount
    And the user enter an amount of 0
    And the user click continue
    And the amount of 0 error shows

  Scenario: English - Refund Amount Page - Other Amount, More than maximum
    And the user clicks other amount
    And the user enter an amount of 123.46
    And the user click continue
    And the exceeded maximum amount error shows

#  TYPE OF ACCOUNT PAGE

#  ENTER BANK ACCOUNT DETAILS PAGE









