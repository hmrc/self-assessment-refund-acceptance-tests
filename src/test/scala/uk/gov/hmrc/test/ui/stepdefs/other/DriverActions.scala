package uk.gov.hmrc.test.ui.stepdefs.other

import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser
import uk.gov.hmrc.webdriver.SingletonDriver

trait DriverActions extends WebBrowser {

  implicit def driver: WebDriver = SingletonDriver.getInstance()

  def clickBack(): Unit = click on id("back")

  def continue(): Unit = click on id("continue")

}
