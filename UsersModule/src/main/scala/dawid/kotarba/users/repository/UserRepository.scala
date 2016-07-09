package dawid.kotarba.users.repository

import dawid.kotarba.users.model.User
import org.springframework.data.jpa.repository.JpaRepository

/**
  * Created by Dawid on 08.07.2016.
  */

trait UserRepository extends JpaRepository[User, java.lang.Long] {
  def findByUsername(username: String): java.util.List[User]
}
