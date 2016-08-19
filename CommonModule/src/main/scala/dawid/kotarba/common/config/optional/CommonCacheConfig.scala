package dawid.kotarba.common.config.optional

import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.ehcache._
import org.springframework.context.annotation.Bean
import org.springframework.core.io.Resource

/**
  * Created by Dawid on 12.08.2016.
  */

@EnableCaching
class CommonCacheConfig {

  @Value("classpath:ehcache.xml")
  private val ehCacheConfiguration: Resource = null

  @Bean
  def getEhCacheManager(): CacheManager = {
    new EhCacheCacheManager(ehCacheFactoryBean.getObject)
  }

  @Bean
  def ehCacheFactoryBean(): EhCacheManagerFactoryBean = {
    val factoryBean = new EhCacheManagerFactoryBean
    factoryBean.setConfigLocation(ehCacheConfiguration)
    factoryBean.setShared(true)
    factoryBean
  }
}