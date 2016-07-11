package dawid.kotarba.shared.service

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.util.DigestUtils

/**
  * Created by Dawid on 09.07.2016.
  */
object SecurityHelper {

  def disableCsrfAndFrameOptions(http: HttpSecurity): Unit = {
    http.csrf.disable
    http.headers.frameOptions.disable
  }

  def md5(data: String): String = {
    DigestUtils.md5DigestAsHex(data.getBytes())
  }
}
