@test
Feature: IV Uplift

  Scenario: IV Uplift Successful
    Given The user starts a journey with Nino AB111111C and confidence 50
    Then the user is on the IvUpliftPage
    When the IV uplift user selects IV success
    Then the user is on the RefundAmountPage
    When the user selects the full amount and clicks continue
    Then the user is on the AccountOnFilePage
    When the user clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects business account and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid business bank details with roll number and clicks continue
    Then the user is on the CheckDetailsPage
    And the page shows the full amount and shows the roll number
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the RequestReceivedPage

  Scenario: IV Uplift Unsuccessful
    Given The user starts a journey with Nino AB111111C and confidence 50
    Then the user is on the IvUpliftPage
    When the IV uplift user selects IV failure
    Then the user is on the IvKickoutPage
    When the user clicks back to tax account
    # add when button leads somewhere
