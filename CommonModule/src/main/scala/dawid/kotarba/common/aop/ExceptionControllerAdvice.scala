package dawid.kotarba.common.aop

import javax.inject.Inject

import dawid.kotarba.common.dto.ExceptionResponseDto
import dawid.kotarba.common.exceptions.impl.{InternalErrorException, NotFoundException}
import dawid.kotarba.common.service.impl.ExceptionConverterService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.{ControllerAdvice, ExceptionHandler, ResponseBody, ResponseStatus}

/**
  * Created by Dawid on 14.07.2016.
  */

@ControllerAdvice
class ExceptionControllerAdvice @Inject()(exceptionConverterService: ExceptionConverterService) {

  @ExceptionHandler(value = Array(classOf[Exception]))
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  def handleException(e: Exception): ExceptionResponseDto = exceptionConverterService.convert(e)

  @ExceptionHandler(value = Array(classOf[InternalErrorException]))
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  def handleException(e: InternalErrorException): ExceptionResponseDto = exceptionConverterService.convert(e)

  @ExceptionHandler(value = Array(classOf[NotFoundException]))
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  def handleException(e: NotFoundException): ExceptionResponseDto = exceptionConverterService.convert(e)

  @ExceptionHandler(value = Array(classOf[MethodArgumentNotValidException]))
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  def handleException(e: MethodArgumentNotValidException): ExceptionResponseDto = exceptionConverterService.convert(e, e.getBindingResult)
}
