package dawid.kotarba.configuration

import dawid.kotarba.configuration.config.MainConfig
import org.springframework.boot.SpringApplication

/**
  * Created by Dawid on 01.07.2016.
  */

object ConfigurationModule extends App {
  SpringApplication.run(classOf[MainConfig])
}
