package dawid.kotarba.users.repository

import java.lang.Long

import dawid.kotarba.users.model.User
import org.springframework.data.jpa.repository.JpaRepository

/**
  * Created by Dawid on 08.07.2016.
  */

trait UserRepository extends JpaRepository[User, Long] {
  def findByUsername(username: String): List[User]
}
