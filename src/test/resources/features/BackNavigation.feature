Feature: Navigation tests

#    REFUND REQUEST JOURNEY

  Scenario Outline: Back Navigation - Refund Journey (Card on File)
    Given The user starts a <type> journey with Nino AB111111C
    And the user is on the RefundAmountPage
    And the user click on the full amount .
    And the user click continue
    And the user click back
    And the user is on the RefundAmountPage
    And the user click continue
    And the user is on the AccountOnFilePage
    And the user click continue
    And the user click back
    And the user is on the AccountOnFilePage
    And the user click continue
    And the user is on the TypeOfAccountPage
    And the user select <type> account
    And the user click continue
    And the user click back
    And the user is on the TypeOfAccountPage
    And the user click continue
    And the user is on the EnterBankDetailsPage
    And the user enter valid <type> bank details with roll number
    And the user click continue
    And the user click back
    And the user is on the EnterBankDetailsPage
    And the user click continue
    And the user is on the CheckDetailsPage
    And the user clicks on changeBank link
    And the user is on the EnterBankDetailsPage
    And the user click back
    And the user is on the TypeOfAccountPage
    And the user signs out

    Examples:
      | type     |
      | personal |
      | business |

  Scenario: Back Navigation - No Card on File
    Given The user starts a personal journey with Nino AB111111D
    And the user click on the full amount .
    And the user click continue
    And the user is on the TypeOfAccountPage
    And the user click back
    And the user is on the RefundAmountPage
    And the user signs out

  Scenario: Back Navigation - Refund Journey back to Itsa Viewer
    Given The user starts a <type> journey with Nino AB111111C
    And the user is on the RefundAmountPage
    And the user click back
    And the user is on the ItsaViewerPage
    And the user clicks browser back
    And the user signs out

  Scenario: Back Navigation - Refund Journey - Language change and back button behaviour
    Given The user starts a personal journey with Nino AB111111C
    When the User toggles on English language
    And the user is on the RefundAmountPage
    And the user click on the full amount .
    And the user click continue
    When the User toggles on Welsh language
    And the user click back
    And the user is on the RefundAmountPage
    When the User toggles on English language
    And the user click continue
    And the user is on the AccountOnFilePage
    And the user click continue
    When the User toggles on Welsh language
    And the user click back
    And the user is on the AccountOnFilePage
    And the user click continue
    And the user is on the TypeOfAccountPage
    And the user select personal account
    And the user click continue
    When the User toggles on English language
    And the user click back
    And the user is on the TypeOfAccountPage
    And the user click continue
    And the user is on the EnterBankDetailsPage
    And the user enter valid personal bank details with roll number
    And the user click continue
    When the User toggles on Welsh language
    And the user click back
    And the user is on the EnterBankDetailsPage
    And the user click continue
    And the user is on the CheckDetailsPage
    When the User toggles on English language
    And the user signs out


  Scenario: Back Navigation - Refund Journey - Error Page and back button behaviour
    Given The user starts a personal journey with Nino AB111111C
    And the user is on the RefundAmountPage
    And the user click on the full amount .
    And the user click continue
    And the user is on the AccountOnFilePage
    And the user click continue
    And the user is on the TypeOfAccountPage
    And the user click continue
    And the user click back
    And the user is on the AccountOnFilePage
    And the user click continue
    And the user select personal account
    And the user click continue
    And the user is on the EnterBankDetailsPage
    And the user click continue
    Then the No details entered field should display "the correct error message"
    And the user click back
    And the user is on the TypeOfAccountPage
    And the user click continue
    And the user is on the EnterBankDetailsPage
    And the user signs out

  Scenario: Back Navigation - Refund Journey - Error Page and back button behaviour back to Itsa Viewer
    Given The user starts a personal journey with Nino AB111111C
    And the user is on the RefundAmountPage
    And the user click continue
    And the user click back
    And the user is on the ItsaViewerPage
    And the user clicks browser back
    And the user signs out


#    REFUND HISTORY JOURNEY

  Scenario: Back Navigation - Refund History
    Given The user starts a history journey for AB111111C
    When the User toggles on English language
    And the user is on the RefundHistoryPage
    And the user clicks on Processing for result number 1
    And the user is on the StatusProcessingPage
    And the user click back
    And the user is on the RefundHistoryPage
    And the user clicks on Approved for result number 2
    And the user is on the StatusApprovedPage
    And the user click back
    And the user is on the RefundHistoryPage
    And the user clicks on the History tab
    And the user clicks on Paid for result number 1
    And the user is on the StatusPaidPage
    And the user click back
    And the user is on the RefundHistoryPage
    And the user clicks on Rejected for result number 2
    And the user is on the StatusRejectedPage
    And the user signs out

  Scenario: Back Navigation - Refund History back to Itsa Viewer
    Given The user starts a history journey for AB111111C
    And the user is on the RefundHistoryPage
    And the user click back
    And the user is on the ItsaViewerPage
    And the user clicks browser back
    And the user signs out