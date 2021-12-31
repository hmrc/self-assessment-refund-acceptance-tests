package uk.gov.hmrc.test.ui.pages.testonly

import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object TestOnlyStartPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/test-only/boot"

  def expectedPageTitle = "TBC"
  def expectedPageHeader = "TBC"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def clickRadio(nino: String): Unit ={
    nino match {
      case "AC111111A" => click on id("0")
      case "AA111111A" => click on id("1")
    }
    continue()
  }

}
