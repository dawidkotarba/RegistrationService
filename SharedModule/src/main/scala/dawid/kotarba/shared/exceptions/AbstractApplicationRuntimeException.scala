package dawid.kotarba.shared.exceptions

import java.time.LocalDateTime
import java.util.UUID

/**
  * Created by Dawid on 12.07.2016.
  */
abstract class AbstractApplicationRuntimeException(exceptionType: ExceptionType.Value, message: String, cause: Throwable)
  extends RuntimeException(message, cause) {

  val uuid: UUID = UUID.randomUUID
  val timestamp = LocalDateTime.now
  val params: Array[String]

  def this(exceptionType: ExceptionType.Value, message: String) = this(exceptionType, message, null)

  def this(exceptionType: ExceptionType.Value, cause: Throwable) = this(exceptionType, null, cause)

  def addParams(params: String*): AbstractApplicationRuntimeException = {
    this.params ++ params
    this
  }
}
