package dawid.kotarba.discovery.config

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.context.annotation.{ComponentScan, Configuration}

/**
  * Created by Dawid on 01.07.2016.
  */

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableEurekaServer
class MainConfiguration {

}
