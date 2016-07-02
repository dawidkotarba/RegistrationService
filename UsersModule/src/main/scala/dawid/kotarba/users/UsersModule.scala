package dawid.kotarba.users

import dawid.kotarba.users.config.MainConfig
import org.springframework.boot.SpringApplication

/**
  * Created by Dawid on 01.07.2016.
  */

object UsersModule extends App {
  SpringApplication.run(classOf[MainConfig])
}
