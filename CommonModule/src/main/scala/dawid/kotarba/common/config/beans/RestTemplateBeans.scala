package dawid.kotarba.common.config.beans

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.client.{AsyncRestTemplate, RestTemplate}

/**
  * Created by Dawid on 16.07.2016.
  */

@Configuration
class RestTemplateBeans {

  @Bean
  def restTemplate(): RestTemplate = new RestTemplate

  @Bean
  def asyncRestTemplate(): AsyncRestTemplate = new AsyncRestTemplate

}
