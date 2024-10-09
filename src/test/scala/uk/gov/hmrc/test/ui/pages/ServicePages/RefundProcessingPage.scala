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

package uk.gov.hmrc.test.ui.pages.ServicePages

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object RefundProcessingPage extends BasePage {

  val url: String = s"${testConfig.saTrackRefundJourneyFrontendUrl}/refund-being-processed"

  override def assertCurrentUrl(): Assertion =
    currentUrl should fullyMatch regex s"""$url/[0-9]{3}""".r

  def expectedPageTitle            = s"Your refund of £1,000.00 is being processed - Track a Self Assessment refund - GOV.UK"
  def expectedPageHeader           = s"Your refund of £1,000.00 is being processed"
  override def expectedPageService = "Track a Self Assessment refund"

}
