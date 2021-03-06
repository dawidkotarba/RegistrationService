package dawid.kotarba.users.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.{HttpSecurity, WebSecurity}
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {
  override def configure(http: HttpSecurity): Unit =
    http.authorizeRequests.anyRequest.permitAll

  override def configure(web: WebSecurity): Unit = web.ignoring.anyRequest
}