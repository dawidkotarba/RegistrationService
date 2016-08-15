package dawid.kotarba.history.service

import dawid.kotarba.history.dto.EventDto
import dawid.kotarba.history.model.EventType
import dawid.kotarba.common.model.enums.EventTypeEnum._

/**
  * Created by Dawid on 02.08.2016.
  */
trait EventService {
  def add(eventDto: EventDto): Long

  def findByUsername(username: String): List[EventDto]

  def getEventType(eventTypeEnum: EventTypeEnum): EventType
}
