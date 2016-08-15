package dawid.kotarba.users.service.impl

import javax.inject.{Inject, Named}

import dawid.kotarba.common.exceptions.impl.NotFoundException
import dawid.kotarba.common.utils.PreconditionsUtils
import dawid.kotarba.users.dao.UserDao
import dawid.kotarba.users.dto.UserDto
import dawid.kotarba.users.service.UserService

/**
  * Created by Dawid on 09.07.2016.
  */

@Named
class DefaultUserService @Inject()(private val userDao: UserDao) extends UserService {
  override def findByUsername(username: String): UserDto = {
    PreconditionsUtils.checkNotNull(username, "username")
    val result = userDao.findByUsername(username)
    if (result.isDefined) result.get else throw new NotFoundException("Cannot find user:" + username)
  }
}
