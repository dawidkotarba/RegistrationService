package dawid.kotarba.shared.exceptions.impl

import dawid.kotarba.shared.exceptions.{AbstractApplicationRuntimeException, ExceptionType}

/**
  * Created by Dawid on 17.07.2016.
  */
class BadCredentialsException(message: String, cause: Throwable)
  extends AbstractApplicationRuntimeException(ExceptionType.BAD_CREDENTIALS, message, cause) {

  def this(message: String) = this(message, null)

  def this(cause: Throwable) = this(null, cause)
}
