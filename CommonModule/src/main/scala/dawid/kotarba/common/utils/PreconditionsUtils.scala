package dawid.kotarba.common.utils

import com.google.common.base.Preconditions

/**
  * Created by Dawid on 09.07.2016.
  */
object PreconditionsUtils {

  def checkNotNull[T](reference: T, referenceName: String): Unit = {
    Preconditions.checkNotNull(reference, "%s cannot be null", referenceName)
  }
}
