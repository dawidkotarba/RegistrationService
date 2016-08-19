package dawid.kotarba.common.config.obligatory

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.core.io.ClassPathResource

/**
  * Created by Dawid on 19.07.2016.
  */

@Configuration
class PropertiesConfig {

  @Bean
  def properties: PropertySourcesPlaceholderConfigurer = {
    val configurer = new PropertySourcesPlaceholderConfigurer
    configurer.setLocations(new ClassPathResource("application.properties"),
      new ClassPathResource("modules.properties"))
    configurer.setIgnoreUnresolvablePlaceholders(true)
    configurer
  }
}
