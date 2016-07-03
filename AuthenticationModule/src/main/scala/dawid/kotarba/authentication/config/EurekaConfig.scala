package dawid.kotarba.authentication.config

import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.{Configuration, Profile}

/**
  * Created by Dawid on 03.07.2016.
  */
@Configuration
@EnableEurekaClient
@Profile(Array("default"))
class EurekaConfig
