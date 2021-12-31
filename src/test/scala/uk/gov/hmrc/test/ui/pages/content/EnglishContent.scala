package uk.gov.hmrc.test.ui.pages.content

import uk.gov.hmrc.test.ui.stepdefs.other.ScenarioVariables
import uk.gov.hmrc.test.ui.testdata.BankDetails.{validAccountBusiness, validAccountPersonal}
import uk.gov.hmrc.test.ui.testdata.{BankDetails, TestData}

object EnglishContent {

  def accountOnFilePageText(): String = {
    //TODO - Link this to test data values
    val amount: String = TestData.refundAmount
    s"""Your refund of £$amount
       |If you paid your tax by credit or debit card, we’ll try to repay back to your card. You need to tell us your bank details in case we cannot pay you to your card.
       |Select ’continue’ to provide your bank details.
       |Continue
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def checkDetailsPageText(): String = {
    //TODO - Link this to test data values
    val accType: String = ScenarioVariables.personalOrBusiness
    val amount: String = TestData.maxRefundAmount
    var bankDetails: BankDetails = null

    accType match {
      case "personal" => bankDetails = validAccountPersonal
      case "business" => bankDetails = validAccountBusiness
    }

    s"""Check your details
       |Account type
       |$accType	Changeprevious application number
       |Name on the account
       |Sort code
       |Account number
       |Building society number
       |${bankDetails.accName}
       |${bankDetails.sortcode}
       |${bankDetails.accNumber}
       |${bankDetails.roll}	Changeprevious application number
       |Amount to be repaid
       |£$amount	Changeprevious application number
       |Continue
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def enterBankDetailsPageText(): String = {
    s"""Bank or building society account details
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
    //TODO - Link this to test data values
    val reference: String = TestData.referenceNumber
    val refundType: String = TestData.refundType
    val date: String = TestData.dateValue
    val amount: String = TestData.refundAmount
    s"""Refund request received
       |Your refund reference is
       |$reference
       |Tax $refundType
       |Date $date
       |Amount to be repaid £$amount
       |What happens next
       |We will pay your refund to the card you last used to pay your Self Assessment tax bill.
       |HMRC aims to issue your refund within 2 weeks. However to protect you against fraud, HMRC has security measures in place which may cause a delay. Please allow 30 days before contacting us about your request.
       |You can check the status of your refund on your Self Assessment tax account.
       |You can print or download a copy of your refund request (PDF)
       |
       |Help us improve our services
       |We use your feedback to make our services better.
       |Tell us what you think of this service (takes 30 seconds)
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def selectAmountPageText(): String = {
    //TODO - Link this to test data values
    val amount: String = TestData.maxRefundAmount
    s"""How much do you want to be repaid?
       |Repay full amount, £$amount
       |Repay a different amount
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

  def viewChangeAccountPageText(): String = {
    s"""
       |
       |""".stripMargin
  }

  def refundHistoryCompletedPageText(): String = {
    val completedReceived2: String = TestData.receivedOnDate2
    val completedReceived3: String = TestData.receivedOnDate4
    val completedReceived1: String = TestData.receivedOnDate1
    val rejectedReceived1: String = TestData.receivedOnDate3
    val completedCompletedOn2: String = TestData.completedOnDate2
    val completedCompletedOn3: String = TestData.completedOnDate4
    val completedCompletedOn1: String = TestData.completedOnDate1
    val rejectedCompletedOn1: String = TestData.completedOnDate3
    val completedAmount1: String = TestData.completedAmount1
    val completedAmount2: String = TestData.completedAmount2
    val rejectedAmount1: String = TestData.rejectedAmount1
    val completedAmount3: String = TestData.completedAmount3

    //TODO Should th > 6 Years date show here - Frontend Validation?
    s"""Your refunds history
       |In progress
       |Completed
       |Received on Completed on Amount claimed
       |$completedReceived1 $completedCompletedOn1 £$completedAmount1 Completed
       |$completedReceived2 $completedCompletedOn2 £$completedAmount2 Completed
       |$rejectedReceived1 $rejectedCompletedOn1 £$rejectedAmount1 Rejected
       |$completedReceived3 $completedCompletedOn3 £$completedAmount3 Completed
       |13 June 2015 16 June 2015 £80.00 Completed
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def refundHistoryInProgressPageText(): String = {
    val inProgressDate1: String = TestData.inProgessDate1
    val inProgressDate2: String = TestData.inProgessDate2
    val inProgressAmount1: String = TestData.inProgessAmount1
    val inProgressAmount2: String = TestData.inProgessAmount2
    s"""Your refunds history
       |In progress
       |Completed
       |Received on Amount claimed
       |$inProgressDate1 £$inProgressAmount1 View progress
       |$inProgressDate2 £$inProgressAmount2 View progress
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def statusCompletedPageText(): String = {
    //TODO Test Data object
    val completedAmountValue: String = TestData.completedAmount1
    s"""Your refund of £$completedAmountValue is complete
       |We will send £$completedAmountValue to the bank details you provided or the card you used to pay your last bill.
       |Please allow 3 to 5 days for the money to reach your bank account or your card.
       |Back to tax account
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def statusPendingPageText(): String = {
    //TODO Test Data object
    val pendingAmountValue: String = TestData.inProgessAmount1
    s"""Your refund of £$pendingAmountValue is in progress
       |We have received your refund request. HMRC aims to issue refunds within 2 weeks, however there are security measures in place which may cause a delay.
       |Please allow 30 days before contacting us about your request.
       |Back to tax account
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def statusRejectedPageText(): String = {
    //TODO Test Data object
    val rejectedAmountValue: String = TestData.rejectedAmount1
    s"""Your refund of £$rejectedAmountValue has been rejected
       |We cannot make your refund of £$rejectedAmountValue because your refund request has been rejected.
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
