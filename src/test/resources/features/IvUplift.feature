@test
Feature: IV Uplift

  Scenario: IV Uplift successful
    Given The Individual user starts a refund journey with Nino AB200111C, confidence 50, and urls provided
    Then the user is on the IvUpliftPage
    When the IV uplift user selects IV success
    Then the user is on the RefundAmountPage
    When the user selects the full amount and clicks continue
    Then the user is on the HowYouWillGetTheRefundPage
    When the user clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects business account and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid business bank details with roll number and clicks continue
    Then the user is on the CheckDetailsPage
    And the page shows the full amount and shows the roll number
    When the user clicks continue
    Then the user is on the YouNeedToSignInAgainPage
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the RequestReceivedPage

  Scenario: IV Uplift unsuccessful
    Given The Individual user starts a refund journey with Nino AB200111C, confidence 50, and urls provided
    Then the user is on the IvUpliftPage
    When the IV uplift user selects IV failure
    Then the user is on the IvKickoutPage
    When the user clicks back to tax account
    # add when button leads somewhere
