package dawid.kotarba.shared.config.extendable

import dawid.kotarba.shared.utils.SecurityUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.security.config.annotation.web.builders.{HttpSecurity, WebSecurity}
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.{EnableResourceServer, ResourceServerConfigurerAdapter}
import org.springframework.security.oauth2.provider.token.{RemoteTokenServices, ResourceServerTokenServices}

/**
  * Created by Dawid on 03.07.2016.
  */

class OauthSecurityConfig extends WebSecurityConfigurerAdapter {
  override def configure(http: HttpSecurity): Unit = {
    http.authorizeRequests.anyRequest.permitAll

    // TODO: remove disable csrf
    SecurityUtils.disableCsrfAndFrameOptions(http)
  }

  override def configure(web: WebSecurity): Unit = SecurityUtils.ignoreSwaggerPages(web)

  @Configuration
  @EnableResourceServer
  class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${oauth.token.endpoint}")
    private val oauthTokenEndpoint: java.lang.String = null

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

}