package dawid.kotarba.users.service.impl

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
    val result = userDao.findByUsername(username)
    if (result.isDefined) result.get else throw new IllegalArgumentException // TODO
  }
}
