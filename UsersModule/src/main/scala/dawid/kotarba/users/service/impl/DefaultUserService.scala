package dawid.kotarba.users.service.impl

import dawid.kotarba.shared.model.exceptions.impl.NotFoundException
import dawid.kotarba.shared.utils.PreconditionsUtils
import dawid.kotarba.users.dao.UserDao
import dawid.kotarba.users.dto.UserDto
import dawid.kotarba.users.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Created by Dawid on 09.07.2016.
  */

@Service
class DefaultUserService @Autowired()(private val userDao: UserDao) extends UserService {
  override def findByUsername(username: String): UserDto = {
    PreconditionsUtils.checkNotNull(username, "username")
    val result = userDao.findByUsername(username)
    if (result.isDefined) result.get else throw new NotFoundException("Cannot find user:" + username)
  }
}
