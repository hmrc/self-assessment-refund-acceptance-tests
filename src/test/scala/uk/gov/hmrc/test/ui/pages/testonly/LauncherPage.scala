package uk.gov.hmrc.test.ui.pages.testonly

import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object LauncherPage extends BasePage {

  val url = s"${testConfig.selfAssessmentRefundFrontendUrl}/change-bank-account/test-only/start-journey"
  def expectedPageTitle = "Launcher Page - Business tax account - GOV.UK"
  def expectedPageHeader = "Start Page"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def enterVrn(value: String): Unit = {
    id("vrn").webElement.clear()
    id("vrn").webElement.sendKeys(value)
  }

  def clickIsAgent(userType: String): Unit = {
    if (userType.equals("Agent")) click on id("isAgent-yes")
    else click on id("isAgent-no")
  }

  def enterPartyType(value: String): Unit = id("partyType").webElement.sendKeys(value)

  def clickIsWelsh(value: String): Unit = click on id(s"welshIndicator-$value")
}
