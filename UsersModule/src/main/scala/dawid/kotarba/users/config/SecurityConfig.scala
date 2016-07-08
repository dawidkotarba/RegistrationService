package dawid.kotarba.users.config

import dawid.kotarba.shared.config.utils.ConfigUtils
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.{EnableWebSecurity, WebSecurityConfigurerAdapter}

/**
  * Created by Dawid on 03.07.2016.
  */

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
  override def configure(http: HttpSecurity): Unit = {
    http.authorizeRequests.antMatchers("/*").permitAll

    // TODO: remove disable csrf
    ConfigUtils.disableCsrf(http)
  }
}
