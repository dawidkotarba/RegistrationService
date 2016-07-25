package dawid.kotarba.eventbus

import dawid.kotarba.eventbus.config.MainConfig
import org.springframework.boot.SpringApplication

/**
  * Created by Dawid on 01.07.2016.
  */

object EventBusModule extends App {
  SpringApplication.run(classOf[MainConfig])
}
