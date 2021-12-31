package uk.gov.hmrc.test.ui.stepdefs.pages

import uk.gov.hmrc.test.ui.pages.SelectAmountPage
import uk.gov.hmrc.test.ui.stepdefs.other.{DriverActions, Steps}

class SelectAmountStepDef extends Steps with DriverActions {

  Given("""^the user go to the select amount page$""") { () =>
    go to SelectAmountPage.url
    SelectAmountPage.shouldBeLoaded()
  }

  And("""^the user click on the (.*) amount (.*)$""") { (radio: String, amount: String) =>
    //TODO Other amount journey to be determined
    amount match {
      case "N/A" =>
        SelectAmountPage.selectRadio(radio, amount)
      case _ =>
//        TestData.refundAmount = amount
        SelectAmountPage.selectRadio(radio, amount)
    }
  }

  And("""^the user enter an amount of (.*)$""") { amount: String =>
    SelectAmountPage.enterAmount(amount)
  }

  Then("""^the (.*) error shows$""") { error: String =>
    //TODO no error messages yet - to be added
    error match {
      case "choice required" => SelectAmountPage.errorSummaryValidation(error)
      case _ => SelectAmountPage.errorSummaryValidation(error)
                SelectAmountPage.errorMessageValidation(error)
    }


  }


}
