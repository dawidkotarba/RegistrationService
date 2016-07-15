package dawid.kotarba.shared.service

import org.springframework.security.config.annotation.web.builders.{HttpSecurity, WebSecurity}
import org.springframework.util.DigestUtils

/**
  * Created by Dawid on 09.07.2016.
  */
object SecurityHelper {

  def disableCsrfAndFrameOptions(http: HttpSecurity): Unit = {
    http.csrf.disable
    http.headers.frameOptions.disable
  }

  def ignoreSwaggerPages(web: WebSecurity): Unit =
    web.ignoring.antMatchers("/v2/api-docs", "/configuration/ui",
      "/swagger-resources/configuration/ui", "/swagger-resources",
      "/configuration/security", "/swagger-ui.html", "/webjars/**")

  def md5(data: String): String = {
    DigestUtils.md5DigestAsHex(data.getBytes())
  }
}
