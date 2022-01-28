/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.stepdefs.pages

import uk.gov.hmrc.test.ui.pages.{EnterBankDetailsPage}
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

  Then("""^the user enters (.*) (.*) and the correct error message is shown$""") { (error: String, value: String) =>
    error match {
//      case "enter amount" | "choice required" | "invalid amount" | "amount of 0" | "exceeded maximum amount" =>
//        RefundAmountPage.errorSummaryValidation(error)
//        RefundAmountPage.errorMessageValidation(error)
      case "no details entered"  => EnterBankDetailsPage.assertNoDetailsError()
      case "invalid sortcode" => EnterBankDetailsPage.assertSortCodeCorrectFormatError(value)
      case "invalid account number" => EnterBankDetailsPage.assertAccountNumberCorrectFormatError(value)
      case "account number too short" => EnterBankDetailsPage.assertAccountNumberCorrectLengthError(value)
      case "account number too long" => EnterBankDetailsPage.assertAccountNumberCorrectLengthError(value)
    }
  }

}
