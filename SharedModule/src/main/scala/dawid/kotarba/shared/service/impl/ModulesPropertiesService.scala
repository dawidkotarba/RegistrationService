package dawid.kotarba.shared.service.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Service

/**
  * Created by Dawid on 17.07.2016.
  */

@Service
@PropertySource(Array("modules.properties"))
class ModulesPropertiesService {

  @Value("${modules.authenticationModule.name}")
  val authenticationModuleName: String = null

  @Value("${modules.serviceDiscoveryModule.name}")
  val serviceDiscoveryModuleName: String = null

  @Value("${modules.usersModule.name}")
  val usersModuleName: String = null
}
