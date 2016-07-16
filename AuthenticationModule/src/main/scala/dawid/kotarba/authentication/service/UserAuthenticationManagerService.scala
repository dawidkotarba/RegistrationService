package dawid.kotarba.authentication.service

import dawid.kotarba.authentication.dto.UserDto
import dawid.kotarba.shared.model.exceptions.impl.NotFoundException
import dawid.kotarba.shared.service.RestTemplateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.{AuthenticationManager, UsernamePasswordAuthenticationToken}
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils

/**
  * Created by Dawid on 06.07.2016.
  */

@Service
class UserAuthenticationManagerService @Autowired()(private val restTemplateService: RestTemplateService)
  extends AuthenticationManager {

  override def authenticate(authentication: Authentication): Authentication = {
    val username = authentication.getPrincipal.toString
    val password = authentication.getCredentials.toString

    if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
      throw new NotFoundException("Cannot find user: " + username)
    }

    val user = restTemplateService.exchangeSync("http://localhost:8082/users/" + username, HttpMethod.GET, null, classOf[UserDto])

    //        val user = userDao.findByUsername(username)

    //        if (user == null || !password.equals(user.password)) {
    //          throw new IllegalArgumentException // TODO: create a custom exception
    //        }

    new UsernamePasswordAuthenticationToken(username, password, authentication.getAuthorities)
  }
}
