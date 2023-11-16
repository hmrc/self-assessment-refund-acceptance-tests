Feature: Error Messages Welsh

  Background:
    Given The user starts a personal journey with Nino AB111111D
    When the User toggles on Welsh language
    And the user is on the RefundAmountPage

#  REFUND AMOUNT PAGE

  Scenario: Welsh - Refund Amount Page - No Radio button selected
    And the user click continue
    And the choice required error shows
    When the User toggles on English language

  Scenario Outline: Welsh - Refund Amount Page - Other Amount Value Errors
    And the user clicks other amount
    And the user enter an amount of <amount>
    And the user click continue
    And the <errorType> error shows
    When the User toggles on English language

    Examples:
      | errorType               | amount |
      | enter amount            |        |
      | invalid amount          | !123   |
      | amount of 0             | 0      |
      | negative number         | -123   |
      | exceeded maximum amount | 123.46 |

#  TYPE OF ACCOUNT PAGE

  Scenario: Welsh - Type of Account Page - None Selected
    And the user clicks other amount
    And the user enter an amount of 1
    And the user click continue
    And the user click continue
    And the no type of account selected error is displayed
    When the User toggles on English language

#  ENTER BANK ACCOUNT DETAILS PAGE

  Scenario Outline: Welsh - Enter Bank Details Page - Error Scenarios
    And the user clicks other amount
    And the user enter an amount of 1
    And the user click continue
    When the User toggles on <lang> language
    And the user select personal account
    And the user click continue
    When the user enters <input value> into the <field> field
    And the user click continue
    Then the <field> field should display "<message>"
    When the User toggles on English language

    Examples:
      | lang  | input value                                                   | field          | message                                                             |
      | Welsh | none                                                          | Account Name   | Nodwch yr enw sydd ar y cyfrif                                      |
      | Welsh | Test?                                                         | Account Name   | Nodwch yr enw sydd ar y cyfrif                                      |
      | Welsh | _Test                                                         | Account Name   | Nodwch yr enw sydd ar y cyfrif                                      |
      | Welsh | TestTestTestTestTestTestTestTestTestTestTestTestTestTestTest1 | Account Name   | Mae'n rhaid i'r enw sydd ar y cyfrif fod yn 60 o gymeriadau neu lai |
      | Welsh | none                                                          | Sortcode       | Nodwch god didoli                                                   |
      | Welsh | 00.00.00                                                      | Sortcode       | Mae'n rhaid i'r cod didoli fod yn 6 digid                           |
      | Welsh | 00000                                                         | Sortcode       | Mae'n rhaid i'r cod didoli fod yn 6 digid                           |
      | Welsh | 0000000                                                       | Sortcode       | Mae'n rhaid i'r cod didoli fod yn 6 digid                           |
      | Welsh | 000000words                                                   | Sortcode       | Mae'n rhaid i'r cod didoli fod yn 6 digid                           |
      | Welsh | 000000?                                                       | Sortcode       | Mae'n rhaid i'r cod didoli fod yn 6 digid                           |
      | Welsh | none                                                          | Account Number | Nodwch rif y cyfrif                                                 |
      | Welsh | 52173                                                         | Account Number | Mae'n rhaid i rif y cyfrif fod rhwng 6 ac 8 digid                   |
      | Welsh | 521733!                                                       | Account Number | Mae'n rhaid i rif y cyfrif fod rhwng 6 ac 8 digid                   |
      | Welsh | 521733-1                                                      | Account Number | Mae'n rhaid i rif y cyfrif fod rhwng 6 ac 8 digid                   |
      | Welsh | 521730181                                                     | Account Number | Mae'n rhaid i rif y cyfrif fod rhwng 6 ac 8 digid                   |
      | Welsh | 521738wo                                                      | Account Number | Mae'n rhaid i rif y cyfrif fod rhwng 6 ac 8 digid                   |
#      | Welsh | none                                                          | Roll Number    | TBC                                                        |
#      | Welsh | 12345678901                                                   | Roll Number    | TBC                                                                     |
