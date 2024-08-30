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

import uk.gov.hmrc.test.ui.pages.ServicePages.RefundAmountPage
import uk.gov.hmrc.test.ui.stepdefs.DriverActions

class RefundAmountStepDef extends DriverActions {

  Given("""^the user go to the select amount page$""") { () =>
    go to RefundAmountPage.url
    RefundAmountPage.shouldBeLoaded()
  }

  And("""^the user click on the (.*) amount (.*)$""") { (radio: String, amount: String) =>
        RefundAmountPage.selectRadio(radio, amount)

  }

  And("""^the user clicks other amount$""") { () =>
    RefundAmountPage.selectOtherAmountRadio()
  }


  And("""^the user enter an amount of (.*)$""") { amount: String =>
    RefundAmountPage.enterAmount(amount)
  }

  Then("""^the (.*) error shows$""") { error: String =>
    RefundAmountPage.errorSummaryValidation(error)
    RefundAmountPage.errorMessageValidation(error)
  }

}
