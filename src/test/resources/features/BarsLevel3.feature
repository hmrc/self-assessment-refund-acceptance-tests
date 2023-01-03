Feature: Level 3 Bars check - Testing of Business and Personal Endpoint

  @fullRegression
  Scenario Outline: Unhappy - Bars Lockout Page
    Given The user starts a <accountType> journey with Nino AB111111D
    When the User toggles on English language
    And the user is on the RefundAmountPage
    And the user clicks other amount
    And the user click on the full amount .
    And the user click continue
    And the user select <accountType> account
    And the user click continue
    When the User enters <bankDetails> bank details
    And the user click continue
    And the user click continue
#    Then the User should be on the page: Bars Lockout

    Examples:
      | accountType | bankDetails         |
      | personal    | invalidName         |
      | business    | invalidNameBusiness |

  @fullRegression
  Scenario Outline: Unhappy - Bars Lockout (After 4 Validate fails, and 3 Verify fails)
    Given The user starts a <accountType> journey with Nino AB111111D
    When the User toggles on English language
    And the user is on the RefundAmountPage
    And the user clicks other amount
    And the user click on the full amount .
    And the user click continue
    And the user select <accountType> account
    And the user click continue
    When the User enters invalid bank details
    And the user click continue
    And the user click continue
    And the user click continue
    When the User enters <bankDetails> bank details
    And the user click continue
    And the user click continue
    And the user click continue
