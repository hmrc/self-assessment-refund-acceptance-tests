/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.stepdefs.other

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.WebBrowser
import uk.gov.hmrc.test.ui.testdata.{Language, ScenarioContext}
import uk.gov.hmrc.test.ui.utils.BrowserDriver

trait DriverActions extends ScalaDsl with EN with BrowserDriver with Eventually with Matchers with WebBrowser {

  def clickBack(): Unit = click on cssSelector("a.govuk-back-link")

  def continue(): Unit = click on id("continue")

  def langToggle: String = ScenarioContext.getOrElse[String]("langToggle", Language.english)

  def signOut(): Unit = {
    //click on id("homeNavHref")
    if (langToggle == "cy") click on linkText("Allgofnodi")
    else if (langToggle == "en") click on linkText("Sign out")
  }
}
