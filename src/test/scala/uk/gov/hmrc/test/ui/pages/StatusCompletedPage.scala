package uk.gov.hmrc.test.ui.pages

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.EnglishContent
import uk.gov.hmrc.test.ui.testdata.TestData
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object StatusCompletedPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-status/2"

  val completedAmount1: String = TestData.completedAmount1

  def expectedPageTitle = s"Your refund of £$completedAmount1 is complete - Request a Self Assessment Refund - GOV.UK"
  def expectedPageHeader = s"Your refund of £$completedAmount1 is complete"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText


  def assertContent(): Assertion =  {
    pageContent should be(EnglishContent.statusCompletedPageText())
  }
}
