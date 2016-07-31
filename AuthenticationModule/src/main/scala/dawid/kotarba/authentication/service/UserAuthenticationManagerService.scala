package dawid.kotarba.authentication.service

import javax.inject.{Inject, Named}

import dawid.kotarba.authentication.dto.UserDto
import dawid.kotarba.shared.exceptions.impl.BadCredentialsException
import dawid.kotarba.shared.service.RestTemplateService
import dawid.kotarba.shared.service.impl.ModulesPropertiesService
import dawid.kotarba.shared.utils.PreconditionsUtils
import org.springframework.http.{HttpMethod, ResponseEntity}
import org.springframework.security.authentication.{AuthenticationManager, UsernamePasswordAuthenticationToken}
import org.springframework.security.core.Authentication
import org.springframework.util.StringUtils

/**
  * Created by Dawid on 06.07.2016.
  */

@Named
class UserAuthenticationManagerService @Inject()(private val restTemplateService: RestTemplateService,
                                                 private val modulesPropertiesService: ModulesPropertiesService)
  extends AuthenticationManager {

  override def authenticate(authentication: Authentication): Authentication = {
    PreconditionsUtils.checkNotNull(authentication, "authentication")

    val username = authentication.getPrincipal.toString
    val password = authentication.getCredentials.toString

    if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
      throw new BadCredentialsException("Username or password cannot be null")
    }

    val usersUrl = modulesPropertiesService.addProxyUrl(modulesPropertiesService.usersModuleName)
    val response: ResponseEntity[UserDto] = restTemplateService.exchangeSync(usersUrl + username, HttpMethod.GET, null, classOf[UserDto])

    if (response == null || response.getBody == null || !(response.getBody.password == password)) {
      throw new BadCredentialsException("Wrong username or password")
    }

    new UsernamePasswordAuthenticationToken(username, password, authentication.getAuthorities)
  }
}
