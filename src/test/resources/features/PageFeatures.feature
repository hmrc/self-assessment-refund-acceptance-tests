@test
Feature: Page Features

  Scenario: User selects Welsh toggle
    Given The Individual user starts a refund journey with Nino AB200111C, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user clicks Cymraeg
    Then the user is on the RefundAmountPage in Welsh

  Scenario: User signs out
    Given The Individual user starts a refund journey with Nino AB200111C, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user clicks sign out
    Then the user is on the LoggedOutPage

  Scenario Outline: User clicks back link on first page
    Given The Individual user starts a refund journey with Nino AB200111C, confidence 250, and urls <URL>
    Then the user is on the RefundAmountPage
    When the user clicks back
    Then the user is on the <page>
    Examples:
      | URL          | page        |
      | provided     | BackUrlPage |
      | not provided | V&CPage     |

  Scenario Outline: User clicks return link on confirmation page
    Given The Individual user starts a refund journey with Nino AB200111D, confidence 250, and urls <URL>
    Then the user is on the RefundAmountPage
    When the user selects a different amount and clicks continue
    Then the user is on the WeNeedYourBankDetailsPage
    When the user clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects personal account and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid personal bank details without roll number and clicks continue
    Then the user is on the CheckDetailsPage
    And the page shows the amount typed and doesn't show the roll number
    When the user clicks continue
    Then the user is on the YouNeedToSignInAgainPage
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the RequestReceivedPage
    When the user clicks HMRC online account
    Then the user is on the <page>
    Examples:
      | URL          | page              |
      | provided     | ReturnUrlPage     |
      | not provided | RefundHistoryPage |

  Scenario Outline: User clicks return link on lockout page
    Given The Individual user starts a refund journey with Nino AB200111D, confidence 250, and urls <URL>
    Then the user is on the RefundAmountPage
    When the user selects a different amount and clicks continue
    Then the user is on the WeNeedYourBankDetailsPage
    When the user clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects business account and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters wrong name business bank details without roll number and clicks continue
    Then the user sees the BARS error for failing verify checks
    When the user clicks continue
    Then the user sees the BARS error for failing verify checks
    When the user clicks continue
    Then the user is on the LockoutPage
    When the user clicks lockout return button
    Then the user is on the <page>
    Examples:
      | URL          | page              |
      | provided     | ReturnUrlPage     |
      | not provided | V&CPage           |