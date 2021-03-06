package dawid.kotarba.common.service.impl

import java.time.LocalDateTime
import java.util.UUID
import java.util.function.Consumer
import javax.inject.{Inject, Named}

import dawid.kotarba.common.dto.{ExceptionResponseDto, ValidationError}
import dawid.kotarba.common.exceptions.ExceptionType.ExceptionType
import dawid.kotarba.common.exceptions.{AbstractApplicationRuntimeException, ExceptionType}
import dawid.kotarba.common.service.LocalizationService
import dawid.kotarba.common.utils.DateTimeUtils
import org.springframework.validation.{BindingResult, FieldError}

/**
  * Created by Dawid on 14.07.2016.
  */
@Named
class ExceptionConverterService @Inject()(localizationService: LocalizationService) {

  def convert(e: AbstractApplicationRuntimeException): ExceptionResponseDto =
    ExceptionResponseDto(e.uuid, e.exceptionType.toString,
      DateTimeUtils.formatDate(e.timestamp), getLocalizedUserMessage(e.exceptionType), e.message, null)

  def convert(e: Exception): ExceptionResponseDto =
    ExceptionResponseDto(UUID.randomUUID(), ExceptionType.INTERNAL_ERROR.toString,
      DateTimeUtils.formatDate(LocalDateTime.now()), getLocalizedUserMessage(ExceptionType.INTERNAL_ERROR), e.getMessage, null)

  def convert(e: Exception, bindingResult: BindingResult): ExceptionResponseDto = {
    def parseBindingResult(bindingResult: BindingResult): List[ValidationError] = {
      val validationErrors = List[ValidationError]()

      bindingResult.getFieldErrors().forEach(new Consumer[FieldError] {
        override def accept(t: FieldError): Unit = validationErrors.::(ValidationError(t.getField, t.getDefaultMessage))
      })
      validationErrors
    }
    
    val exceptionResponse = convert(e)
    exceptionResponse.validationErrors :: parseBindingResult(bindingResult)
    exceptionResponse
  }

  def getLocalizedUserMessage(exceptionType: ExceptionType): String = getLocalizedUserMessage(exceptionType, null)

  def getLocalizedUserMessage(exceptionType: ExceptionType, params: Array[Object]): String = if (params != null)
    localizationService.getMessage(exceptionType.toString, params)
  else
    localizationService.getMessage(exceptionType.toString)
}