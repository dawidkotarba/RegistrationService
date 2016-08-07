package dawid.kotarba.history.service.impl

import javax.inject.{Inject, Named}
import javax.transaction.Transactional
import javax.validation.Valid

import dawid.kotarba.history.converter.{EventConverter, EventTypeConverter}
import dawid.kotarba.history.dto.EventDto
import dawid.kotarba.history.model.entity.EventType
import dawid.kotarba.history.repository.{EventRepository, EventTypeRepository}
import dawid.kotarba.history.service.EventService
import dawid.kotarba.shared.utils.PreconditionsUtils

import scala.collection.JavaConverters._

/**
  * Created by Dawid on 02.08.2016.
  */
@Named
@Transactional
class DefaultEventService @Inject()(eventRepository: EventRepository,
                                    eventTypeRepository: EventTypeRepository) extends EventService {

  override def add(@Valid eventDto: EventDto): Long = {
    PreconditionsUtils.checkNotNull(eventDto, "eventDto")
    eventRepository.save(EventConverter.toEntity(eventDto, getEventType(eventDto.eventType))).getId()
  }

  private def getEventType(eventType: String): EventType = {
    PreconditionsUtils.checkNotNull(eventType, "eventType")
    val eventTypes = eventTypeRepository.findByEventType(eventType)
    if (eventTypes.isEmpty) {
      val eventTypeEntity = EventTypeConverter.toEntity(eventType)
      eventTypeRepository.save(eventTypeEntity)
    } else {
      eventTypes.get(0)
    }
  }

  override def findByUsername(username: String): List[EventDto] = {
    PreconditionsUtils.checkNotNull(username, "username")
    val events = eventRepository.findByUsername(username).asScala.toList
    events.map(e => EventConverter.toDto(e))
  }
}
