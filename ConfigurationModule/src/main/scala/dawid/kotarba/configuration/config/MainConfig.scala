package dawid.kotarba.configuration.config

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.context.annotation.{ComponentScan, Configuration}

/**
  * Created by Dawid on 01.07.2016.
  */

@Configuration
@EnableAutoConfiguration
@EnableConfigServer
@ComponentScan(Array("dawid.kotarba"))
class MainConfig
