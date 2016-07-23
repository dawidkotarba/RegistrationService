package dawid.kotarba.shared.config.contextLoaded

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.{Bean, Configuration, DependsOn}
import org.springframework.jmx.support.ConnectorServerFactoryBean
import org.springframework.remoting.rmi.RmiRegistryFactoryBean

/**
  * Created by Dawid on 23.07.2016.
  */

@Configuration
class JmxConfig {

  @Value("${jmx.rmi.host:localhost}")
  val rmiHost: String = null

  @Value("${jmx.rmi.port:1099}")
  val rmiPort: Integer = null

  @Bean
  def rmiRegistry(): RmiRegistryFactoryBean = {
    val rmiRegistryFactoryBean = new RmiRegistryFactoryBean
    rmiRegistryFactoryBean.setPort(rmiPort)
    rmiRegistryFactoryBean.setAlwaysCreate(true)
    rmiRegistryFactoryBean
  }

  @Bean
  @DependsOn(Array("rmiRegistry"))
  def connectorServerFactoryBean(): ConnectorServerFactoryBean = {
    val connectorServerFactoryBean = new ConnectorServerFactoryBean
    connectorServerFactoryBean.setObjectName("connector:name=rmi")
    connectorServerFactoryBean.setServiceUrl(
      String.format("service:jmx:rmi://%s:%s/jndi/rmi://%s:%s/jmxrmi", rmiHost, rmiPort, rmiHost, rmiPort))
    connectorServerFactoryBean
  }
}
