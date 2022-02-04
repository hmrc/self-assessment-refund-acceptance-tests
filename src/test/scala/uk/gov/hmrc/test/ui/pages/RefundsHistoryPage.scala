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
import uk.gov.hmrc.test.ui.testdata.{Language, TestData}
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object RefundsHistoryPage extends BasePage {

  val nino: String = TestData.nino

  val urlOrigin: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-history/$nino"
  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-history/$nino#in-progress"

  def expectedPageTitle = {
    if (langToggle == Language.welsh) "Hanes eich ad-daliadau - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "Your refunds history - Request a Self Assessment refund - GOV.UK"
  }
  def expectedPageHeader = {
    if (langToggle == Language.welsh) "Hanes eich ad-daliadau"
    else "Your refunds history"
  }

  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText

  //In Progress
  def inProgressTab: WebElement = id("tab_in-progress").webElement
  def inProgressRequestedOnDate(num: String): WebElement = cssSelector(s"#in-progress > table > tbody > tr:nth-child($num) > th").webElement
  def inProgressAmountClaimed(num: String): WebElement = cssSelector(s"#in-progress > table > tbody > tr:nth-child($num) > td.govuk-table__cell.govuk-table__cell--numeric.no-break").webElement
  def viewProcessing(num: String): WebElement = cssSelector(s"#in-progress > table > tbody > tr:nth-child($num) > td:nth-child(3) > a").webElement

  // History
  def historyTab: WebElement = id("tab_completed").webElement
  def historyRequestedOnDate(num: String): WebElement = cssSelector(s"#completed > table > tbody > tr:nth-child($num) > th").webElement
  def history(num: String): WebElement = cssSelector(s"#completed > table > tbody > tr:nth-child($num) > td:nth-child(2)").webElement
  def historyAmountClaimed(num: String): WebElement = cssSelector(s"#completed > table > tbody > tr:nth-child($num) > td.govuk-table__cell.govuk-table__cell--numeric.no-break").webElement
  def historyRejected(num: String): WebElement = cssSelector(s"#completed > table > tbody > tr:nth-child($num) > td:nth-child(4) > a").webElement


  def assertContent(tab: String): Assertion = {
    tab match {
      case "In Progress" => if (langToggle == Language.welsh) pageContent should be(WelshContent.refundHistoryInProgressPageText()) else pageContent should be(EnglishContent.refundHistoryInProgressPageText())
      case "History" => if (langToggle == Language.welsh) pageContent should be(WelshContent.refundHistoryHistoryPageText()) else pageContent should be(EnglishContent.refundHistoryHistoryPageText())
    }
  }

  def clickTab(tab: String): Unit ={
    tab match {
      case "In Progress" => click on inProgressTab
      case "History" => click on historyTab
    }
  }

  def clickProcessingOrApproved(num: String): Unit ={
    click on inProgressTab
    click on viewProcessing(num)
  }

  def clickPaidOrRejected(num: String): Unit ={
    click on historyTab
    click on historyRejected(num)
  }
}
