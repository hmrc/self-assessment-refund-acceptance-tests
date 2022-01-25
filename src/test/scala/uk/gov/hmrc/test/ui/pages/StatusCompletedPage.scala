package uk.gov.hmrc.test.ui.pages

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.CheckDetailsPage.{be, langToggle}
import uk.gov.hmrc.test.ui.pages.EnterBankDetailsPage.pageContent
import uk.gov.hmrc.test.ui.pages.content.{EnglishContent, WelshContent}
import uk.gov.hmrc.test.ui.testdata.{Language, TestData}
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object StatusCompletedPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-status/2"

  val completedAmount1: String = TestData.completedAmount1

 def expectedPageTitle =  {
    if (langToggle == Language.welsh) s"Mae’ch ad-daliad o £$completedAmount1 wedi’i gwblhau - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else s"Your refund of £$completedAmount1 is complete - Request a Self Assessment refund - GOV.UK"
  }
  def expectedPageHeader = {
    if (langToggle == Language.welsh) s"Mae’ch ad-daliad o £$completedAmount1 wedi’i gwblhau"
    else s"Your refund of £$completedAmount1 is complete"
  }

  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText


  def assertContent(): Assertion =  {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.statusCompletedPageText())
    else pageContent should be(EnglishContent.statusCompletedPageText())
  }
}
