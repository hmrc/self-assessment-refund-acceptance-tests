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

package uk.gov.hmrc.test.ui.pages.ExternalPages

import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object VandCPage extends BasePage {

  val url: String = s"${testConfig.viewAndChange}/report-quarterly/income-and-expenses/view/cannot-access-service"

  def expectedPageTitle  = "You cannot access this service - GOV.UK"
  def expectedPageHeader = "You cannot access this service"

  override def shouldBeLoaded(): Unit = {
    assertCurrentUrl()
    assertCurrentPageTitle()
    assertCurrentPageHeader()
  }

}