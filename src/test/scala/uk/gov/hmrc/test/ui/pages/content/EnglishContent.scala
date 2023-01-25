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

package uk.gov.hmrc.test.ui.pages.content

import uk.gov.hmrc.test.ui.testdata.BankDetails.{businessAccount, validAccount}
import uk.gov.hmrc.test.ui.testdata.{BankDetails, ScenarioContext, TestData}

import java.time.{LocalDate, LocalDateTime}
import java.time.format.DateTimeFormatter

object EnglishContent {

  def accountOnFilePageText(): String = {
    s"""We need to get your bank details
       |If you paid your Self Assessment by credit or debit card, we'll try to refund you back to your card. We need your bank details in case we can not do this.
       |Select ’continue’ to provide your bank details.
       |Continue
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def checkDetailsPageNoRollText(): String = {
    var accType: String = ScenarioContext.get("personalOrBusiness")
    val amount: String = ScenarioContext.get("amount")
    def bankDetails: BankDetails = ScenarioContext.get[BankDetails]("bankDetails")
    var sortCode = ""


    sortCode = bankDetails.sortcode.replace("-", "").replace(" ", "")
    accType = accType.capitalize

    s"""Check your details
       |Account type
       |$accType Change
       |account type
       |Name on the account ${bankDetails.accName} Change
       |bank details
       |Sort code $sortCode
       |Account number ${bankDetails.accNumber}
       |Amount to be repaid
       |£$amount Change
       |refund amount
       |Confirm your details to complete your refund request.
       |Confirm and continue
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def checkDetailsPageText(): String = {
    var accType: String = ScenarioContext.get("personalOrBusiness")
    val amount: String = ScenarioContext.get("amount")
    def bankDetails: BankDetails = ScenarioContext.get[BankDetails]("bankDetails")
    var sortCode = ""

    sortCode = bankDetails.sortcode.replace("-","").replace(" ","")
    accType = accType.capitalize

    s"""Check your details
       |Account type
       |$accType Change
       |account type
       |Name on the account ${bankDetails.accName} Change
       |bank details
       |Sort code $sortCode
       |Account number ${bankDetails.accNumber}
       |Building society number ${bankDetails.roll}
       |Amount to be repaid
       |£$amount Change
       |refund amount
       |Confirm your details to complete your refund request.
       |Confirm and continue
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def enterBankDetailsPageText(): String = {
    s"""Enter bank or building society account details
       |We’ll only use these details to pay your refund.
       |Name on the account
       |Bank details
       |Sort code
       |Must be 6 digits long
       |Account number
       |Must be between 6 and 8 digits long
       |Building society roll number (if you have one)
       |You can find it on your card, statement or passbook
       |Continue
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def requestReceivedPageText(): String = {
    val reference: String = TestData.referenceNumber
    val refundType: String = TestData.refundType
    val date: String = LocalDate.now().format(DateTimeFormatter.ofPattern("d MMMM yyyy"))
    val amount: String = ScenarioContext.get("amount")
    s"""Refund request received
       |Your refund reference is
       |$reference
       |Tax Self Assessment
       |Date $date
       |Amount to be repaid £$amount
       |What happens next
       |We will send your refund to the bank details you provided or the card you used to pay your last bill.
       |HMRC aims to issue refunds within 2 weeks. However to protect you against fraud, HMRC has security measures in place which may cause a delay. Please allow 30 days before contacting us about your request.
       |You can check the status of your refund on your HMRC online account.
       |You can print or print to PDF a copy of your refund request.
       |
       |Help us improve our services
       |We use your feedback to make our services better.
       |Tell us what you think of this service (takes 30 seconds)
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def refundAmountPageText(): String = {
    println(ScenarioContext.get("nino"))
    def amount: String = if (ScenarioContext.get[String]("nino") == TestData.nino)
      TestData.maxRefundAmount
    else
      TestData.maxRefundAmount2
    s"""How much do you want to be refunded?
       |Refund the full amount, £$amount
       |Refund a different amount
       |Continue
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def ivKickoutPageText(): String = {
    s"""We could not confirm your identity
       |You have entered information that does not match our records too many times. For security reasons, you must wait 24 hours and then sign in to try again.
       |Back to your tax account
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def lockoutPageText(): String = {
    val date: String = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("d MMMM yyyy"))
    val time: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("h:mma")).toLowerCase()

    s"""You’ve tried to confirm your bank details too many times
       |Your refund request has not been submitted.
       |You’ll need to wait until $date, $time before trying to confirm your bank details again.
       |Contact HMRC by phone to speak to someone about Self Assessment.
       |Go to tax account
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def doesNotAcceptPaymentsPageText(): String = {
    s"""Your bank account does not accept payments
       |We cannot complete your refund request.
       |
       |You can try again using a different bank account.
       |Try Again
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  //Redirects to Payments Survey Service so content assertion not needed.
  def surveyPageText(): String = {
    s"""
       |
       |""".stripMargin
  }

  def typeOfAccountPageText(): String = {
    s"""What type of account details are you providing?
       |If you are applying for a refund for yourself, you can enter either your own or your agent's bank details. If you are an agent, enter your client's bank details.
       |Business bank account
       |Personal bank account
       |Continue
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def refundHistoryHistoryPageText(): String = {
    val requestedOnDate1: String = TestData.requestedOnDate1AB111111C
    val paidOnDate1: String = TestData.paidOnDate1AB111111C
    val paidAmount1: String = TestData.paidAmount1AB111111C
    val requestedOnDate2: String = TestData.requestedOnDate2AB111111C
    val rejectedDate2: String = TestData.rejectedDate2AB111111C
    val rejectedAmount1: String = TestData.rejectedAmount1AB111111C

    s"""Your refund history
       |In progress
       |History
       |History
       |Requested on Completed on Amount claimed Status Actions
       |$requestedOnDate1 $paidOnDate1 £$paidAmount1 Paid View
       |details of claim dated $requestedOnDate1
       |$requestedOnDate2 $rejectedDate2 £$rejectedAmount1 Rejected View
       |details of claim dated $requestedOnDate2
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def refundHistoryInProgressPageText(): String = {
    val inProgressDate1: String = TestData.inProgessDate1AB111111C
    val inProgressAmount1: String = TestData.inProgessAmount1AB111111C
    val approvedDate1: String = TestData.approvedDate1AB111111C
    val approvedAmount1: String = TestData.approvedAmount1AB111111C

    s"""Your refund history
       |In progress
       |History
       |In progress
       |Requested on Amount claimed Status Actions
       |$inProgressDate1 £$inProgressAmount1 Processing View
       |details of claim dated $inProgressDate1
       |$approvedDate1 £$approvedAmount1 Approved View
       |details of claim dated $approvedDate1
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def statusApprovedPageText(): String = {
    val approvedAmountValue: String = TestData.approvedAmount1AB111111C
    s"""Your refund of £$approvedAmountValue has been approved
       |We will send your refund to the bank details you provided or the card you used to pay your last bill.
       |Please allow 3 to 5 days for the money to reach your bank account or your card.
       |Back to tax account
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def statusProcessingPageText(): String = {
    val inProgressAmountValue: String = TestData.inProgessAmount1AB111111C
    s"""Your refund of £$inProgressAmountValue is in progress
       |We have received your refund request. HMRC aims to issue refunds within 2 weeks, however there are security measures in place which may cause a delay.
       |Please allow 30 days before contacting us about your request.
       |Back to tax account
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def statusRejectedPageText(): String = {
    val rejectedAmountValue: String = TestData.rejectedAmount1AB111111C
    s"""Your refund of £$rejectedAmountValue has been rejected
       |We cannot pay your refund of £$rejectedAmountValue because your request has been rejected.
       |Back to tax account
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def statusPaidPageText(): String = {
    val paidAmountValue: String = TestData.paidAmount1AB111111C
    val paidOnDate: String = TestData.paidOnDate1AB111111C
    s"""Your refund has been paid
       |We sent you a payment of £$paidAmountValue on $paidOnDate.
       |It can take 3 to 5 days for the money to reach your bank account or your card.
       |Back to tax account
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def requestFailedText(): String = {
    s"""Sorry, there is a problem with the service
       |Your refund request has not been submitted.
       |When the service is available, you will need to start again.
       |Alternatively, you can contact HM Revenue and Customs if you need to speak to someone about your Self Assessment tax or request a refund by phone.
       |Start Again
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  // template function
  def templateText(): String = {
    s"""
       |
       |""".stripMargin
  }

}
