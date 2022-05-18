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

import uk.gov.hmrc.test.ui.testdata.BankDetails.{validAccountBusiness, validAccountPersonal}
import uk.gov.hmrc.test.ui.testdata.{BankDetails, ScenarioContext, TestData}

object EnglishContent {

  def accountOnFilePageText(): String = {
    s"""We need to get your bank details
       |If you paid your Self Assessment by credit or debit card, we'll try to refund you back to your card. We need your bank details in case we can not do this.
       |Select ’continue’ to provide your bank details.
       |Continue
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def checkDetailsPageText(): String = {
    var accType: String = ScenarioContext.get("personalOrBusiness")

    def amount: String = if (ScenarioContext.get[String]("nino") == TestData.nino)
      TestData.maxRefundAmount
    else
      TestData.maxRefundAmount2

    var bankDetails: BankDetails = null

    accType match {
      case "personal" => bankDetails = validAccountPersonal
      case "business" => bankDetails = validAccountBusiness
    }

    accType = accType.capitalize

    s"""Check your details
       |Account type
       |$accType Change
       |account type
       |Name on the account
       |Sort code
       |Account number
       |Building society number
       |${bankDetails.accName}
       |${bankDetails.sortcode}
       |${bankDetails.accNumber}
       |${bankDetails.roll} Change
       |bank details
       |Amount to be repaid
       |£$amount Change
       |refund amount
       |Confirm your details to complete your refund request.
       |Confirm and continue
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def enterBankDetailsPageText(): String = {
    s"""Enter the bank or building society account details
       |We’ll only use these details to pay your refund.
       |Name on the account
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
    val date: String = TestData.dateValue
    val amount: String = TestData.refundAmount
    s"""Refund request received
       |Your refund reference is
       |$reference
       |Tax $refundType
       |Date $date
       |Amount to be refunded £$amount
       |What happens next
       |We will send your refund to the bank details you provided or the card you used to pay your last bill.
       |HMRC aims to issue refunds within 2 weeks. However to protect you against fraud, HMRC has security measures in place which may cause a delay. Please allow 30 days before contacting us about your request.
       |You can check the status of your refund on your HMRC online account.
       |You can print or download a copy of your refund request (PDF)
       |Help us improve our services
       |We use your feedback to make our services better.
       |Tell us what you think of this service (takes 30 seconds)
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def refundAmountPageText(): String = {
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

  //Redirects to Payments Survey Service so content assertion not needed.
  def surveyPageText(): String = {
    s"""
       |
       |""".stripMargin
  }

  def typeOfAccountPageText(): String = {
    s"""What type of account details are you providing?
       |Business bank account
       |Personal bank account
       |Continue
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def refundHistoryHistoryPageText(): String = {
    val requestedOnDate1: String = TestData.requestedOnDate1
    val paidOnDate1: String = TestData.paidOnDate1
    val paidAmount1: String = TestData.paidAmount1
    val requestedOnDate2: String = TestData.requestedOnDate2
    val rejectedDate2: String = TestData.rejectedDate2
    val rejectedAmount1: String = TestData.rejectedAmount1

    s"""Your refunds history
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
    val inProgressDate1: String = TestData.inProgessDate1
    val inProgressDate2: String = TestData.inProgessDate2
    val inProgressAmount1: String = TestData.inProgessAmount1
    val inProgressAmount2: String = TestData.inProgessAmount2
    val approvedDate1: String = TestData.approvedDate1
    val approvedDate2: String = TestData.approvedDate2
    val approvedDate3: String = TestData.approvedDate3
    val approvedDate4: String = TestData.approvedDate4
    val approvedAmount1: String = TestData.approvedAmount1
    val approvedAmount2: String = TestData.approvedAmount2
    val approvedAmount3: String = TestData.approvedAmount3
    val approvedAmount4: String = TestData.approvedAmount4

    s"""Your refunds history
       |In progress
       |History
       |In progress
       |Requested on Amount claimed Status Actions
       |$inProgressDate1 £$inProgressAmount1 Processing View
       |details of claim dated $inProgressDate1
       |$inProgressDate2 £$inProgressAmount2 Processing View
       |details of claim dated $inProgressDate2
       |$approvedDate1 £$approvedAmount1 Approved View
       |details of claim dated $approvedDate1
       |$approvedDate2 £$approvedAmount2 Approved View
       |details of claim dated $approvedDate2
       |$approvedDate3 £$approvedAmount3 Approved View
       |details of claim dated $approvedDate3
       |$approvedDate4 £$approvedAmount4 Approved View
       |details of claim dated $approvedDate4
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def statusApprovedPageText(): String = {
    val approvedAmountValue: String = TestData.approvedAmount1
    s"""Your refund of £$approvedAmountValue has been approved
       |We will send your refund to the bank details you provided or the card you used to pay your last bill.
       |Please allow 3 to 5 days for the money to reach your bank account or your card.
       |Back to tax account
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def statusProcessingPageText(): String = {
    val inProgressAmountValue: String = TestData.inProgessAmount1
    s"""Your refund of £$inProgressAmountValue is in progress
       |We have received your refund request. HMRC aims to issue refunds within 2 weeks, however there are security measures in place which may cause a delay.
       |Please allow 30 days before contacting us about your request.
       |Back to tax account
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def statusRejectedPageText(): String = {
    val rejectedAmountValue: String = TestData.rejectedAmount1
    s"""Your refund of £$rejectedAmountValue has been rejected
       |We cannot pay your refund of £$rejectedAmountValue because your request has been rejected.
       |Back to tax account
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def statusPaidPageText(): String = {
    val paidAmountValue: String = TestData.paidAmount1
    val paidOnDate: String = TestData.paidOnDate1
    s"""Your refund has been paid
       |We sent you a payment of £$paidAmountValue on $paidOnDate.
       |It can take 3 to 5 days for the money to reach your bank account or your card.
       |Back to tax account
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }
  
  // template function
  def templateText(): String = {
    s"""
       |
       |""".stripMargin
  }

}
