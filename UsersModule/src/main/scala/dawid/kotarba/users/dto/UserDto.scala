package dawid.kotarba.users.dto

import scala.beans.BeanProperty

/**
  * Created by Dawid on 09.07.2016.
  */
case class UserDto(@BeanProperty username: String,
                   @BeanProperty password: String,
                   @BeanProperty enabled: Boolean,
                   @BeanProperty role: String)
