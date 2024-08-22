/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.WebBrowser
import uk.gov.hmrc.test.ui.testdata.{Language, ScenarioContext}
import uk.gov.hmrc.test.ui.utils.BrowserDriver

trait DriverActions extends ScalaDsl with EN with BrowserDriver with Eventually with Matchers with WebBrowser {

  //TO BE DELETED IF UNUSED
  def clickBack(): Unit = click on cssSelector("a.govuk-back-link")

  def continue(): Unit = click on id("continue")

  //TO BE DELETED IF UNUSED
  def langToggle: String = ScenarioContext.getOrElse[String]("langToggle", Language.english)

  //TO BE DELETED IF UNUSED
  def signOut(): Unit =
    //click on id("homeNavHref")
    if (langToggle == "cy") click on linkText("Allgofnodi")
    else if (langToggle == "en") click on linkText("Sign out")

  def enterTextById(id: String, text: String): Unit = findElementById(id).sendKeys(text)

  def findElementById(id: String): WebElement = driver.findElement(By.id(id))

  def findElementByTagName(tagName: String): WebElement = driver.findElement(By.tagName(tagName))

  def findTextById(id: String): String = findElementById(id).getText

  def findTextByTagName(tagName: String): String = findElementByTagName(tagName).getText

  def findTextByCssSelector(selector: String): String = findElementByCssSelector(selector).getText

  def findElementByCssSelector(locator: String): WebElement = driver.findElement(By.cssSelector(locator))

  def isPresent(text: String): Boolean = driver.findElements(By.xpath(s"//*[contains(text(),'$text')]")).size() > 0

  def clickById(text: String): Unit = findElementById(text).click()

  def clickByLinkText(text: String): Unit = driver.findElement(By.linkText(text)).click()

  def clickByCssSelector(text: String): Unit = findElementByCssSelector(text).click()

}
