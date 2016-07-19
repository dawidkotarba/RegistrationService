package dawid.kotarba.shared.service.impl

import javax.inject.Named

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.{Profile, PropertySource}

/**
  * Created by Dawid on 17.07.2016.
  */

@Named
@Profile(Array("dev", "prod"))
@PropertySource(Array("modules.properties"))
class ModulesPropertiesService {

  @Value("${modules.authenticationModule.name}")
  val authenticationModuleName: String = null

  @Value("${modules.serviceDiscoveryModule.name}")
  val serviceDiscoveryModuleName: String = null

  @Value("${modules.usersModule.name}")
  val usersModuleName: String = null
}
