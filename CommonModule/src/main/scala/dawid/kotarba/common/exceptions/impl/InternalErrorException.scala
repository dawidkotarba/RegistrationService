package dawid.kotarba.common.exceptions.impl

import dawid.kotarba.common.exceptions.{AbstractApplicationRuntimeException, ExceptionType}

/**
  * Created by Dawid on 14.07.2016.
  */
class InternalErrorException(message: String, cause: Throwable)
  extends AbstractApplicationRuntimeException(ExceptionType.INTERNAL_ERROR, message, cause) {

  def this(message: String) = this(message, null)

  def this(cause: Throwable) = this(null, cause)
}
