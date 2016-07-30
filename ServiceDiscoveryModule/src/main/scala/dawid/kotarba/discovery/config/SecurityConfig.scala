package dawid.kotarba.discovery.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.{HttpSecurity, WebSecurity}
import org.springframework.security.config.annotation.web.configuration.{EnableWebSecurity, WebSecurityConfigurerAdapter}

/**
  * Created by Dawid on 03.07.2016.
  */

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
  override def configure(http: HttpSecurity): Unit =
    http.authorizeRequests.anyRequest.permitAll

  override def configure(web: WebSecurity): Unit = web.ignoring.anyRequest
}
