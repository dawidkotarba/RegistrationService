package dawid.kotarba.shared.service.impl

import java.time.LocalDateTime
import java.util.UUID
import java.util.function.Consumer

import dawid.kotarba.shared.dto.{ExceptionResponseDto, ValidationError}
import dawid.kotarba.shared.model.exceptions.{AbstractApplicationRuntimeException, ExceptionType}
import org.springframework.stereotype.Service
import org.springframework.validation.{BindingResult, FieldError}

/**
  * Created by Dawid on 14.07.2016.
  */
@Service
class ExceptionConverterService {

  def convert(e: AbstractApplicationRuntimeException): ExceptionResponseDto =
    ExceptionResponseDto(e.uuid, e.exceptionType, e.timestamp, "TODO", e.message, null) // TODO:  

  def convert(e: Exception): ExceptionResponseDto =
    ExceptionResponseDto(UUID.randomUUID(), ExceptionType.INTERNAL_ERROR, LocalDateTime.now(), "TODO", e.getMessage, null) // TODO:

  def convert(e: Exception, bindingResult: BindingResult): ExceptionResponseDto = {
    val exceptionResponse = convert(e)
    exceptionResponse.validationErrors.::(parseBindingResult(bindingResult))
    exceptionResponse
  }

  private def parseBindingResult(bindingResult: BindingResult): List[ValidationError] = {
    val validationErrors = List[ValidationError]()

    bindingResult.getFieldErrors().forEach(new Consumer[FieldError] {
      override def accept(t: FieldError): Unit = validationErrors.::(ValidationError(t.getField, t.getDefaultMessage))
    })
    validationErrors
  }
}