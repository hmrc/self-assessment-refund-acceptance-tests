package uk.gov.hmrc.test.ui.pages

import org.scalatest.{Assertion, Matchers}
import uk.gov.hmrc.test.ui.stepdefs.other.DriverActions


trait BasePage extends DriverActions with Matchers {

  val url: String
  def expectedPageTitle: String
  def expectedPageTitleError: String
  def expectedPageService: String = "Request a Self Assessment Refund"
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
    assertCurrentUrl()
    assertCurrentPageTitle()
    assertCurrentPageService()
    assertCurrentPageHeader()
  }

}
