Feature: Error Messages Welsh

  Background:
    Given The user starts a personal journey with Nino AC111111A
    When the User toggles on Welsh language
    And the user is on the RefundAmountPage

#  REFUND AMOUNT PAGE

  Scenario: Welsh - Refund Amount Page - No Radio button selected
    And the user click continue
    And the choice required error shows

  Scenario: Welsh - Refund Amount Page - Other Amount, no amount entered
    And the user clicks other amount
    And the user click continue
    And the enter amount error shows

  Scenario: Welsh - Refund Amount Page - Other Amount, invalid amount
    And the user clicks other amount
    And the user enter an amount of !123
    And the user click continue
    And the invalid amount error shows

  Scenario: Welsh - Refund Amount Page - Other Amount, zero
    And the user clicks other amount
    And the user enter an amount of 0
    And the user click continue
    And the amount of 0 error shows

  Scenario: Welsh - Refund Amount Page - Other Amount, More than maximum
    And the user clicks other amount
    And the user enter an amount of 123.46
    And the user click continue
    And the exceeded maximum amount error shows

#  TYPE OF ACCOUNT PAGE

  Scenario: Welsh - Type of Account Page - None Selected
    And the user clicks other amount
    And the user enter an amount of 1
    And the user click continue
    And the user click continue
    And the no type of account selected error is displayed

#  ENTER BANK ACCOUNT DETAILS PAGE

  Scenario Outline: Welsh - Enter Bank Details Page - Error Scenarios
    And the user clicks other amount
    And the user enter an amount of 1
    And the user click continue
    And the user select personal account
    And the user click continue
    And the user enters <error> <value> and the correct error message is shown

    Examples:
      | error                    | value     |
      | no details entered       | N/A       |
      | invalid sortcode         | 12345!    |
      | invalid account number   | 1234567!  |
      | account number too short | 12345     |
      | account number too long  | 123456789 |