package uk.gov.hmrc.test.ui.testdata

object ScenarioContext {

  private var variables: Map[String, Any] = Map.empty

  def set(key: String, value: Any): Unit = variables = variables + (key -> value)

  def get[T](key: String): T = {
    variables
      .get(key)
      .fold(throw new NoSuchElementException(s"Scenario variable is not found: [$key]"))(_.asInstanceOf[T])
  }

  def getOrElse[T](key: String, elseResult: T): T = {
    variables
      .get(key)
      .fold(elseResult)(_.asInstanceOf[T])
  }

  def remove(key: String): Unit = variables = variables - key

  def reset(): Unit = variables.foreach { case (key, _) => remove(key) }

}
