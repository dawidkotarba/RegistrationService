package dawid.kotarba.authentication

import dawid.kotarba.authentication.config.MainConfig
import org.springframework.boot.SpringApplication

/**
  * Created by Dawid on 01.07.2016.
  */

object AuthenticationModule extends App {
  SpringApplication.run(classOf[MainConfig])
}
