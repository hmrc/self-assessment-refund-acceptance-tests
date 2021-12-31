package uk.gov.hmrc.test.ui.utils

import org.openqa.selenium.WebDriver
import uk.gov.hmrc.webdriver.SingletonDriver

trait Driver {

  def initiateBrowser: WebDriver = SingletonDriver.getInstance()

}
