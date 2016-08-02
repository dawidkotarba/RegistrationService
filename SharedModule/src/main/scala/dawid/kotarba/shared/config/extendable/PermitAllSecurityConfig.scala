package dawid.kotarba.shared.config.extendable

import dawid.kotarba.shared.utils.SecurityUtils
import org.springframework.security.config.annotation.web.builders.{HttpSecurity, WebSecurity}
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
  * Created by Dawid on 01.08.2016.
  */

class PermitAllSecurityConfig extends WebSecurityConfigurerAdapter {
  override def configure(http: HttpSecurity): Unit = {
    SecurityUtils.disableCsrfAndFrameOptions(http)
    http.authorizeRequests.anyRequest.permitAll
  }

  override def configure(web: WebSecurity): Unit = web.ignoring.anyRequest
}