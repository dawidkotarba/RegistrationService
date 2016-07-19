package dawid.kotarba.template.config

/**
  * Created by Dawid on 03.07.2016.
  */
@Configuration
@EnableEurekaClient
@Profile(Array("!test"))
class EurekaConfig
