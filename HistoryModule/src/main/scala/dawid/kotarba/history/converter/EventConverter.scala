package dawid.kotarba.history.converter

import dawid.kotarba.history.dto.EventDto
import dawid.kotarba.history.model.{Event, EventType}

/**
  * Created by Dawid on 02.08.2016.
  */
object EventConverter {

  def toDto(event: Event): EventDto = EventDto(event.username, EventTypeConverter.toDto(event.eventType), event.description)

  def toEntity(eventDto: EventDto, eventType: EventType): Event = {
    val event = new Event
    event.username = eventDto.username
    event.description = eventDto.description
    event.eventType = eventType
    event
  }
}
