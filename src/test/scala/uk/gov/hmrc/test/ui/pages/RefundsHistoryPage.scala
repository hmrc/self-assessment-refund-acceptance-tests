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
import uk.gov.hmrc.test.ui.testdata.{Language, TestData}
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object RefundsHistoryPage extends BasePage {

  val nino: String = TestData.nino

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-history#in-progress"

  def expectedPageTitle = {
    if (langToggle == Language.welsh) "Hanes eich ad-daliad - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "Your refund history - Request a Self Assessment refund - GOV.UK"
  }
  def expectedPageHeader = {
    if (langToggle == Language.welsh) "Hanes eich ad-daliad"
    else "Your refund history"
  }

  //In Progress
  def inProgressTab: WebElement = id("tab_in-progress").webElement(driver)
  def inProgressRequestedOnDate(num: String): WebElement = cssSelector(s"#in-progress > div > table > tbody > tr:nth-child($num) > th").webElement(driver)
  def inProgressAmountClaimed(num: String): WebElement = cssSelector(s"#in-progress > div > table > tbody > tr:nth-child($num) > td.govuk-table__cell.govuk-table__cell--numeric.no-break").webElement(driver)
  def viewProcessing(num: String): WebElement = cssSelector(s"#in-progress > div > table > tbody > tr:nth-child($num) > td:nth-child(4) > a").webElement(driver)

  // History
  def historyTab: WebElement = id("tab_history").webElement(driver)
  def historyRequestedOnDate(num: String): WebElement = cssSelector(s"#completed > div > table > tbody > tr:nth-child($num) > th").webElement(driver)
  def history(num: String): WebElement = cssSelector(s"#completed > div > table > tbody > tr:nth-child($num) > td:nth-child(2)").webElement(driver)
  def historyAmountClaimed(num: String): WebElement = cssSelector(s"#history > div > table > tbody > tr:nth-child($num) > td.govuk-table__cell.govuk-table__cell--numeric.no-break").webElement(driver)
  def historyRejected(num: String): WebElement = cssSelector(s"#history > div > table > tbody > tr:nth-child($num) > td:nth-child(5) > a").webElement(driver)

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
