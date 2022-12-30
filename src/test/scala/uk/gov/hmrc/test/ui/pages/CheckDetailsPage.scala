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
import uk.gov.hmrc.test.ui.pages.EnterBankDetailsPage.pageContent
import uk.gov.hmrc.test.ui.pages.content.{EnglishContent, WelshContent}
import uk.gov.hmrc.test.ui.testdata.Language
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object CheckDetailsPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/check-your-details"

  def expectedPageTitle = {
    if (langToggle == Language.welsh) "Gwiriwch eich manylion - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "Check your details - Request a Self Assessment refund - GOV.UK"
  }

  def expectedPageHeader = {
    if (langToggle == Language.welsh) "Gwiriwch eich manylion"
    else "Check your details"
  }

  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def assertContent(): Assertion = {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.checkDetailsPageText())
    else pageContent should be(EnglishContent.checkDetailsPageText())
  }

  def changeType(): Unit = cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd.govuk-summary-list__actions > a").webElement.click()
  def changeBank(): Unit = cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd.govuk-summary-list__actions > a").webElement.click()
  def changeAmount(): Unit = cssSelector("#main-content > div > div > dl > div:nth-child(3) > dd.govuk-summary-list__actions > a").webElement.click()




}
