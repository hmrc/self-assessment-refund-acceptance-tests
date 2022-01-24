package uk.gov.hmrc.test.ui.pages

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.EnglishContent
import uk.gov.hmrc.test.ui.testdata.TestData
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object StatusPendingPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-status/0"

  val inProgressAmount1: String = TestData.inProgessAmount1

  def expectedPageTitle = s"Your refund of £$inProgressAmount1 is in progress - Request a Self Assessment refund - GOV.UK"
  def expectedPageHeader = s"Your refund of £$inProgressAmount1 is in progress"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText


  def assertContent(): Assertion =  {
    pageContent should be(EnglishContent.statusPendingPageText())
  }
}
