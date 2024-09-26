@test
Feature: API Errors

  Scenario Outline: Financial data returns error
    Given The Individual user starts a refund journey with Nino <nino>, confidence 250, and urls provided
    Then the user is on the TechnicalDifficultiesPage
    Examples:
      | nino |
      | AB400111C |
      | AB400211C |
      | AB400311C |
      | AB400411C |
      | AB400511C |
      | AB400611C |
      | AB400711C |
      | AB400811C |
      | AB400911C |
      | AB410111C |
      | AB410211C |
      | AB410311C |
      | AB410411C |
      | AB410511C |
      | AB410611C |
      | AB403111C |
      | AB404111C |
      | AB422111C |
      | AB422211C |
      | AB500111C |
      | AB503111C |

  Scenario: Financial amount data doesn't match V&C
    Given The Individual user starts a refund journey with Nino AB200111C, confidence 250, and urls provided but amount wrong
    Then the user is on the TechnicalDifficultiesPage

  Scenario: Submission request returns error and user contacts HMRC
    Given The Individual user starts a refund journey with Nino AB200111B, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects the full amount and clicks continue
    Then the user is on the WeNeedYourBankDetailsPage
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
    Then the user is on the DesErrorPage
    And the Start Again link is correct
    When the user clicks contact HMRC
    Then the user is on the SaEnquiresPage

  Scenario: Submission request returns error and user contacts HMRC
    Given The Individual user starts a refund journey with Nino AB200111B, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects the full amount and clicks continue
    Then the user is on the WeNeedYourBankDetailsPage
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
    Then the user is on the DesErrorPage
    And the Start Again link is correct
    When the user clicks Cymraeg
    And the user clicks contact HMRC
    Then the user is on the WelshEnquiresPage