package dawid.kotarba.authentication.dto

import scala.beans.BeanProperty

/**
  * Created by Dawid on 16.07.2016.
  */
case class UserDto(@BeanProperty username: String,
                   @BeanProperty password: String,
                   @BeanProperty enabled: Boolean,
                   @BeanProperty role: String)
