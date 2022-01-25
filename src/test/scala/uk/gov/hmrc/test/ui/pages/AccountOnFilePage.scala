package uk.gov.hmrc.test.ui.pages

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.RefundAmountPage.{be, langToggle, pageContent}
import uk.gov.hmrc.test.ui.pages.content.{EnglishContent, WelshContent}
import uk.gov.hmrc.test.ui.testdata.{Language, TestData}
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object AccountOnFilePage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/we-need-to-get-your-bank-details"
  //TODO - Link this to test data values
  val amount: String = TestData.refundAmount

  def expectedPageTitle = {
    if (langToggle == Language.welsh) "Mae angen i ni gael eich manylion banc - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "We need to get your bank details - Request a Self Assessment refund - GOV.UK"
  }
  def expectedPageHeader = {
    if (langToggle == Language.welsh) "Mae angen i ni gael eich manylion banc"
    else "We need to get your bank details"
  }

  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText

  def assertContent(): Assertion =  {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.accountOnFilePageText())
    else pageContent should be(EnglishContent.accountOnFilePageText())
  }



}
