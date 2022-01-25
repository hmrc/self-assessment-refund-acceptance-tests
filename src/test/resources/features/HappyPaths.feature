Feature: Happy Path

  @a11y
  Scenario Outline: V&C with card on file
    Given The user starts a <type> journey with Nino AC111111A
    And the user is on the RefundAmountPage
    And the user click on the <amount> amount <value>
    And the user click continue
    And the user is on the AccountOnFilePage
    And the user click continue
    And the user is on the TypeOfAccountPage
    And the user select <type> account
    And the user click continue
    And the user is on the EnterBankDetailsPage
    And the user enter valid <type> bank details
    And the user click continue
    And the user is on the CheckDetailsPage
    And the user click continue
    And the user is on the RequestReceivedPage

    Examples:
      | type     | amount | value |
      | personal | full   | N/A   |
#      | personal | other  | 50.00    |
#      | business | full   | N/A   |
#      | business | other  | 50.00    |


  Scenario Outline: V&C with no card on file, enter bank details
    Given The user starts a <type> journey with Nino AA111111A
    And the user is on the RefundAmountPage
    And the user click on the <amount> amount <value>
    And the user click continue
    And the user is on the TypeOfAccountPage
    And the user select <type> account
    And the user click continue
    And the user is on the EnterBankDetailsPage
    And the user enter valid <type> bank details
    And the user click continue
    And the user is on the CheckDetailsPage
    And the user click continue
    And the user is on the RequestReceivedPage

    Examples:
      | type     | amount | value |
      | personal | full   | N/A   |
#      | personal | other  | 50.00    |
#      | business | full   | N/A   |
#      | business | other  | 50.00    |


  @a11y
  Scenario: Refund History
    Given The user begins their personal journey with RefundHistoryPage
    And the user is on the RefundHistoryPage
    And the user clicks on View Progress for result number 1
    And the user is on the StatusPendingPage
    And the user click back
    And the user clicks on the Completed tab
    And the user clicks on Completed for result number 1
    And the user is on the StatusCompletedPage
    And the user click back
    And the user clicks on Rejected for result number 3
    And the user is on the StatusRejectedPage
