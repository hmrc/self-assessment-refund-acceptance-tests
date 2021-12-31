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
