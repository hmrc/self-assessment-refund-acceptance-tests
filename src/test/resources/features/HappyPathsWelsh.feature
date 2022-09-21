Feature: Happy Path - Welsh

  Scenario Outline: Welsh - V&C with card on file
    Given The user starts a <type> journey with Nino AB111111C
    When the User toggles on Welsh language
    And the user is on the RefundAmountPage
    And the user click on the <amount> amount <value>
    And the user click continue
    And the user is on the AccountOnFilePage
    And the user click continue
    And the user is on the TypeOfAccountPage
    And the user select <type> account
    And the user click continue
    And the user is on the EnterBankDetailsPage
    And the user enter valid <type> bank details with roll number
    And the user click continue
    And the user is on the CheckDetailsPage
    And the user click continue
    And the user click continue
    And the user is on the RequestReceivedPage
    When the User toggles on English language

    Examples:
      | type     | amount | value |
      | personal | other  | 50.00 |
      | business | full   | N/A   |


  Scenario Outline: Welsh - V&C with no card on file, bypass Account on File Page
  
    Given The user starts a <type> journey with Nino AB111111D
    When the User toggles on Welsh language
    And the user is on the RefundAmountPage
    And the user click on the <amount> amount <value>
    And the user click continue
    And the user is on the TypeOfAccountPage
    When the User toggles on English language

    Examples:
      | type     | amount | value |
      | personal | full   | N/A   |


  Scenario: Welsh - Refund History
    Given The user starts a history journey for AB111111C
    When the User toggles on Welsh language
    And the user is on the RefundHistoryPage
    And the user clicks on Processing for result number 1
    And the user is on the StatusProcessingPage
    And the user click back
    And the user clicks on Approved for result number 2
    And the user is on the StatusApprovedPage
    And the user click back
    And the user clicks on the History tab
    And the user clicks on Paid for result number 1
    And the user is on the StatusPaidPage
    And the user click back
    And the user clicks on Rejected for result number 2
    And the user is on the StatusRejectedPage
    When the User toggles on English language
