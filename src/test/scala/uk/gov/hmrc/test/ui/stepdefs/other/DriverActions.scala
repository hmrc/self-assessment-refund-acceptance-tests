package uk.gov.hmrc.test.ui.stepdefs.other

import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser
import uk.gov.hmrc.test.ui.testdata.{Language, ScenarioContext}
import uk.gov.hmrc.webdriver.SingletonDriver

trait DriverActions extends WebBrowser {

  implicit def driver: WebDriver = SingletonDriver.getInstance()

  def clickBack(): Unit = click on id("back")

  def continue(): Unit = click on id("continue")

  def langToggle: String = ScenarioContext.getOrElse[String]("langToggle", Language.english)

  def signOut(): Unit = {
    //click on id("homeNavHref")
    if (langToggle == "cy") click on linkText("Allgofnodi")
    else if (langToggle == "en") click on linkText("Sign out")
  }
}
