package dawid.kotarba.shared.service.impl

import dawid.kotarba.shared.config.contextLoaded.LocalizationConfig
import dawid.kotarba.shared.service.LocalizationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service

/**
  * Created by Dawid on 17.07.2016.
  */

@Service
class DefaultLocalizationService @Autowired()(val messageSource: MessageSource, val localizationConfig: LocalizationConfig)
  extends LocalizationService {

  def getMessage(code: String): String = messageSource.getMessage(code, null, localizationConfig.getDefaultLocale)

  def getMessage(code: String, args: Array[Object]): String = messageSource.getMessage(code, args, localizationConfig.getDefaultLocale)
}
