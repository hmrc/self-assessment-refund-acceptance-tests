package uk.gov.hmrc.test.ui.testdata

import java.time.LocalDate
import java.time.format.DateTimeFormatter

case class TestData (nino: String,
                     totalRefunds: String,
                     maxRefundAmount: String,
                     refundType: String,
                     refundAmount: String,
                     amountValue: String,
                     inProgessDate1: String,
                     inProgessDate2: String,
                     inProgessAmount1: String,
                     inProgessAmount2: String,
                     receivedOnDate1: String,
                     receivedOnDate2: String,
                     completedOnDate1: String,
                     completedOnDate2: String,
                     completedAmount1: String,
                     completedAmount2: String,
                     rejectedAmount: String)

object TestData {

//  lazy val validTestUser1: TestData = TestData("AA111111A", )

  //TODO sort out test users and data when stubs are created - similar to the bank details class/object

  //Test User 1 details
  val nino = "AA111111A"
  var referenceNumber = ""
  val totalRefunds = "13,029.68"
  val maxRefundAmount = "123.45"
  val refundType = "Self Assessment"
  val refundAmount = "123.45"
  val amountValue = "545.80"
  //TODO placeholder as code for the page currently pulls today's date
  val dateValue: String = "TODO-DATE"
//  val dateValue: String = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))

  //In Progress Tab
  val inProgessDate1 = "21 May 2021"
  val inProgessDate2 = "05 July 2021"
  val inProgessAmount1 = "300.00"
  val inProgessAmount2 = "200.00"

  //Completed Tab
  val receivedOnDate1 = "21 July 2020"
  val receivedOnDate2 = "01 May 2019"
  val receivedOnDate3 = "01 April 2019"
  val receivedOnDate4 = "13 September 2018"
  val completedOnDate1 = "29 July 2020"
  val completedOnDate2 = "29 May 2020"
  val completedOnDate3 = "04 April 2019"
  val completedOnDate4 = "16 September 2018"
  val completedAmount1 = "120.00"
  val completedAmount2 = "40.00"
  val rejectedAmount1 = "40.00"
  val completedAmount3 = "80.00"


}
