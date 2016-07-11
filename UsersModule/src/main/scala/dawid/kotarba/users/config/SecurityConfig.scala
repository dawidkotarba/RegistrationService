package dawid.kotarba.users.config

import dawid.kotarba.shared.service.SecurityHelper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.security.config.annotation.web.builders.{HttpSecurity, WebSecurity}
import org.springframework.security.config.annotation.web.configuration.{EnableWebSecurity, WebSecurityConfigurerAdapter}
import org.springframework.security.oauth2.config.annotation.web.configuration.{EnableResourceServer, ResourceServerConfigurerAdapter}
import org.springframework.security.oauth2.provider.token.{RemoteTokenServices, ResourceServerTokenServices}

/**
  * Created by Dawid on 03.07.2016.
  */

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
  override def configure(http: HttpSecurity): Unit = {
    http.authorizeRequests.anyRequest.permitAll

    // TODO: remove disable csrf
    SecurityHelper.disableCsrfAndFrameOptions(http)
  }

  override def configure(web: WebSecurity): Unit = permitSwagger(web)

  private def permitSwagger(web: WebSecurity) = {
    web.ignoring.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
      "/swagger-ui.html", "/webjars/**")
  }
}

@Configuration
@EnableResourceServer
class ResourceServerConfigurerConfiguration extends ResourceServerConfigurerAdapter {

  @Value("${oauth.token.endpoint}")
  val oauthTokenEndpoint: java.lang.String = null

  override def configure(http: HttpSecurity): Unit = http.authorizeRequests.anyRequest.authenticated

  @Bean
  def resourceServerTokenServices(): ResourceServerTokenServices = {
    val remoteTokenServices = new RemoteTokenServices
    remoteTokenServices.setCheckTokenEndpointUrl(oauthTokenEndpoint)
    remoteTokenServices.setClientId("clientId")
    remoteTokenServices.setClientSecret("clientSecret")
    remoteTokenServices
  }
}