package uk.gov.hmrc.test.ui.pages

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.CheckDetailsPage.{be, langToggle}
import uk.gov.hmrc.test.ui.pages.EnterBankDetailsPage.pageContent
import uk.gov.hmrc.test.ui.pages.content.{EnglishContent, WelshContent}
import uk.gov.hmrc.test.ui.testdata.{BankDetails, Language, TestData}
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object RequestReceivedPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-request-confirmation"
  val selfAssessmentTaxAccountLinkText = "Self Assessment tax account"
  val printPreviewLinkText = "print or download"
  val tellUsLinkText = "Tell us what you think of this service."
  val problemWithPageLinkText = "div.govuk-\\!-display-none-print > a"

  def expectedPageTitle =  {
    if (langToggle == Language.welsh) "Cais am ad-daliad wedi dod i law - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "Refund request received - Request a Self Assessment refund - GOV.UK"
  }
  def expectedPageHeader = {
    if (langToggle == Language.welsh) "Cais am ad-daliad wedi dod i law"
    else "Refund request received"
  }
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def referenceNumber: String = cssSelector("span.line-break > strong").webElement.getText
  def referenceContent: String  = cssSelector("div.govuk-panel.govuk-panel--confirmation > div").webElement.getText
  def taxValue: String = cssSelector("tr:nth-child(1) > td").webElement.getText
  def dateValue: String = cssSelector("tr:nth-child(2) > td").webElement.getText
  def amountValue: String = cssSelector("tr:nth-child(3) > td").webElement.getText
  def pageContent: String = id("main-content").webElement.getText

  def setReferenceNumber(): Unit = {
    TestData.referenceNumber = referenceNumber
  }

  def assertContent(): Assertion =  {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.requestReceivedPageText())
    else pageContent should be(EnglishContent.requestReceivedPageText())
  }

  def referenceNumberDisplayed(): Assertion = {
    referenceContent should fullyMatch regex s"""Your refund reference is [a-z0-9]{24}""".r
  }

  def refundDetailsCorrect(): Unit = {
    val tax: String = TestData.refundType
    val date: String = TestData.dateValue
    val amount: String = TestData.amountValue
    taxValue should be(tax)
    dateValue should be(date)
    amountValue should be(amount)
  }

  def clickSelfAssessmentTaxAccountLinkText(): Unit = {
    click on linkText(selfAssessmentTaxAccountLinkText)
    ViewChangeAccountPage.shouldBeLoaded()
  }

  def clickTellUsLinkText(): Unit = {
    click on linkText(tellUsLinkText)
    SurveyPage.shouldBeLoaded()
  }

}
