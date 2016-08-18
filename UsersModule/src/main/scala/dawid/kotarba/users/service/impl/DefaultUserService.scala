package dawid.kotarba.users.service.impl

import javax.inject.{Inject, Named}

import dawid.kotarba.common.exceptions.impl.NotFoundException
import dawid.kotarba.common.utils.PreconditionsUtils
import dawid.kotarba.users.converter.UserConverter
import dawid.kotarba.users.dto.UserDto
import dawid.kotarba.users.repository.UserRepository
import dawid.kotarba.users.service.UserService

/**
  * Created by Dawid on 09.07.2016.
  */

@Named
class DefaultUserService @Inject()(userRepository: UserRepository) extends UserService {
  override def findByUsername(username: String): UserDto = {
    PreconditionsUtils.checkNotNull(username, "username")
    val userList = userRepository.findByUsername(username)
    if (userList.isEmpty) throw new NotFoundException("Cannot find user:" + username)
    UserConverter.toDto(userList.get(0))
  }
}
