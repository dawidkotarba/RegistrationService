package dawid.kotarba.shared.service.impl

import javax.inject.{Inject, Named}

import dawid.kotarba.shared.service.RestTemplateService
import dawid.kotarba.shared.utils.SecurityUtils
import org.springframework.http.{HttpEntity, HttpMethod, ResponseEntity}
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.web.client.{AsyncRestTemplate, RestTemplate}

/**
  * Created by Dawid on 16.07.2016.
  */
@Named
class DefaultRestTemplateService @Inject()(val restTemplate: RestTemplate, val asyncRestTemplate: AsyncRestTemplate)
  extends RestTemplateService {

  override def exchangeAsync[MESSAGE, RESPONSE](url: String, method: HttpMethod, message: MESSAGE, responseClass: java.lang.Class[RESPONSE]): ListenableFuture[ResponseEntity[RESPONSE]] =
    asyncRestTemplate.exchange(url, method, new HttpEntity(message, SecurityUtils.getAuthBearerHttpHeaders), responseClass)

  override def exchangeSync[MESSAGE, RESPONSE](url: String, method: HttpMethod, message: MESSAGE, responseClass: java.lang.Class[RESPONSE]): ResponseEntity[RESPONSE] =
    restTemplate.exchange(url, method, new HttpEntity(message, SecurityUtils.getAuthBearerHttpHeaders), responseClass)
}
