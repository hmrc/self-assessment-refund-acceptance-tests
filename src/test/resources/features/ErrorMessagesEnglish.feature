Feature: Error Messages English

  Background:
    Given The user starts a personal journey with Nino AB111111D
    When the User toggles on English language
    And the user is on the RefundAmountPage
    And the user signs out

#  REFUND AMOUNT PAGE

  Scenario: English - Refund Amount Page - No Radio button selected
    And the user click continue
    And the choice required error shows
    And the user signs out

  Scenario Outline: English - Refund Amount Page - Other Amount Value Errors
    And the user clicks other amount
    And the user enter an amount of <amount>
    And the user click continue
    And the <errorType> error shows
    And the user signs out

    Examples:
      | errorType               | amount |
      | enter amount            |        |
      | invalid amount          | !123   |
      | amount of 0             | 0      |
      | negative number         | -123   |
      | exceeded maximum amount | 123.46 |

#  TYPE OF ACCOUNT PAGE

  Scenario: English - Type of Account Page - None Selected
    And the user clicks other amount
    And the user enter an amount of 1
    And the user click continue
    And the user click continue
    And the no type of account selected error is displayed
    And the user signs out

#  ENTER BANK ACCOUNT DETAILS PAGE

  Scenario Outline: English - Enter Bank Details Page - Error Scenarios
    And the user clicks other amount
    And the user enter an amount of 1
    And the user click continue
    When the User toggles on <lang> language
    And the user select personal account
    And the user click continue
    When the user enters <input value> into the <field> field
    And the user click continue
    Then the <field> field should display "<message>"
    And the user signs out

    Examples:
      | lang    | input value                                                   | field          | message                                                                                              |
      | English | none                                                          | Account Name   | Enter the name on the account                                                                        |
      | English | Test?                                                         | Account Name   | Enter the name on the account                                                                        |
      | English | _Test                                                         | Account Name   | Enter the name on the account                                                                        |
      | English | TestTestTestTestTestTestTestTestTestTestTestTestTestTestTest1 | Account Name   | Name on the account must be 60 characters or less                                                    |
      | English | none                                                          | Sortcode       | Enter sort code                                                                                      |
      | English | 00.00.00                                                      | Sortcode       | Sort code must be 6 digits                                                                           |
      | English | 00000                                                         | Sortcode       | Sort code must be 6 digits                                                                           |
      | English | 0000000                                                       | Sortcode       | Sort code must be 6 digits                                                                           |
      | English | 000000words                                                   | Sortcode       | Sort code must be 6 digits                                                                           |
      | English | 000000?                                                       | Sortcode       | Sort code must be 6 digits                                                                           |
      | English | none                                                          | Account Number | Enter account number                                                                                 |
      | English | 52173                                                         | Account Number | Account number must be between 6 and 8 digits                                                        |
      | English | 521733!                                                       | Account Number | Account number must be between 6 and 8 digits                                                        |
      | English | 521733-1                                                      | Account Number | Account number must be between 6 and 8 digits                                                        |
      | English | 521730181                                                     | Account Number | Account number must be between 6 and 8 digits                                                        |
      | English | 521738wo                                                      | Account Number | Account number must be between 6 and 8 digits                                                        |
      | English | none                                                          | Roll Number    | Building society roll number must be entered if you have one. It may also be called a reference code |
      | English | 12345678901                                                   | Roll Number    | Roll number must be between 1 and 10 characters                                                      |
      | English | 12345678@                                                     | Roll Number    | Roll number must only contain letters and numbers                                                    |
