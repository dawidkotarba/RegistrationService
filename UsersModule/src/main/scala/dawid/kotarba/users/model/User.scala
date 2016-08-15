package dawid.kotarba.users.model

import javax.persistence._

import dawid.kotarba.common.model.entities.AbstractEntity

/**
  * Created by Dawid on 08.07.2016.
  */
@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "PK", sequenceName = "USERS_SEQ", allocationSize = 1)
class User extends AbstractEntity {

  @Column(name = "USERNAME", nullable = false, unique = true)
  var username: String = null

  @Column(name = "PASSWORD", nullable = false)
  var password: String = null

  @Column(name = "ENABLED", nullable = false)
  var enabled: Boolean = false

  @Column(name = "ROLE", nullable = false)
  var role: String = null
}
