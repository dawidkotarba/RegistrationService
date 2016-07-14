package dawid.kotarba.shared.model.exceptions.impl

import dawid.kotarba.shared.model.exceptions.{AbstractApplicationRuntimeException, ExceptionType}

/**
  * Created by Dawid on 14.07.2016.
  */
class NotFoundException(message: String, cause: Throwable)
  extends AbstractApplicationRuntimeException(ExceptionType.NOT_FOUND, message, cause) {

  def this(message: String) = this(message, null)

  def this(cause: Throwable) = this(null, cause)
}
