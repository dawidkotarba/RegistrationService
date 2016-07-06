package dawid.kotarba.shared.config

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.client.{AsyncRestTemplate, RestTemplate}

/**
  * Created by Dawid on 03.07.2016.
  */
@Configuration
class CommonBeans {

  @Bean
  def restTemplate(): RestTemplate = new RestTemplate

  @Bean
  def asyncRestTemplate(): AsyncRestTemplate = new AsyncRestTemplate
}
