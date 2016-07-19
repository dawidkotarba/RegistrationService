package dawid.kotarba.shared.service.impl

import javax.inject.Named

import org.springframework.beans.factory.annotation.Value

/**
  * Created by Dawid on 17.07.2016.
  */

@Named
class ModulesPropertiesService {

  @Value("${modules.authenticationModule.name}")
  val authenticationModuleName: String = null

  @Value("${modules.serviceDiscoveryModule.name}")
  val serviceDiscoveryModuleName: String = null

  @Value("${modules.usersModule.name}")
  val usersModuleName: String = null
}
