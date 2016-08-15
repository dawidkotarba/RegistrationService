package dawid.kotarba.shared.config.obligatory

import java.util

import org.springframework.context.annotation.{Configuration, Profile}
import springfox.documentation.builders.{ParameterBuilder, PathSelectors, RequestHandlerSelectors}
import springfox.documentation.schema.ModelRef
import springfox.documentation.service.Parameter
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
  * Created by Dawid on 01.07.2016.
  */
@Configuration
@EnableSwagger2
@Profile(Array("!test"))
class SwaggerConfig {

  def api(): Docket = {
    new Docket(DocumentationType.SWAGGER_2).select.apis(RequestHandlerSelectors.any)
      .paths(PathSelectors.any).build
      .globalOperationParameters(getCommonParameters)
      .pathMapping("/")
  }

  private def getAuthorizationParameter() = new ParameterBuilder()
    .parameterType("header")
    .modelRef(new ModelRef("String"))
    .required(false)
    .name("Authorization")
    .description("Bearer token")
    .build()

  private def getCommonParameters(): java.util.List[Parameter] = {
    new java.util.ArrayList[Parameter](util.Arrays.asList(getAuthorizationParameter))
  }
}
