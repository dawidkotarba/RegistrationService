package dawid.kotarba.common.exceptions

import java.time.LocalDateTime
import java.util.UUID

import dawid.kotarba.common.exceptions.ExceptionType.ExceptionType

/**
  * Created by Dawid on 12.07.2016.
  */
abstract class AbstractApplicationRuntimeException(val exceptionType: ExceptionType, val message: String, val cause: Throwable)
  extends RuntimeException(message, cause) {

  val uuid = UUID.randomUUID
  val timestamp = LocalDateTime.now
  var parameters = Seq[String]()

  def this(exceptionType: ExceptionType, message: String) = this(exceptionType, message, null)

  def this(exceptionType: ExceptionType, cause: Throwable) = this(exceptionType, null, cause)

  def addParams(params: String*): AbstractApplicationRuntimeException = {
    parameters ++= params
    this
  }
}
