package uk.gov.hmrc.test.ui.pages.support

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.test.ui.testdata.ScenarioContext

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.temporal.ChronoField
import java.util.Date
import scala.annotation.tailrec
import scala.util.Random
import scala.util.matching.Regex

object HelperFunctions extends BasePage {

  val url: String = ""
  def expectedPageHeader: String = ""
  def expectedPageTitle: String = ""
  def expectedPageTitleError: String = ""

  def toggleLangOn(lang: String): Unit =
    if (lang == "cy")
      click on cssSelector("nav > ul > li:nth-child(2)")
    else if (lang == "en")
      click on cssSelector("nav > ul > li:nth-child(1)")
  //      click on id(s"$lang-switch")
}
