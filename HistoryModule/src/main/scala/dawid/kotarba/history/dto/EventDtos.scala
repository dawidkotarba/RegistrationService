package dawid.kotarba.history.dto

import javax.validation.constraints.NotNull

import com.fasterxml.jackson.module.scala.JsonScalaEnumeration
import dawid.kotarba.common.model.enums.EventTypeEnum.EventTypeEnum
import dawid.kotarba.common.model.enums.EventTypeEnumType

import scala.beans.BeanProperty

/**
  * Created by Dawid on 02.08.2016.
  */
case class EventDto(@BeanProperty @NotNull username: String,
                    @BeanProperty @NotNull @JsonScalaEnumeration(classOf[EventTypeEnumType]) eventType: EventTypeEnum,
                    @BeanProperty description: String) {
  def this() = this(null, null, null)
}

