package dawid.kotarba.history.dto

import javax.validation.constraints.NotNull

import dawid.kotarba.history.model.enums.EventTypeEnum.EventTypeEnum

import scala.beans.BeanProperty

/**
  * Created by Dawid on 02.08.2016.
  */
case class EventTypeDto(@BeanProperty @NotNull eventType: EventTypeEnum) {
  def this() = this(null)
}

case class EventDto(@BeanProperty @NotNull username: String,
                    @BeanProperty @NotNull eventType: EventTypeDto,
                    @BeanProperty description: String) {
  def this() = this(null, null, null)
}