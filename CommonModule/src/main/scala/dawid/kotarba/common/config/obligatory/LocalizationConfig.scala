package dawid.kotarba.common.config.obligatory

import java.util.Locale
import javax.annotation.PostConstruct

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.config.annotation.{InterceptorRegistry, WebMvcConfigurerAdapter}
import org.springframework.web.servlet.i18n.{LocaleChangeInterceptor, SessionLocaleResolver}

/**
  * Created by Dawid on 17.07.2016.
  */

@Configuration
@ConfigurationProperties()
class LocalizationConfig extends WebMvcConfigurerAdapter {

  @Value("${default.locale}")
  private val locale: String = null
  private var defaultLocale: Locale = null

  @PostConstruct
  def init(): Unit = {
    defaultLocale = new Locale.Builder().setLanguageTag(locale).build
  }

  @Bean
  def localeResolver: LocaleResolver = {
    val slr = new SessionLocaleResolver
    slr.setDefaultLocale(defaultLocale)
    slr
  }

  @Bean
  def localeChangeInterceptor: LocaleChangeInterceptor = {
    val lci = new LocaleChangeInterceptor
    lci.setParamName("lang")
    lci
  }

  @Bean
  def messageSource: ReloadableResourceBundleMessageSource = {
    val messageSource = new ReloadableResourceBundleMessageSource
    messageSource.setBasenames("classpath:i18n/shared_messages", "classpath:i18n/messages",
      "classpath:exceptions/shared_exceptions", "classpath:exceptions/exceptions")
    messageSource
  }

  override def addInterceptors(registry: InterceptorRegistry): Unit = registry.addInterceptor(localeChangeInterceptor)

  def getDefaultLocale: Locale = defaultLocale
}
