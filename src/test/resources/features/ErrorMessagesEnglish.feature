Feature: Error Messages English

  Background:
    Given The user starts a personal journey with Nino AC111111A
    When the User toggles on English language
    And the user is on the RefundAmountPage

#  REFUND AMOUNT PAGE

  Scenario: English - Refund Amount Page - No Radio button selected
    And the user click continue
    And the choice required error shows

  Scenario Outline: English - Refund Amount Page - Other Amount Value Errors
    And the user clicks other amount
    And the user enter an amount of <amount>
    And the user click continue
    And the <errorType> error shows

    Examples:
      | errorType               | amount |
      | enter amount            |        |
      | invalid amount          | !123   |
      | amount of 0             | 0      |
      | exceeded maximum amount | 123.46 |

#  TYPE OF ACCOUNT PAGE

  Scenario: English - Type of Account Page - None Selected
    And the user clicks other amount
    And the user enter an amount of 1
    And the user click continue
    And the user click continue
    And the no type of account selected error is displayed

#  ENTER BANK ACCOUNT DETAILS PAGE

  Scenario Outline: English - Enter Bank Details Page - Error Scenarios
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