package dawid.kotarba.users.dao.impl

import dawid.kotarba.shared.utils.PreconditionsUtils
import dawid.kotarba.users.converter.UserConverter
import dawid.kotarba.users.dao.UserDao
import dawid.kotarba.users.dto.UserDto
import dawid.kotarba.users.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
  * Created by Dawid on 09.07.2016.
  */

@Repository
class DefaultUserDao @Autowired()(private val userRepository: UserRepository) extends UserDao {
  override def findByUsername(username: String): Option[UserDto] = {
    PreconditionsUtils.checkNotNull(username, "username")
    val userList = userRepository.findByUsername(username)
    if (userList.isEmpty) None else Some(UserConverter.toDto(userList.get(0)))
  }
}
