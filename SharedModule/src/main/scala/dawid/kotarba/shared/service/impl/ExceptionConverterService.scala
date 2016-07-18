package dawid.kotarba.shared.service.impl

import java.time.LocalDateTime
import java.util.UUID
import java.util.function.Consumer

import dawid.kotarba.shared.dto.{ExceptionResponseDto, ValidationError}
import dawid.kotarba.shared.exceptions.{AbstractApplicationRuntimeException, ExceptionType}
import dawid.kotarba.shared.service.LocalizationService
import dawid.kotarba.shared.utils.DateTimeUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.validation.{BindingResult, FieldError}

/**
  * Created by Dawid on 14.07.2016.
  */
@Service
class ExceptionConverterService @Autowired()(localizationService: LocalizationService) {

  def convert(e: AbstractApplicationRuntimeException): ExceptionResponseDto =
    ExceptionResponseDto(e.uuid, e.exceptionType.toString,
      DateTimeUtils.formatDate(e.timestamp), getLocalizedUserMessage(e.exceptionType), e.message, null)

  def convert(e: Exception): ExceptionResponseDto =
    ExceptionResponseDto(UUID.randomUUID(), ExceptionType.INTERNAL_ERROR.toString,
      DateTimeUtils.formatDate(LocalDateTime.now()), getLocalizedUserMessage(ExceptionType.INTERNAL_ERROR), e.getMessage, null)

  def convert(e: Exception, bindingResult: BindingResult): ExceptionResponseDto = {
    val exceptionResponse = convert(e)
    exceptionResponse.validationErrors.::(parseBindingResult(bindingResult))
    exceptionResponse
  }

  def getLocalizedUserMessage(exceptionType: ExceptionType.Value): String = getLocalizedUserMessage(exceptionType, null)

  def getLocalizedUserMessage(exceptionType: ExceptionType.Value, params: Array[Object]): String = if (params != null)
    localizationService.getMessage(exceptionType.toString, params)
  else
    localizationService.getMessage(exceptionType.toString)

  private def parseBindingResult(bindingResult: BindingResult): List[ValidationError] = {
    val validationErrors = List[ValidationError]()

    bindingResult.getFieldErrors().forEach(new Consumer[FieldError] {
      override def accept(t: FieldError): Unit = validationErrors.::(ValidationError(t.getField, t.getDefaultMessage))
    })
    validationErrors
  }
}