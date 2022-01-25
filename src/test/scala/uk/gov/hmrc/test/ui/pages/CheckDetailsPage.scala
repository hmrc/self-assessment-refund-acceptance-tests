package uk.gov.hmrc.test.ui.pages

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.EnterBankDetailsPage.{be, langToggle, pageContent}
import uk.gov.hmrc.test.ui.pages.TypeOfAccountPage.langToggle
import uk.gov.hmrc.test.ui.pages.content.{EnglishContent, WelshContent}
import uk.gov.hmrc.test.ui.testdata.Language
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object CheckDetailsPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/check-your-details"

  def expectedPageTitle =  {
    if (langToggle == Language.welsh) "Gwiriwch eich manylion - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "Check your details - Request a Self Assessment refund - GOV.UK"
  }
  def expectedPageHeader = {
    if (langToggle == Language.welsh) "Gwiriwch eich manylion"
    else "Check your details"
  }
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def assertContent(): Assertion =  {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.checkDetailsPageText())
    else pageContent should be(EnglishContent.checkDetailsPageText())
  }


}
