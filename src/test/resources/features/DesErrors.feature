@test
Feature: DES Errors

  Scenario: DES errors and user contacts HMRC
    Given The user starts a refund journey with Nino AB111111B, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects the full amount and clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects business account and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid business bank details with roll number and clicks continue
    Then the user is on the CheckDetailsPage
    And the page shows the full amount and shows the roll number
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the DesErrorPage
    And the Start Again link is correct
    When the user clicks contact HMRC
    Then the user is on the SaEnquiresPage

  Scenario: DES errors and Welsh user contacts HMRC
    Given The user starts a refund journey with Nino AB111111B, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects the full amount and clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects business account and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid business bank details with roll number and clicks continue
    Then the user is on the CheckDetailsPage
    And the page shows the full amount and shows the roll number
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the DesErrorPage
    And the Start Again link is correct
    When the user clicks Cymraeg
    And the user clicks contact HMRC
    Then the user is on the WelshEnquiresPage