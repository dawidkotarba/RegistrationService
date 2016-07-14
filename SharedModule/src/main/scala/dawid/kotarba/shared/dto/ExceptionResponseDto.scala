package dawid.kotarba.shared.dto

import java.time.LocalDateTime
import java.util.UUID

import dawid.kotarba.shared.model.exceptions.ExceptionType


/**
  * Created by Dawid on 14.07.2016.
  */
case class ExceptionResponseDto(uUID: UUID, exceptionType: ExceptionType.Value,
                                timestamp: LocalDateTime, userMessage: String,
                                devMessage: String, validationErrors: List[ValidationError])

case class ValidationError(fieldName: String, message: String)
