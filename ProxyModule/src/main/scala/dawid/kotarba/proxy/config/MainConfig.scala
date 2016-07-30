package dawid.kotarba.proxy.config

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.context.annotation.{ComponentScan, Configuration}

/**
  * Created by Dawid on 01.07.2016.
  */

@Configuration
@EnableZuulProxy
@EnableAutoConfiguration
@ComponentScan(Array("dawid.kotarba"))
class MainConfig
