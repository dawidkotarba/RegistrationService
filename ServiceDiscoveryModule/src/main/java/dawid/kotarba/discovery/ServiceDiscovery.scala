package dawid.kotarba.discovery

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

/**
  * Created by Dawid on 01.07.2016.
  */
@SpringBootApplication
@EnableEurekaServer
class ServiceDiscovery {

  def main(args: Array[String]) {
    SpringApplication.run(classOf[ServiceDiscovery])
  }
}
