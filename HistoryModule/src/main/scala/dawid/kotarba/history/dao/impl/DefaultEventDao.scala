package dawid.kotarba.history.dao.impl

import javax.inject.{Inject, Named}

import dawid.kotarba.history.converter.{EventConverter, EventTypeConverter}
import dawid.kotarba.history.dao.EventDao
import dawid.kotarba.history.dto.EventDto
import dawid.kotarba.history.repository.{EventRepository, EventTypeRepository}
import dawid.kotarba.shared.utils.PreconditionsUtils

import scala.collection.JavaConverters._

/**
  * Created by Dawid on 02.08.2016.
  */

@Named
class DefaultEventDao @Inject()(eventRepository: EventRepository,
                                eventTypeRepository: EventTypeRepository) extends EventDao {
  override def findByUsername(username: String): List[EventDto] = {
    PreconditionsUtils.checkNotNull(username, "username")
    val events = eventRepository.findByUsername(username).asScala.toList
    events.map(e => EventConverter.toDto(e))
  }

  override def add(eventDto: EventDto): Long = {
    PreconditionsUtils.checkNotNull(eventDto, "eventDto")
    val eventType = EventTypeConverter.toEntity(eventDto.eventType)
    val savedEventType = eventTypeRepository.save(eventType)

    val event = EventConverter.toEntity(eventDto, savedEventType)
    val saved = eventRepository.save(event)
    saved.getId()
  }
}
