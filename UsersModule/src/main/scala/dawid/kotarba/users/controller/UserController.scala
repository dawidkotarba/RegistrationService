package dawid.kotarba.users.controller

import dawid.kotarba.users.dto.UserDto
import dawid.kotarba.users.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation._

/**
  * Created by Dawid on 09.07.2016.
  */

@RestController
@RequestMapping(value = Array("/users"), produces = Array(MediaType.APPLICATION_JSON_VALUE))
class UserController @Autowired()(private val userService: UserService) {

  @RequestMapping(value = Array("/{username}"), method = Array(RequestMethod.GET))
  def getUserByUsername(@PathVariable username: String): UserDto =
    userService.findByUsername(username)
}