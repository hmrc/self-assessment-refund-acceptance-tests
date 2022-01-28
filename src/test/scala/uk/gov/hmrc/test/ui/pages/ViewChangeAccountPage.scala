///*
// * Copyright 2022 HM Revenue & Customs
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package uk.gov.hmrc.test.ui.pages
//
//import org.openqa.selenium.WebElement
//import uk.gov.hmrc.test.ui.testdata.TestData
//import uk.gov.hmrc.test.ui.utils.Configuration.testConfig
//
//object ViewChangeAccountPage extends BasePage {
//
//  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/view-change-account"
//
//  def expectedPageTitle = "Your payment details - Request a Self Assessment Refund - GOV.UK"
//  def expectedPageHeader = "What you owe"
//  def expectedPageTitleError: String = "Error: " + expectedPageTitle
//
//  def claimRefund: WebElement = id("claim-a-refund").webElement
//  def totalRefund: WebElement = xpath("//*[@id=\"main-content\"]/div/div/div[1]/div[1]/p[2]").webElement
//  def creditAmount: WebElement = xpath("//*[@id=\"main-content\"]/div/div/div[1]/div[2]/p[2]").webElement
//  def pageContent: String = id("main-content").webElement.getText
//
//////  def assertContent(): Assertion =  {
//////    pageContent should be(EnglishContent.viewChangeAccountPageText())
//////  }
////
////  def clickClaimRefund(): Unit = {
////    click on claimRefund
////  }
////
////  def refundCreditAmount(): Unit = {
////    val totalRefunds: String = TestData.totalRefunds
//////    val amount: String = TestData.maxRefundAmount
////    val amount: String = "545.32"
////    totalRefund.getText should be("£" + totalRefunds)
////    creditAmount.getText should be("+£" + amount + "\nClaim a refund")
////  }
////
////}
//
