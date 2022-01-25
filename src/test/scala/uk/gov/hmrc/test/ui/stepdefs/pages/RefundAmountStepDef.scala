package uk.gov.hmrc.test.ui.stepdefs.pages

import uk.gov.hmrc.test.ui.pages.RefundAmountPage
import uk.gov.hmrc.test.ui.stepdefs.other.{DriverActions, Steps}

class RefundAmountStepDef extends Steps with DriverActions {

  Given("""^the user go to the select amount page$""") { () =>
    go to RefundAmountPage.url
    RefundAmountPage.shouldBeLoaded()
  }

  And("""^the user click on the (.*) amount (.*)$""") { (radio: String, amount: String) =>
    //TODO Other amount journey to be determined
    amount match {
      case "N/A" =>
        RefundAmountPage.selectRadio(radio, amount)
      case _ =>
//        TestData.refundAmount = amount
        RefundAmountPage.selectRadio(radio, amount)
    }
  }

  And("""^the user enter an amount of (.*)$""") { amount: String =>
    RefundAmountPage.enterAmount(amount)
  }

  Then("""^the (.*) error shows$""") { error: String =>
    //TODO no error messages yet - to be added
    error match {
      case "choice required" => RefundAmountPage.errorSummaryValidation(error)
      case _ => RefundAmountPage.errorSummaryValidation(error)
                RefundAmountPage.errorMessageValidation(error)
    }


  }


}