#    Then the User should be on the page: Bars Lockout

    Examples:
      | accountType | bankDetails         |
      | personal    | invalidName         |
      | business    | invalidNameBusiness |

  @core
  Scenario Outline: Happy - Bank Details accepted
    Given The user starts a <accountType> journey with Nino AB111111D
    When the User toggles on English language
    And the user is on the RefundAmountPage
    And the user clicks other amount
    And the user click on the full amount .
    And the user click continue
    And the user select <accountType> account
    And the user click continue
    When the User enters <bankDetails> bank details
    And the user click continue
    And the user is on the <page>

    Examples:
      | accountType | bankDetails           | page                   |
      | personal    | valid                 | CheckDetailsPageNoRoll |
      | business    | validBusiness         | CheckDetailsPageNoRoll |
      | personal    | rollNumberRequired    | CheckDetailsPage       |
      | personal    | indeterminate         | CheckDetailsPageNoRoll |
      | business    | indeterminateBusiness | CheckDetailsPageNoRoll |

  @core
  Scenario Outline: Unhappy - Invalid Bank Details
    Given The user starts a <accountType> journey with Nino AB111111D
    When the User toggles on English language
    And the user is on the RefundAmountPage
    And the user clicks other amount
    And the user click on the full amount .
    And the user click continue
    And the user select <accountType> account
    And the user click continue
    When the User enters <bankDetails> bank details
    And the user click continue
    Then the <field> field should display "<message>"

    Examples:
      | accountType | bankDetails             | message                                                                                                                                                    | field             |
      | business    | valid                   | Enter a valid combination of bank account number and sort code                                                                                             | BARS Invalid      |
      | personal    | validBusiness           | Enter a valid combination of bank account number and sort code                                                                                             | BARS Invalid      |
      | personal    | invalid                 | Enter a valid combination of bank account number and sort code                                                                                             | BARS Invalid      |
      | business    | invalidBusiness         | Enter a valid combination of bank account number and sort code                                                                                             | BARS Invalid      |
      | personal    | invalidName             | Enter the name on the account as it appears on bank statements. Do not copy and paste it                                                                   | Name Invalid      |
      | business    | invalidNameBusiness     | Enter the name on the account as it appears on bank statements. Do not copy and paste it                                                                   | Name Invalid      |
      | personal    | wellFormatted=No        | Enter a valid combination of bank account number and sort code                                                                                             | BARS Invalid      |
      | business    | supportsDirectCredit=No | You have entered a sort code which does not accept this type of payment. Check you have entered a valid sort code or enter details for a different account | Sortcode Error    |
      | personal    | onEISCD=No              | Enter a valid combination of bank account number and sort code                                                                                             | BARS Invalid      |
      | business    | denyList                | Enter a valid combination of bank account number and sort code                                                                                             | BARS Invalid      |
      | personal    | partialName             | Enter the name on the account as it appears on bank statements. Do not copy and paste it                                                                   | Name Invalid      |
      | business    | partialNameBusiness     | Enter the name on the account as it appears on bank statements. Do not copy and paste it                                                                   | Name Invalid      |
      | personal    | noRollNumberButRequired | Your account may have an extra reference number. It may be called a roll number, account reference or account number                                       | Roll Number Error |


  @fullRegression
  Scenario Outline: Unhappy - Welsh - Invalid Bank Details
    Given The user starts a <accountType> journey with Nino AB111111D
    When the User toggles on English language
    And the user is on the RefundAmountPage
    And the user clicks other amount
    And the user click on the full amount .
    And the user click continue
    And the user select <accountType> account
    And the user click continue
    When the User toggles on Welsh language
    When the User enters <bankDetails> bank details
    And the user click continue
    Then the <field> field should display "<message>"
    When the User toggles on English language

    Examples:
      | accountType | bankDetails             | message                                                                                                                                                     | field          |
      | business    | valid                   | Nodwch gyfuniad dilys o rif cyfrif banc a chod didoli                                                                                                       | BARS Invalid   |
      | personal    | validBusiness           | Nodwch gyfuniad dilys o rif cyfrif banc a chod didoli                                                                                                       | BARS Invalid   |
      | personal    | invalid                 | Nodwch gyfuniad dilys o rif cyfrif banc a chod didoli                                                                                                       | BARS Invalid   |
      | business    | invalidBusiness         | Nodwch gyfuniad dilys o rif cyfrif banc a chod didoli                                                                                                       | BARS Invalid   |
      | personal    | invalidName             | Nodwch yr enw ar y cyfrif, fel y mae’n ymddangos ar gyfriflenni banc. Peidiwch â’i gopïo a’i ludo                                                           | Name Invalid   |
      | business    | invalidNameBusiness     | Nodwch yr enw ar y cyfrif, fel y mae’n ymddangos ar gyfriflenni banc. Peidiwch â’i gopïo a’i ludo                                                           | Name Invalid   |
      | personal    | wellFormatted=No        | Nodwch gyfuniad dilys o rif cyfrif banc a chod didoli                                                                                                       | BARS Invalid   |
      | business    | supportsDirectCredit=No | Rydych wedi nodi cod didoli nad yw’n derbyn y math hwn o daliad. Gwiriwch eich bod wedi nodi cod didoli dilys, neu nodwch fanylion ar gyfer cyfrif gwahanol | Sortcode Error |
      | personal    | onEISCD=No              | Nodwch gyfuniad dilys o rif cyfrif banc a chod didoli                                                                                                       | BARS Invalid   |
      | business    | denyList                | Nodwch gyfuniad dilys o rif cyfrif banc a chod didoli                                                                                                       | BARS Invalid   |
      | personal    | partialName             | Nodwch yr enw ar y cyfrif, fel y mae’n ymddangos ar gyfriflenni banc. Peidiwch â’i gopïo a’i ludo                                                                  | Name Invalid   |
      | business    | partialNameBusiness     | Nodwch yr enw ar y cyfrif, fel y mae’n ymddangos ar gyfriflenni banc. Peidiwch â’i gopïo a’i ludo                                                                   | Name Invalid   |
#      | personal    | noRollNumberButRequired      | TBC                                                                                                                                                         | BARS Invalid   |


  @core
  Scenario Outline: Happy - 2 attempts at verify endpoints, success
    Given The user starts a <accountType> journey with Nino AB111111D
    When the User toggles on English language
    And the user is on the RefundAmountPage
    And the user clicks other amount
    And the user click on the full amount .
    And the user click continue
    And the user select <accountType> account
    And the user click continue
    When the User enters invalidName bank details
    And the user click continue
    And the user click continue
    When the User enters <bankDetails> bank details
    And the user click continue
    And the user is on the CheckDetailsPageNoRoll
    Examples:
      | accountType | bankDetails   |
      | personal    | valid         |
      | business    | validBusiness |
