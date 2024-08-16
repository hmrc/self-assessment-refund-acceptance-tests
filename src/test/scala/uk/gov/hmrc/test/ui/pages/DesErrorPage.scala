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

import uk.gov.hmrc.test.ui.testdata.Language
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object DesErrorPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-request/failed"

  def expectedPageTitle =
    if (langToggle == Language.welsh) "Mae’n ddrwg gennym, mae problem gyda’r gwasanaeth - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "Sorry, there is a problem with the service - Request a Self Assessment refund - GOV.UK"

  def expectedPageHeader =
    if (langToggle == Language.welsh) "Mae’n ddrwg gennym, mae problem gyda’r gwasanaeth"
    else "Sorry, there is a problem with the service"

  def startAgainHref(): Unit = {
    cssSelector("#main-content > div > div > a").webElement(driver).getAttribute("href").toString should be("https://www.tax.service.gov.uk/report-quarterly/income-and-expenses/view/claim-refund")
  }

  def clickContactLink(): Unit = {
    click on cssSelector("p:nth-child(4) > a")
  }

}
