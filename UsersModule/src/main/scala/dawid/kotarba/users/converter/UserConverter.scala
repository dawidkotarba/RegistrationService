package dawid.kotarba.users.converter

import dawid.kotarba.users.dto.UserDto
import dawid.kotarba.users.model.User

/**
  * Created by Dawid on 09.07.2016.
  */
object UserConverter {

  def toDto(user: User): UserDto =
    UserDto(user.getUsername(), user.getPassword(), user.getEnabled(), user.getRole())


}
