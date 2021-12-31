package uk.gov.hmrc.test.ui.stepdefs.pages

import uk.gov.hmrc.test.ui.pages.EnterBankDetailsPage
import uk.gov.hmrc.test.ui.stepdefs.other.{DriverActions, Steps}

class EnterBankDetailsStepDef extends Steps with DriverActions {

  And("""^the user enter valid (personal|business) bank details$""") { AccType: String =>
    AccType match {
      case "personal" => EnterBankDetailsPage.enterPersonalBankDetails()
      case "business" => EnterBankDetailsPage.enterBusinessBankDetails()
    }
  }

  And("""^the user enter valid (personal|business) bank details with roll number$""") { AccType: String =>
    AccType match {
      case "personal" => EnterBankDetailsPage.enterPersonalBankDetailsWithRoll()
      case "business" => EnterBankDetailsPage.enterBusinessBankDetailsWithRoll()
    }
  }

}
