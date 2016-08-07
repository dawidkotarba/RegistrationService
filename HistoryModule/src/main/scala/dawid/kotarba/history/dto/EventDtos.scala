package dawid.kotarba.history.dto

import javax.validation.constraints.NotNull

import scala.beans.BeanProperty

/**
  * Created by Dawid on 02.08.2016.
  */
case class EventDto(@BeanProperty @NotNull username: String,
                    @BeanProperty @NotNull eventType: String,
                    @BeanProperty description: String) {
  def this() = this(null, null, null)
}