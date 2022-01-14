package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.EnglishContent
import uk.gov.hmrc.test.ui.testdata.TestData
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object RefundsHistoryPage extends BasePage {

  val nino: String = TestData.nino

  val urlOrigin: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-history/$nino"
  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-history/$nino#in-progress"

  def expectedPageTitle = "Your refunds history - Request a Self Assessment Refund - GOV.UK"
  def expectedPageHeader = "Your refunds history"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText

  //In Progress
  def inProgressTab: WebElement = id("tab_in-progress").webElement
  def inProgressReceivedOnDate(num: String): WebElement = cssSelector(s"#in-progress > table > tbody > tr:nth-child($num) > th").webElement
  def inProgressAmountClaimed(num: String): WebElement = cssSelector(s"#in-progress > table > tbody > tr:nth-child($num) > td.govuk-table__cell.govuk-table__cell--numeric.no-break").webElement
  def viewProgress(num: String): WebElement = cssSelector(s"#in-progress > table > tbody > tr:nth-child($num) > td:nth-child(3) > a").webElement

  // Completed
  def completedTab: WebElement = id("tab_completed").webElement
  def completedReceivedOnDate(num: String): WebElement = cssSelector(s"#completed > table > tbody > tr:nth-child($num) > th").webElement
  def completedCompletedOnDate(num: String): WebElement = cssSelector(s"#completed > table > tbody > tr:nth-child($num) > td:nth-child(2)").webElement
  def completedAmountClaimed(num: String): WebElement = cssSelector(s"#completed > table > tbody > tr:nth-child($num) > td.govuk-table__cell.govuk-table__cell--numeric.no-break").webElement
  def completedRejected(num: String): WebElement = cssSelector(s"#completed > table > tbody > tr:nth-child($num) > td:nth-child(4) > a").webElement


  def assertContent(tab: String): Assertion = {
    tab match {
      case "In Progress" => pageContent should be(EnglishContent.refundHistoryInProgressPageText())
      case "Completed" => pageContent should be(EnglishContent.refundHistoryCompletedPageText())
    }
  }

  def clickTab(tab: String): Unit ={
    tab match {
      case "In Progress" => click on inProgressTab
      case "Completed" => click on completedTab
    }
  }

  def clickViewProgress(num: String): Unit ={
    click on inProgressTab
    click on viewProgress(num)
  }

  def clickCompletedOrRejected(num: String): Unit ={
    click on completedTab
    click on completedRejected(num)
  }
}
