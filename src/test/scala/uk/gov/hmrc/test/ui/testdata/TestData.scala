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

package uk.gov.hmrc.test.ui.testdata

import uk.gov.hmrc.test.ui.pages.SurveyPage.langToggle

//import java.time.LocalDate
//import java.time.format.DateTimeFormatter

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
//  val dateValue: String = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))

  //In Progress Tab
  def inProgessDate1 = if (langToggle == Language.welsh) "5 Gorffennaf 2021" else "5 July 2021"
  def inProgessDate2 = if (langToggle == Language.welsh) "21 Mai 2021" else "21 May 2021"
  val inProgessAmount1 = "200.00"
  val inProgessAmount2 = "300.00"
  def approvedDate1 = if (langToggle == Language.welsh) "21 Gorffennaf 2020" else "21 July 2020"
  def approvedDate2 = if (langToggle == Language.welsh) "1 Mai 2019" else "1 May 2019"
  def approvedDate3 = if (langToggle == Language.welsh) "13 Medi 2018" else "13 September 2018"
  def approvedDate4 = if (langToggle == Language.welsh) "13 Mehefin 2015" else "13 June 2015"
  val approvedAmount1 = "120.00"
  val approvedAmount2 = "40.00"
  val approvedAmount3 = "80.00"
  val approvedAmount4 = "80.00"


  //History Tab
  def requestedOnDate1 = if (langToggle == Language.welsh) "1 Hydref 2019" else "1 October 2019"
  def requestedOnDate2 = if (langToggle == Language.welsh) "1 Ebrill 2019" else "1 April 2019"
  def paidOnDate1 = if (langToggle == Language.welsh) "4 Hydref 2019" else "4 October 2019"
  def rejectedDate2 = if (langToggle == Language.welsh) "4 Ebrill 2019" else "4 April 2019"
  val paidAmount1 = "40.00"
  val rejectedAmount1 = "40.00"





  val nino2 = "AC111111A"
  val maxRefundAmount2 = "987.65"

}
