package dawid.kotarba.shared.service.impl

import javax.inject.Named

import dawid.kotarba.shared.utils.Constants
import org.springframework.beans.factory.annotation.Value

/**
  * Created by Dawid on 17.07.2016.
  */

@Named
class ModulesPropertiesService {

  @Value("${proxy.url}")
  private val proxyUrl: String = null

  @Value("${modules.authenticationModule.name}")
  val authenticationModuleName: String = null

  @Value("${modules.serviceDiscoveryModule.name}")
  val serviceDiscoveryModuleName: String = null

  @Value("${modules.usersModule.name}")
  val usersModuleName: String = null

  def resolveUrl(moduleName: String, path: String): String = proxyUrl + Constants.SLASH + moduleName + Constants.SLASH + path + Constants.SLASH
}
