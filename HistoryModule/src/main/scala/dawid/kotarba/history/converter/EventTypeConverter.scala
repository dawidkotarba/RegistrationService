package dawid.kotarba.history.converter

import dawid.kotarba.history.model.entity.EventType

/**
  * Created by Dawid on 02.08.2016.
  */
object EventTypeConverter {

  def toEntity(eventType: String): EventType = {
    val event = new EventType
    event.eventType = eventType
    event
  }
}
