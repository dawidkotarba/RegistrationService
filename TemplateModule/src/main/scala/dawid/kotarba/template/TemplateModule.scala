package dawid.kotarba.template

import dawid.kotarba.template.config.MainConfiguration
import org.springframework.boot.SpringApplication

/**
  * Created by Dawid on 01.07.2016.
  */

object TemplateModule extends App {
  SpringApplication.run(classOf[MainConfiguration])
}
