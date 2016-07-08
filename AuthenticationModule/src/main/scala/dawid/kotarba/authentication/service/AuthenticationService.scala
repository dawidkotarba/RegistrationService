package dawid.kotarba.authentication.service

import org.springframework.security.core.Authentication

/**
  * Created by Dawid on 06.07.2016.
  */
trait AuthenticationService {
  def authenticate(authentication: Authentication): Authentication
}
