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

package uk.gov.hmrc.test.ui.pages.testonly

import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object TestOnlyStartPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/test-only/start-journey"

  def expectedPageTitle = "TBC"
  def expectedPageHeader = "TBC"

  def clickRadio(nino: String): Unit ={
    nino match {
      case "AB111111D" => click on id("1")
      case "AB111111C" => click on id("0")
      case "AB111111C_history" => click on id("2")
      case "AB111111D_history" => click on id("3")
      case _ => click on id("0") // to populate the rest of fields, nino will be changed in next step
    }
    clickSelectPreset()
  }

  def clickSelectPreset(): Unit = {
    click on cssSelector("#main-content > form:nth-child(5) > button")
  }

  def overwriteNino(nino: String): Unit = {
    id("nino").webElement.clear()
    id("nino").webElement.sendKeys(nino)
  }

}
