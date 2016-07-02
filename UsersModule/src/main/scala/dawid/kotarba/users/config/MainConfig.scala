package dawid.kotarba.users.config

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.{ComponentScan, Configuration}

/**
  * Created by Dawid on 01.07.2016.
  */

@Configuration
@EnableAutoConfiguration
@ComponentScan(Array("dawid.kotarba"))
class MainConfig
