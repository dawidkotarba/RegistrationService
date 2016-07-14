package dawid.kotarba.authentication.service

import dawid.kotarba.shared.model.exceptions.impl.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.{AuthenticationManager, UsernamePasswordAuthenticationToken}
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.client.RestTemplate

/**
  * Created by Dawid on 06.07.2016.
  */

@Service
class UserAuthenticationManagerService @Autowired()(private val restTemplate: RestTemplate)
  extends AuthenticationManager {

  override def authenticate(authentication: Authentication): Authentication = {
    val username = authentication.getPrincipal.toString
    val password = authentication.getCredentials.toString

    if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
      throw new NotFoundException("Cannot find user: " + username)
    }

    throw new NotFoundException("Cannot find user: " + username)
//        val user = userDao.findByUsername(username)

//        if (user == null || !password.equals(user.password)) {
//          throw new IllegalArgumentException // TODO: create a custom exception
//        }

//    new UsernamePasswordAuthenticationToken(username, password, authentication.getAuthorities)
  }
}
