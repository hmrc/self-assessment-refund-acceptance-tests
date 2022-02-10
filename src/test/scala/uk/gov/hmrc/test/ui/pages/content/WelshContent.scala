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
import uk.gov.hmrc.test.ui.testdata.{BankDetails, Language, ScenarioContext, TestData}

object WelshContent {

  def accountOnFilePageText(): String = {
    s"""Mae angen i ni gael eich manylion banc
       |Os gwnaethoch dalu’ch Hunanasesiad â cherdyn credyd neu ddebyd, byddwn yn ceisio ad-dalu’r arian i’ch cerdyn. Mae angen eich manylion banc arnom rhag ofn na allwn wneud hyn.
       |Dewiswch ‘Yn eich blaen’ i roi’ch manylion banc.
       |Yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
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
        accType = "Personol"
      case "business" => bankDetails = validAccountBusiness
        accType = "Busnes"
    }

    s"""Gwiriwch eich manylion
       |Math o Gyfrif
       |$accType Newid
       |y math o gyfrif
       |Enw ar y cyfrif
       |Cod didoli
       |Rhif y cyfrif
       |Rhif rôl y gymdeithas adeiladu
       |${bankDetails.accName}
       |${bankDetails.sortcode}
       |${bankDetails.accNumber}
       |${bankDetails.roll} Newid
       |y manylion banc
       |Swm i’w ad-dalu
       |£$amount Newid
       |swm yr ad-daliad
       |Cadarnhewch eich manylion er mwyn cwblhau’ch cais am ad-daliad.
       |Cadarnhau ac yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def enterBankDetailsPageText(): String = {
    s"""Nodwch fanylion y cyfrif banc neu'r cyfrif cymdeithas adeiladu
       |Dim ond er mwyn talu’ch ad-daliad y byddwn yn defnyddio’r manylion hyn.
       |Enw ar y cyfrif
       |Cod didoli
       |Mae’n rhaid iddo fod yn 6 digid o hyd
       |Rhif y cyfrif
       |Mae’n rhaid iddo fod rhwng 6 ac 8 digid o hyd
       |Rhif rôl y gymdeithas adeiladu (os oes gennych un)
       |Gallwch ddod o hyd iddo ar eich cerdyn, cyfriflen neu baslyfr
       |Yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def requestReceivedPageText(): String = {
    val reference: String = TestData.referenceNumber
    val refundType: String = TestData.refundType
    val date: String = TestData.dateValue
    val amount: String = TestData.refundAmount
    s"""Cais am ad-daliad wedi dod i law
       |Cyfeirnod eich ad-daliad yw
       |$reference
       |Treth $refundType
       |Dyddiad $date
       |Swm i’w ad-dalu $amount
       |Yr hyn sy’n digwydd nesaf
       |Byddwn yn anfon eich ad-daliad i’r cyfrif banc a nodwyd gennych neu i’r cerdyn a ddefnyddiwyd gennych i dalu’ch bil diwethaf.
       |Bwriad CThEM yw anfon ad-daliadau cyn pen pythefnos. Fodd bynnag, er mwyn eich diogelu rhag twyll, mae gan CThEM fesurau diogelwch ar waith a allai achosi oedi. Dylech aros 30 diwrnod cyn cysylltu â ni ynglŷn â’ch cais.
       |Gallwch wirio statws eich ad-daliad yn eich cyfrif CThEM ar-lein.
       |Gallwch argraffu neu lawrlwytho copi o’ch cais am ad-daliad (PDF)
       |Helpu ni i wella ein gwasanaethau
       |Rydym yn defnyddio’ch adborth i wella ein gwasanaethau.
       |Rhowch wybod i ni beth yw eich barn am y gwasanaeth hwn. (mae’n cymryd 30 eiliad)
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def refundAmountPageText(): String = {
    def amount: String = if (ScenarioContext.get[String]("nino") == TestData.nino)
      TestData.maxRefundAmount
    else
      TestData.maxRefundAmount2

    s"""Faint o ad-daliad yr hoffech ei gael?
       |Ad-daliad o’r swm llawn, £$amount
       |Ad-daliad am swm gwahanol
       |Yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  //Redirects to Payments Survey Service so content assertion not needed.
  def surveyPageText(): String = {
    s"""
       |
       |""".stripMargin
  }

  def typeOfAccountPageText(): String = {
    s"""Manylion pa fath o gyfrif yr ydych yn eu rhoi?
       |Cyfrif banc busnes
       |Cyfrif banc personol
       |Yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def refundHistoryHistoryPageText(): String = {
    //TODO Confirmed Welsh translation
    val requestedOnDate1: String = TestData.requestedOnDate1
    val paidOnDate1: String = TestData.paidOnDate1
    val paidAmount1: String = TestData.paidAmount1
    val requestedOnDate2: String = TestData.requestedOnDate2
    val rejectedDate2: String = TestData.rejectedDate2
    val rejectedAmount1: String = TestData.rejectedAmount1

    s"""Hanes eich ad-daliadau
       |Ar waith
       |Hanes
       |Gofyn ar Wedi’i gwblhau ar Swm a hawliwyd
       |$requestedOnDate1 $paidOnDate1 £$paidAmount1 Talwyd
       |$requestedOnDate2 $rejectedDate2 £$rejectedAmount1 Wedi’i wrthod
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def refundHistoryInProgressPageText(): String = {
    //TODO Confirmed Welsh translation
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

    s"""Hanes eich ad-daliadau
       |Ar waith
       |Hanes
       |Gofyn ar Swm a hawliwyd
       |$inProgressDate1 £$inProgressAmount1 Wrthi’n prosesu
       |$inProgressDate2 £$inProgressAmount2 Wrthi’n prosesu
       |$approvedDate1 £$approvedAmount1 Cymeradwywyd
       |$approvedDate2 £$approvedAmount2 Cymeradwywyd
       |$approvedDate3 £$approvedAmount3 Cymeradwywyd
       |$approvedDate4 £$approvedAmount4 Cymeradwywyd
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def statusApprovedPageText(): String = {
    //TODO Confirmed Welsh translation
    val approvedAmountValue: String = TestData.approvedAmount1
    s"""Mae’ch ad-daliad o £$approvedAmountValue wedi’i gymeradwyo
       |Byddwn yn anfon eich ad-daliad i’r cyfrif banc a nodwyd gennych neu i’r cerdyn a ddefnyddiwyd gennych i dalu’ch bil diwethaf.
       |Dylech ganiatáu 3 i 5 diwrnod i’r arian gyrraedd eich cyfrif banc neu’ch cerdyn.
       |Yn ôl i’r cyfrif treth
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def statusProcessingPageText(): String = {
    val pendingAmountValue: String = TestData.inProgessAmount1
    s"""Mae’ch ad-daliad o £$pendingAmountValue ar y gweill
       |Mae’ch cais am ad-daliad wedi dod i law. Bwriad CThEM yw anfon ad-daliadau cyn pen pythefnos, ond mae mesurau diogelwch ar waith a allai achosi oedi.
       |Dylech aros 30 diwrnod cyn cysylltu â ni ynglŷn â’ch cais.
       |Yn ôl i’r cyfrif treth
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def statusRejectedPageText(): String = {
    val rejectedAmountValue: String = TestData.rejectedAmount1
    s"""Mae’ch ad-daliad o £$rejectedAmountValue wedi’i wrthod
       |Ni allwn ad-dalu’r £$rejectedAmountValue oherwydd bod eich cais am ad-daliad wedi’i wrthod.
       |Yn ôl i’r cyfrif treth
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def statusPaidPageText(): String = {
    //TODO Welsh Translation
    val paidAmountValue: String = TestData.paidAmount1
    val paidOnDate: String = TestData.paidOnDate1
    s"""Mae’ch ad-daliad wedi’i dalu
       |Gwnaethom anfon taliad o £$paidAmountValue atoch ar $paidOnDate.
       |Mae’n gallu cymryd 3 i 5 diwrnod i’r arian gyrraedd eich cyfrif banc.
       |Yn ôl i’r cyfrif treth
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

}
