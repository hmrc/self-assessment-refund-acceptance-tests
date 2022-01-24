package uk.gov.hmrc.test.ui.pages

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.EnglishContent
import uk.gov.hmrc.test.ui.testdata.TestData
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object AccountOnFilePage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/we-need-to-get-your-bank-details"
  //TODO - Link this to test data values
  val amount: String = TestData.refundAmount

  def expectedPageTitle = "We need to get your bank details - Request a Self Assessment refund - GOV.UK"
  def expectedPageHeader = s"We need to get your bank details"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText

  def assertContent(): Assertion =  {
    pageContent should be(EnglishContent.accountOnFilePageText())
  }



}
