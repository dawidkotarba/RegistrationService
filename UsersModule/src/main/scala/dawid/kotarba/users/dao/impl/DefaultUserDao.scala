package dawid.kotarba.users.dao.impl

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
  override def findByUsername(username: String): UserDto = {
    UserDto(null, null, false, null)
  }
}
