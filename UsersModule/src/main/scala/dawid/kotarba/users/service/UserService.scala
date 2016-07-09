package dawid.kotarba.users.service

import dawid.kotarba.users.dto.UserDto

/**
  * Created by Dawid on 09.07.2016.
  */
trait UserService {
  def findByUsername(username: String): UserDto
}
