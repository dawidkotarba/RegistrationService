package dawid.kotarba.common.utils

import org.springframework.http.{HttpHeaders, MediaType}
import org.springframework.security.config.annotation.web.builders.{HttpSecurity, WebSecurity}
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails
import org.springframework.util.DigestUtils

/**
  * Created by Dawid on 09.07.2016.
  */
object SecurityUtils {

  def disableCsrfAndFrameOptions(http: HttpSecurity): Unit = {
    http.csrf.disable
    http.headers.frameOptions.disable
  }

  def ignoreSwaggerPages(web: WebSecurity): Unit =
    web.ignoring.antMatchers("/v2/api-docs", "/configuration/ui",
      "/swagger-resources/configuration/ui", "/swagger-resources",
      "/configuration/security", "/swagger-ui.html", "/webjars/**")

  def ignoreH2Pages(web: WebSecurity): Unit = web.ignoring.antMatchers("/db/**")

  def md5(data: String): String = {
    DigestUtils.md5DigestAsHex(data.getBytes())
  }

  def getAuthBearerHttpHeaders(): HttpHeaders = {
    val httpHeaders = new HttpHeaders
    httpHeaders.setContentType(MediaType.APPLICATION_JSON)
    httpHeaders.set("Authorization", "Bearer " + getOauthToken)
    httpHeaders
  }

  def getOauthToken(): String = {
    val details = SecurityContextHolder.getContext.getAuthentication.getDetails
    if (details.isInstanceOf[OAuth2AuthenticationDetails])
      details.asInstanceOf[OAuth2AuthenticationDetails].getTokenValue
    else ""
  }
}
