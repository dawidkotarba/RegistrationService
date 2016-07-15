package dawid.kotarba.shared.dto

import java.time.LocalDateTime
import java.util.UUID

import dawid.kotarba.shared.model.exceptions.ExceptionType

import scala.beans.BeanProperty


/**
  * Created by Dawid on 14.07.2016.
  */
case class ExceptionResponseDto(@BeanProperty uuid: UUID, @BeanProperty exceptionType: ExceptionType.Value,
                                @BeanProperty timestamp: LocalDateTime, @BeanProperty userMessage: String,
                                @BeanProperty devMessage: String, @BeanProperty validationErrors: List[ValidationError])

case class ValidationError(@BeanProperty fieldName: String, @BeanProperty message: String)
