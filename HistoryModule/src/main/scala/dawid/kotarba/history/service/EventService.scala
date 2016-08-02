package dawid.kotarba.history.service

import dawid.kotarba.history.dto.EventDto

/**
  * Created by Dawid on 02.08.2016.
  */
trait EventService {
  def findByUsername(username: String): List[EventDto]

  def add(eventDto: EventDto): Long
}
