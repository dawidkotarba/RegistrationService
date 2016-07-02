package dawid.kotarba.discovery

import dawid.kotarba.discovery.config.MainConfig
import org.springframework.boot.SpringApplication

/**
  * Created by Dawid on 01.07.2016.
  */
object ServiceDiscovery extends App {
  SpringApplication.run(classOf[MainConfig])
}
