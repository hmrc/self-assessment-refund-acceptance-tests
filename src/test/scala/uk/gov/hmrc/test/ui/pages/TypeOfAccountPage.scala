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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.{EnglishContent, WelshContent}
import uk.gov.hmrc.test.ui.testdata.Language
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object TypeOfAccountPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/your-account-type"

  def expectedPageTitle = {
    if (langToggle == Language.welsh) "Manylion pa fath o gyfrif yr ydych yn eu rhoi? - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "What type of account details are you providing? - Request a Self Assessment refund - GOV.UK"
  }

  def expectedPageHeader = {
    if (langToggle == Language.welsh) "Manylion pa fath o gyfrif yr ydych yn eu rhoi?"
    else "What type of account details are you providing?"
  }

  def expectedPageTitleError = if (langToggle == Language.welsh) "Gwall: " + expectedPageTitle else "Error: " + expectedPageTitle

  def businessAccountRadio: WebElement = id("accountType").webElement

  def personalAccountRadio: WebElement = id("accountType-2").webElement

  def pageContent: String = id("main-content").webElement.getText

  def errorSummaryTitle: WebElement = id("error-summary-title").webElement

  def errorSummary: WebElement = cssSelector("div > ul > li > a").webElement

  def errorMessage: WebElement = id("accountType-error").webElement

  override def assertCurrentUrl(): Assertion = {
    currentUrl should fullyMatch regex s"""$url/[a-z0-9]{24}""".r
  }

  def assertContent(): Assertion = {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.typeOfAccountPageText())
    else pageContent should be(EnglishContent.typeOfAccountPageText())
  }

  def selectRadio(radio: String) {
    radio match {
      case "business" => click on businessAccountRadio
      case "personal" => click on personalAccountRadio
      case "none" => continue()
    }
  }

  def assertError(): Assertion = {
    assertCurrentPageTitleError()
    if (langToggle == Language.welsh) {
      errorSummaryTitle.getText should be("Mae problem wedi codi")
      errorSummary.getText should be("Dewiswch y math o gyfrif")
      errorMessage.getText should be("Gwall:\nDewiswch y math o gyfrif")
    }
    else {
      errorSummaryTitle.getText should be("There is a problem")
      errorSummary.getText should be("Select a type of account")
      errorMessage.getText should be("Error:\nSelect a type of account")
    }
  }


}
