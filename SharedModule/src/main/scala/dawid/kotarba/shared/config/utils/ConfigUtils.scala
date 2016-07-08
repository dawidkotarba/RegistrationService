package dawid.kotarba.shared.config.utils

import org.springframework.security.config.annotation.web.builders.HttpSecurity

/**
  * Created by Dawid on 09.07.2016.
  */
object ConfigUtils {

  /**
    * Can be used to fix access to H2 db menu
    * @param http
    */
  def disableCsrf(http: HttpSecurity): Unit = {
    http.csrf.disable
    http.headers.frameOptions.disable
  }
}
