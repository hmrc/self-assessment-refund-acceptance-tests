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
import uk.gov.hmrc.test.ui.testdata.{Language, ScenarioContext}
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object IvKickoutPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/failedUplift"

  def expectedPageTitle = {
    if (langToggle == Language.welsh) "Nid oedd modd i ni gadarnhau pwy ydych - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "We could not confirm your identity - Request a Self Assessment refund - GOV.UK"
  }

  def expectedPageHeader = {
    if (langToggle == Language.welsh) "Nid oedd modd i ni gadarnhau pwy ydych"
    else "We could not confirm your identity"
  }

  def expectedPageTitleError = if (langToggle == Language.welsh) "Gwall: " + expectedPageTitle else "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement(driver).getText

  def assertContent(): Assertion = {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.ivKickoutPageText())
    else pageContent should be(EnglishContent.ivKickoutPageText())
  }





  // IV Stub Page

  def ninoEntry: WebElement = id("forNino").webElement(driver)

  def IvOutcome(outcome: String): WebElement = {
    outcome match {
      case "Success" => id("Success").webElement(driver)
      case "Pre Condition Failed" => id("PreconditionFailed").webElement(driver)
      case "Locked Out" => id("LockedOut").webElement(driver)
      case "Insufficient Evidence" => id("InsufficientEvidence").webElement(driver)
      case "Failed Matching" => id("FailedMatching").webElement(driver)
      case "Technical Issue" => id("TechnicalIssue").webElement(driver)
      case "User Aborted" => id("UserAborted").webElement(driver)
      case "Timed Out" => id("Timeout").webElement(driver)
      case "Failed IV" => id("FailedIV").webElement(driver)
    }
  }

  def enterNino(): Unit = {
    ninoEntry.sendKeys(ScenarioContext.get("nino"))
  }

  def selectIvOutcome(outcome: String): Unit = {
    IvOutcome(outcome).click()
  }

  def clickSubmit(): Unit = clickOn(id("submit-continue"))

}
