package uk.gov.hmrc.test.ui.pages.testonly

import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object BackUrlPage extends BasePage {

  val url = s"${testConfig.selfAssessmentRefundFrontendUrl}/change-bank-account/test-only/show-back-url"
  def expectedPageTitle = "Back Page - Business tax account - GOV.UK"
  def expectedPageHeader = "Back url page"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

}
