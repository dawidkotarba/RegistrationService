package dawid.kotarba.users.model

import javax.persistence._

import dawid.kotarba.shared.model.entities.AbstractEntity

/**
  * Created by Dawid on 08.07.2016.
  */
@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "PK", sequenceName = "USERS_SEQ", allocationSize = 1)
class User extends AbstractEntity {

  @Column(name = "USERNAME", nullable = false, unique = true)
  private var username: String = null

  @Column(name = "PASSWORD", nullable = false)
  private var password: String = null

  @Column(name = "ENABLED", nullable = false)
  private var enabled: Boolean = false

  @Column(name = "ROLE", nullable = false)
  private var role: String = null

  def setUsername(username: String): Unit = this.username = username

  def getUsername(): String = username

  def setPassword(password: String): Unit = this.password = password

  def getPassword(): String = password

  def setEnabled(enabled: Boolean): Unit = this.enabled = enabled

  def getEnabled(): Boolean = enabled

  def setRole(role: String): Unit = this.role = role

  def getRole(): String = role

}
