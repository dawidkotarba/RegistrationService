package dawid.kotarba.users.config

import org.springframework.context.annotation.{Configuration, Profile}
import springfox.documentation.builders.{PathSelectors, RequestHandlerSelectors}
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
  * Created by Dawid on 01.07.2016.
  */
@Configuration
@EnableSwagger2
@Profile(Array("default"))
class SwaggerConfig {

  def api(): Docket = {
    new Docket(DocumentationType.SWAGGER_2).select.apis(RequestHandlerSelectors.any).paths(PathSelectors.any).build.pathMapping("/")
  }
}
