package dawid.kotarba.proxy

import dawid.kotarba.proxy.config.MainConfig
import org.springframework.boot.SpringApplication

/**
  * Created by Dawid on 01.07.2016.
  */

object ProxyModule extends App {
  SpringApplication.run(classOf[MainConfig])
}
