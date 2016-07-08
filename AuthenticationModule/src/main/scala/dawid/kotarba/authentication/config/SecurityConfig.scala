package dawid.kotarba.authentication.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration, Profile}
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.{AuthorizationServerConfigurerAdapter, EnableAuthorizationServer}
import org.springframework.security.oauth2.config.annotation.web.configurers.{AuthorizationServerEndpointsConfigurer, AuthorizationServerSecurityConfigurer}
import org.springframework.security.oauth2.provider.token.DefaultTokenServices
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore

/**
  * Created by Dawid on 06.07.2016.
  */

@Configuration
@Profile(Array("dev", "prod"))
class SecurityConfig extends WebSecurityConfigurerAdapter {
  override def configure(http: HttpSecurity): Unit = {
    http.authorizeRequests.anyRequest.permitAll
  }
}

@Configuration
@EnableAuthorizationServer
@Profile(Array("dev", "prod"))
class OAuthServerConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired
  val authenticationManager: AuthenticationManager = null

  val tokenStore = new InMemoryTokenStore

  override def configure(security: AuthorizationServerSecurityConfigurer): Unit = security.checkTokenAccess("permitAll()")

  override def configure(clients: ClientDetailsServiceConfigurer): Unit =
    clients.inMemory().withClient("clientId")
      .secret("clientSecret").authorizedGrantTypes("password")
      .autoApprove(true).scopes("read", "write")

  override def configure(endpoints: AuthorizationServerEndpointsConfigurer): Unit =
    endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)

  @Bean
  def tokenServices(): DefaultTokenServices = {
    val tokenServices = new DefaultTokenServices
    tokenServices.setSupportRefreshToken(true)
    tokenServices.setTokenStore(tokenStore)
    tokenServices
  }
}
