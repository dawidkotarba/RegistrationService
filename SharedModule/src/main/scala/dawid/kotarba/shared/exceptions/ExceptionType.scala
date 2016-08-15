package dawid.kotarba.shared.exceptions

/**
  * Created by Dawid on 12.07.2016.
  */
object ExceptionType extends Enumeration {
  type ExceptionType = Value
  val NOT_FOUND, INTERNAL_ERROR, BAD_CREDENTIALS = Value
}
