package uk.gov.hmrc.test.ui.pages.content

import uk.gov.hmrc.test.ui.stepdefs.other.ScenarioVariables
import uk.gov.hmrc.test.ui.testdata.BankDetails.{validAccountBusiness, validAccountPersonal}
import uk.gov.hmrc.test.ui.testdata.{BankDetails, TestData}

object WelshContent {

  def accountOnFilePageText(): String = {
    s"""Mae angen i ni gael eich manylion banc
       |Os gwnaethoch dalu’ch Hunanasesiad â cherdyn credyd neu ddebyd, byddwn yn ceisio ad-dalu’r arian i’ch cerdyn. Mae angen eich manylion banc arnom rhag ofn na allwn wneud hyn.
       |Dewiswch ‘Yn eich blaen’ i roi’ch manylion banc.
       |Yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
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

    s"""Gwiriwch eich manylion
       |Enw ar y cyfrif
       |Cod didoli
       |Rhif y cyfrif
       |Rhif rôl y gymdeithas adeiladu
       |${bankDetails.accName}
       |${bankDetails.sortcode}
       |${bankDetails.accNumber}
       |${bankDetails.roll} Newidrhif cais blaenorol
       |Swm i’w ad-dalu
       |£$amount Newidrhif cais blaenorol
       |Cadarnhewch eich manylion er mwyn cwblhau’ch cais am ad-daliad.
       |Cadarnhau ac yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def enterBankDetailsPageText(): String = {
    s"""Nodwch fanylion y cyfrif banc neu'r cyfrif cymdeithas adeiladu
       |Dim ond er mwyn talu’ch ad-daliad y byddwn yn defnyddio’r manylion hyn.
       |Enw ar y cyfrif
       |Cod didoli
       |Mae’n rhaid iddo fod yn 6 digid
       |Rhif y cyfrif
       |Mae’n rhaid iddo fod rhwng 6 ac 8 digid
       |Rhif rôl y gymdeithas adeiladu (os oes gennych un)
       |Gallwch ddod o hyd iddo ar eich cerdyn, cyfriflen neu baslyfr
       |Yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def requestReceivedPageText(): String = {
    //TODO - Link this to test data values
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
    //TODO - Link this to test data values
    val amount: String = TestData.maxRefundAmount
    s"""Faint o ad-daliad yr hoffech ei gael?
       |Ad-daliad o’r swm llawn
       |Ad-daliad am swm gwahanol
       |Nodwch swm
       |Nodwch swm hyd at £$amount
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

    //TODO Get Welsh Translation!
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
    //TODO Get Welsh Translation!
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
    s"""Mae’ch ad-daliad o £$completedAmountValue wedi’i gwblhau
       |Byddwn yn anfon eich ad-daliad i’r cyfrif banc a nodwyd gennych neu i’r cerdyn a ddefnyddiwyd gennych i dalu’ch bil diwethaf.
       |Dylech aros 3 i 5 diwrnod i’r arian gyrraedd eich cyfrif banc neu’ch cerdyn.
       |Yn ôl i’r cyfrif treth
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def statusPendingPageText(): String = {
    //TODO Test Data object
    val pendingAmountValue: String = TestData.inProgessAmount1
    s"""Mae’ch ad-daliad o £$pendingAmountValue ar y gweill
       |Mae’ch cais am ad-daliad wedi dod i law. Bwriad CThEM yw anfon ad-daliadau cyn pen pythefnos, ond mae mesurau diogelwch ar waith a allai achosi oedi.
       |Dylech aros 30 diwrnod cyn cysylltu â ni ynglŷn â’ch cais.
       |Yn ôl i’r cyfrif treth
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def statusRejectedPageText(): String = {
    //TODO Test Data object
    val rejectedAmountValue: String = TestData.rejectedAmount1
    s"""Mae’ch ad-daliad o £$rejectedAmountValue wedi’i wrthod
       |Ni allwn ad-dalu’r £$rejectedAmountValue oherwydd bod eich cais am ad-daliad wedi’i wrthod.
       |Yn ôl i’r cyfrif treth
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }


  // template function
  def templateText(): String = {
    s"""
       |
       |""".stripMargin
  }

}