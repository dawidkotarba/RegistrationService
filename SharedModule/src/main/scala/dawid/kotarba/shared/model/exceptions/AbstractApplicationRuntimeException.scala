package dawid.kotarba.shared.model.exceptions

import java.time.LocalDateTime
import java.util.UUID

/**
  * Created by Dawid on 12.07.2016.
  */
abstract class AbstractApplicationRuntimeException(val exceptionType: ExceptionType.Value, val message: String, val cause: Throwable)
  extends RuntimeException(message, cause) {

  val uuid = UUID.randomUUID
  val timestamp = LocalDateTime.now
  var parameters = Seq[String]()

  def this(exceptionType: ExceptionType.Value, message: String) = this(exceptionType, message, null)

  def this(exceptionType: ExceptionType.Value, cause: Throwable) = this(exceptionType, null, cause)

  def addParams(params: String*): AbstractApplicationRuntimeException = {
    parameters ++= params
    this
  }
}
