package uk.gov.hmrc.test.ui.pages

import org.scalatest.{Assertion, Matchers}
import uk.gov.hmrc.test.ui.stepdefs.other.DriverActions
import uk.gov.hmrc.test.ui.testdata.Language


trait BasePage extends DriverActions with Matchers {

  val url: String
  def expectedPageTitle: String
  def expectedPageTitleError: String
  def expectedPageService: String = {
    if (langToggle == Language.welsh) "Gwneud cais am ad-daliad Hunanasesiad"
    else "Request a Self Assessment refund"
  }
  def expectedPageHeader: String

  def currentPageTitle: String = pageTitle
  def currentPageService: String = cssSelector("div.govuk-header__content > a").webElement.getText
  def currentPageHeader: String = cssSelector("h1").webElement.getText

  def assertCurrentUrl(): Assertion              = currentUrl should be(url)
  def assertCurrentPageTitle(): Assertion        = currentPageTitle should be(expectedPageTitle)
  def assertCurrentPageTitleError(): Assertion   = currentPageTitle should be(expectedPageTitleError)
  def assertCurrentPageService(): Assertion      = currentPageService should be(expectedPageService)
  def assertCurrentPageHeader(): Assertion       = currentPageHeader should be(expectedPageHeader)

  def shouldBeLoaded(): Unit = {
    //TODO when URLS are sorted with regards to jounrey id etc.
//    assertCurrentUrl()
    assertCurrentPageTitle()
    assertCurrentPageService()
    assertCurrentPageHeader()
  }

}
