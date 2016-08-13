package dawid.kotarba.shared.config.contextLoaded

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * Created by Dawid on 13.08.2016.
  */

@Configuration
class JacksonConfig {

  @Bean
  def objectMapper(): ObjectMapper = {
    val mapper = new ObjectMapper
    mapper.registerModule(DefaultScalaModule)
  }
}
