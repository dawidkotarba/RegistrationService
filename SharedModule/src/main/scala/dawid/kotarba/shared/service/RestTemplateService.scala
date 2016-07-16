package dawid.kotarba.shared.service

import org.springframework.http.{HttpMethod, ResponseEntity}
import org.springframework.util.concurrent.ListenableFuture

/**
  * Created by Dawid on 16.07.2016.
  */
trait RestTemplateService {

  def exchangeAsync[MESSAGE, RESPONSE](url: String, method: HttpMethod, message: MESSAGE, responseClass: java.lang.Class[RESPONSE]): ListenableFuture[ResponseEntity[RESPONSE]]

  def exchangeSync[MESSAGE, RESPONSE](url: String, method: HttpMethod, message: MESSAGE, responseClass: java.lang.Class[RESPONSE]): ResponseEntity[RESPONSE]
}
