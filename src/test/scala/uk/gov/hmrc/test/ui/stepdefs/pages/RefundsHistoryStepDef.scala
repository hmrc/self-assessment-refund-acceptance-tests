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

import uk.gov.hmrc.test.ui.pages.RefundsHistoryPage
import uk.gov.hmrc.test.ui.stepdefs.other.{DriverActions, Steps}

class RefundsHistoryStepDef extends Steps with DriverActions {

  And("""^the user clicks on the (In Progress|Completed) tab$""") { (tab: String) =>
    RefundsHistoryPage.clickTab(tab)
  }

  And("""^the user clicks on (View Progress|Completed|Rejected) for result number (.*)$""") { (status: String, resultNum: String) =>
    status match {
      case "View Progress" => RefundsHistoryPage.clickViewProgress(resultNum)
      case "Completed" | "Rejected" => RefundsHistoryPage.clickCompletedOrRejected(resultNum)
    }
  }


}
