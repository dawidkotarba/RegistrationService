package dawid.kotarba.history.converter

import dawid.kotarba.history.dto.EventTypeDto
import dawid.kotarba.history.model.EventType

/**
  * Created by Dawid on 02.08.2016.
  */
object EventTypeConverter {

  def toDto(eventType: EventType): EventTypeDto = EventTypeDto(eventType.eventType)

  def toEntity(eventTypeDto: EventTypeDto): EventType = {
    val event = new EventType
    event.eventType = eventTypeDto.eventType
    event
  }
}
