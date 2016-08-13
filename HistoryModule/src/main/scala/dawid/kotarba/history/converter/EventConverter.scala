package dawid.kotarba.history.converter

import java.time.LocalDateTime

import dawid.kotarba.history.dto.EventDto
import dawid.kotarba.history.model.entity.{Event, EventType}
import dawid.kotarba.shared.model.enums.EventTypeEnum

/**
  * Created by Dawid on 02.08.2016.
  */
object EventConverter {

  def toDto(event: Event): EventDto = EventDto(event.username, EventTypeEnum.withName(event.eventType.eventType), event.description)

  def toEntity(eventDto: EventDto, eventType: EventType): Event = {
    val event = new Event
    event.username = eventDto.username
    event.description = eventDto.description
    event.eventType = eventType
    event.eventDate = LocalDateTime.now()
    event
  }
}
