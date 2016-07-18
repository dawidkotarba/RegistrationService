package dawid.kotarba.shared.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
  * Created by Dawid on 18.07.2016.
  */
object DateTimeUtils {
  val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  def formatDate(localDateTime: LocalDateTime): String = localDateTime.format(formatter)
}
