package uk.gov.hmrc.test.ui.pages.testonly

import uk.gov.hmrc.test.ui.pages.{BasePage, RefundAmountPage}

object SharedFunctions extends BasePage {

  val url = ""
  def expectedPageTitle = ""
  def expectedPageHeader = ""
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def expectedPage(page: String): Unit = {
    page match {

      case "Return URL"          => ReturnUrlPage.shouldBeLoaded()
      case "Back URL"            => BackUrlPage.shouldBeLoaded()
      case "Convenience URL"     => ConvenienceUrlPage.shouldBeLoaded()
      case "Select Amount"     => RefundAmountPage.shouldBeLoaded()

    }
  }
}
