package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.testdata.TestData
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object AuthWizardPage extends BasePage {

  val url= s"${testConfig.authLoginStubUrl}/auth-login-stub/gg-sign-in"

  def expectedPageTitle = "Authority Wizard"
  def expectedPageHeader = "Authority Wizard"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def enterRedirectUrl(url: String): Unit = {
    name("redirectionUrl").webElement.sendKeys(url)
  }

  def enterValidNino(): Unit =
    name("nino").webElement.sendKeys(TestData.nino)

  def clickSubmit(): Unit = {
    click on id("submit")
  }
}
