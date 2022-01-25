package uk.gov.hmrc.test.ui.pages

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.EnglishContent
import uk.gov.hmrc.test.ui.testdata.TestData
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object StatusRejectedPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-status/4"
  val rejectedAmount1: String = TestData.rejectedAmount1

  def expectedPageTitle = s"Your refund of £$rejectedAmount1 has been rejected - Request a Self Assessment refund - GOV.UK"
  def expectedPageHeader = s"Your refund of £$rejectedAmount1 has been rejected"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText


  def assertContent(): Assertion =  {
    pageContent should be(EnglishContent.statusRejectedPageText())
  }
}
