package dawid.kotarba.users.dao

import dawid.kotarba.users.dto.UserDto

/**
  * Created by Dawid on 09.07.2016.
  */
trait UserDao {
  def findByUsername(username: String): Option[UserDto]
}
