package dawid.kotarba.history.service.impl

import javax.inject.{Inject, Named}
import javax.transaction.Transactional
import javax.validation.Valid

import dawid.kotarba.history.converter.{EventConverter, EventTypeConverter}
import dawid.kotarba.history.dto.EventDto
import dawid.kotarba.history.model.EventType
import dawid.kotarba.history.repository.{EventRepository, EventTypeRepository}
import dawid.kotarba.history.service.EventService
import dawid.kotarba.common.model.enums.EventTypeEnum.EventTypeEnum
import dawid.kotarba.common.utils.PreconditionsUtils

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
    eventRepository.save(EventConverter.toEntity(eventDto, getEventType(eventDto.eventType))).getId
  }

  override def getEventType(eventTypeEnum: EventTypeEnum): EventType = {
    PreconditionsUtils.checkNotNull(eventTypeEnum, "eventTypeEnum")
    val eventTypes = eventTypeRepository.findByEventType(eventTypeEnum.toString)
    if (eventTypes.isEmpty) {
      val eventTypeEntity = EventTypeConverter.toEntity(eventTypeEnum.toString)
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
