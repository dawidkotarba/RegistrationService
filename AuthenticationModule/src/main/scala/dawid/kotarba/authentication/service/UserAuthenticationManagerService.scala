package dawid.kotarba.authentication.service

import dawid.kotarba.authentication.dto.UserDto
import dawid.kotarba.shared.service.RestTemplateService
import dawid.kotarba.shared.service.impl.ModulesPropertiesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.http.{HttpMethod, ResponseEntity}
import org.springframework.security.authentication.{AuthenticationManager, UsernamePasswordAuthenticationToken}
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils

/**
  * Created by Dawid on 06.07.2016.
  */

@Service
class UserAuthenticationManagerService @Autowired()(val discoveryClient: DiscoveryClient,
                                                    val restTemplateService: RestTemplateService,
                                                    val modulesPropertiesService: ModulesPropertiesService)
  extends AuthenticationManager {

  override def authenticate(authentication: Authentication): Authentication = {
    val username = authentication.getPrincipal.toString
    val password = authentication.getCredentials.toString

    if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
      throw new IllegalArgumentException("Wrong credentials") // TODO: replace with custom exception
    }

    val authenticationModuleUri = discoveryClient.getInstances(modulesPropertiesService.usersModuleName).get(0).getUri
    val response: ResponseEntity[UserDto] = restTemplateService.exchangeSync(authenticationModuleUri + "/users/" + username, HttpMethod.GET, null, classOf[UserDto])

    if (response.getBody == null || !(response.getBody.password == password)) {
      throw new IllegalArgumentException // TODO: create a custom exception
    }

    new UsernamePasswordAuthenticationToken(username, password, authentication.getAuthorities)
  }
}
