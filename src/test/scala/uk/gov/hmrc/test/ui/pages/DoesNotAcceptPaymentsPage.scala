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

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.{EnglishContent, WelshContent}
import uk.gov.hmrc.test.ui.testdata.{Language, TestData}
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object DoesNotAcceptPaymentsPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/bankDoesNotAcceptCredits"
  val rejectedAmount1: String = TestData.rejectedAmount1

  def expectedPageTitle =  {
    if (langToggle == Language.welsh) s"TBC - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else s"Your bank account does not accept payments - Request a Self Assessment refund - GOV.UK"
  }
  def expectedPageHeader = {
    if (langToggle == Language.welsh) s"TBC"
    else s"Your bank account does not accept payments"
  }

  def expectedPageTitleError = if (langToggle == Language.welsh) "Gwall: " + expectedPageTitle else "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText


  def assertContent(): Assertion = {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.doesNotAcceptPaymentsPageText())
    else pageContent should be(EnglishContent.doesNotAcceptPaymentsPageText())
  }
}
