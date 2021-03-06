package dawid.kotarba.common.dto

import java.util.UUID

import scala.beans.BeanProperty


/**
  * Created by Dawid on 14.07.2016.
  */
case class ExceptionResponseDto(@BeanProperty uuid: UUID, @BeanProperty exceptionType: String,
                                @BeanProperty timestamp: String, @BeanProperty userMessage: String,
                                @BeanProperty devMessage: String, @BeanProperty validationErrors: List[ValidationError])

case class ValidationError(@BeanProperty fieldName: String, @BeanProperty message: String)
