package dawid.kotarba.common.config.optional

import dawid.kotarba.common.utils.SecurityUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.{HttpSecurity, WebSecurity}
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.{EnableResourceServer, ResourceServerConfigurerAdapter}
import org.springframework.security.oauth2.provider.token.{RemoteTokenServices, ResourceServerTokenServices}

/**
  * Created by Dawid on 03.07.2016.
  */

class OAuthSecurityConfig extends WebSecurityConfigurerAdapter {
  override def configure(http: HttpSecurity): Unit = {
    http.authorizeRequests.anyRequest.permitAll

    // TODO: remove disable csrf
    SecurityUtils.disableCsrfAndFrameOptions(http)
  }

  override def configure(web: WebSecurity): Unit = SecurityUtils.ignoreSwaggerPages(web)
}

@EnableResourceServer
class OAuthResourceServerConfig extends ResourceServerConfigurerAdapter {

  @Value("${oauth.token.endpoint}")
  private val oauthTokenEndpoint: java.lang.String = null

  @Value("${auth.username}")
  val authClient: String = null

  @Value("${auth.secret}")
  val authSecret: String = null

  override def configure(http: HttpSecurity): Unit = http.authorizeRequests.anyRequest.authenticated

  @Bean
  def resourceServerTokenServices(): ResourceServerTokenServices = {
    val remoteTokenServices = new RemoteTokenServices
    remoteTokenServices.setCheckTokenEndpointUrl(oauthTokenEndpoint)
    remoteTokenServices.setClientId(authClient)
    remoteTokenServices.setClientSecret(authSecret)
    remoteTokenServices
  }
}