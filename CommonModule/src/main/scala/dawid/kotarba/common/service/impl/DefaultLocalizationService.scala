package dawid.kotarba.common.service.impl

import javax.inject.{Inject, Named}

import dawid.kotarba.common.config.obligatory.LocalizationConfig
import dawid.kotarba.common.service.LocalizationService
import org.springframework.context.MessageSource

/**
  * Created by Dawid on 17.07.2016.
  */

@Named
class DefaultLocalizationService @Inject()(messageSource: MessageSource, localizationConfig: LocalizationConfig)
  extends LocalizationService {

  def getMessage(code: String): String = messageSource.getMessage(code, null, localizationConfig.getDefaultLocale)

  def getMessage(code: String, args: Array[Object]): String = messageSource.getMessage(code, args, localizationConfig.getDefaultLocale)
}
