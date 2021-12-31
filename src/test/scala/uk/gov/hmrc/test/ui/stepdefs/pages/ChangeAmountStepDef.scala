package uk.gov.hmrc.test.ui.stepdefs.pages

import uk.gov.hmrc.test.ui.pages.{SelectAmountPage, ViewChangeAccountPage}
import uk.gov.hmrc.test.ui.stepdefs.other.{DriverActions, Steps}

class ChangeAmountStepDef extends Steps with DriverActions {

  Given("""^the user go to the view change account page$""") { () =>
    go to ViewChangeAccountPage.url
    ViewChangeAccountPage.shouldBeLoaded()
    ViewChangeAccountPage.refundCreditAmount()
  }

  And("""^the user click on Claim a Refund$""") { () =>
    ViewChangeAccountPage.clickClaimRefund()
  }
}
