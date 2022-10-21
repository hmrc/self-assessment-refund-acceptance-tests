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

object RequestReceivedPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-request-confirmation"
  val selfAssessmentTaxAccountLinkText: String = if (langToggle == Language.welsh) "cyfrif CThEM ar-lein" else "HMRC online account"
  val printPreviewLinkText: String = if (langToggle == Language.welsh) "argraffu neu lawrlwytho" else "print or download"
  val tellUsLinkText: String = if (langToggle == Language.welsh) "Rhowch wybod i ni beth yw eich barn am y gwasanaeth hwn" else "Tell us what you think of this service."
  val problemWithPageLinkText = "div.govuk-\\!-display-none-print > a"

    override def assertCurrentUrl(): Assertion = {
      currentUrl should fullyMatch regex s"""$url/[a-z0-9]{12}""".r
    }

  def expectedPageTitle = {
    if (langToggle == Language.welsh) "Cais am ad-daliad wedi dod i law - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "Refund request received - Request a Self Assessment refund - GOV.UK"
  }

  def expectedPageHeader = {
    if (langToggle == Language.welsh) "Cais am ad-daliad wedi dod i law"
    else "Refund request received"
  }

  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def referenceNumber: String = cssSelector("span.line-break > strong").webElement.getText

  def referenceContent: String = cssSelector("div.govuk-panel.govuk-panel--confirmation > div").webElement.getText

  def taxValue: String = cssSelector("tr:nth-child(1) > td").webElement.getText

  def dateValue: String = cssSelector("tr:nth-child(2) > td").webElement.getText

  def amountValue: String = cssSelector("tr:nth-child(3) > td").webElement.getText

  def pageContent: String = id("main-content").webElement.getText

  def setReferenceNumber(): Unit = {
    TestData.referenceNumber = referenceNumber
  }

  def assertContent(): Assertion = {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.requestReceivedPageText())
    else pageContent should be(EnglishContent.requestReceivedPageText())
  }

  def referenceNumberDisplayed(): Assertion = {
    if (langToggle == Language.welsh)
      referenceContent should fullyMatch regex
        s"""Cyfeirnod eich ad-daliad yw
           |[a-z0-9]{12}""".stripMargin.r
    else
      referenceContent should fullyMatch regex
        s"""Your refund reference is
           |[a-z0-9]{12}""".stripMargin.r
  }

  //  def refundDetailsCorrect(): Unit = {
  //    val tax: String = TestData.refundType
  //    val date: String = TestData.dateValue
  //    val amount: String = TestData.amountValue
  //    taxValue should be(tax)
  //    dateValue should be(date)
  //    amountValue should be(amount)
  //  }

  def clickSelfAssessmentTaxAccountLinkText(): Unit = {
    click on linkText(selfAssessmentTaxAccountLinkText)
  }

  def clickTellUsLinkText(): Unit = {
    click on linkText(tellUsLinkText)
    SurveyPage.shouldBeLoaded()
  }

}
