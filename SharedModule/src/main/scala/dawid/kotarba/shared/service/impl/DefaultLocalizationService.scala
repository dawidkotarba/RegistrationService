package dawid.kotarba.shared.service.impl

import javax.inject.{Inject, Named}

import dawid.kotarba.shared.config.contextLoaded.LocalizationConfig
import dawid.kotarba.shared.service.LocalizationService
import org.springframework.context.MessageSource

/**
  * Created by Dawid on 17.07.2016.
  */

@Named
class DefaultLocalizationService @Inject()(val messageSource: MessageSource, val localizationConfig: LocalizationConfig)
  extends LocalizationService {

  def getMessage(code: String): String = messageSource.getMessage(code, null, localizationConfig.getDefaultLocale)

  def getMessage(code: String, args: Array[Object]): String = messageSource.getMessage(code, args, localizationConfig.getDefaultLocale)
}
