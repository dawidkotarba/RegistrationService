package dawid.kotarba.users.dao.impl

import javax.inject.{Inject, Named}

import dawid.kotarba.common.utils.PreconditionsUtils
import dawid.kotarba.users.converter.UserConverter
import dawid.kotarba.users.dao.UserDao
import dawid.kotarba.users.dto.UserDto
import dawid.kotarba.users.repository.UserRepository

/**
  * Created by Dawid on 09.07.2016.
  */

@Named
class DefaultUserDao @Inject()(userRepository: UserRepository) extends UserDao {
  override def findByUsername(username: String): Option[UserDto] = {
    PreconditionsUtils.checkNotNull(username, "username")
    val userList = userRepository.findByUsername(username)
    if (userList.isEmpty) None else Some(UserConverter.toDto(userList.get(0)))
  }
}
