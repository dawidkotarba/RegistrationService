package dawid.kotarba.common.service

/**
  * Created by Dawid on 17.07.2016.
  */
trait LocalizationService {
  def getMessage(code: String): String

  def getMessage(code: String, args: Array[Object]): String
}
