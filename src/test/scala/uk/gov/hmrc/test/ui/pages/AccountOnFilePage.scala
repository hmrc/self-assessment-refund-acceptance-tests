package uk.gov.hmrc.test.ui.pages

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.EnglishContent
import uk.gov.hmrc.test.ui.testdata.TestData
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object AccountOnFilePage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/account-on-file"
  //TODO - Link this to test data values
  val amount: String = TestData.refundAmount

  def expectedPageTitle = "Your payment details - Request a Self Assessment Refund - GOV.UK"
  def expectedPageHeader = s"Your refund of £$amount"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText

  def assertContent(): Assertion =  {
    pageContent should be(EnglishContent.accountOnFilePageText())
  }



}
