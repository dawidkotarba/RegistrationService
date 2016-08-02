package dawid.kotarba.history.dao

import dawid.kotarba.history.dto.EventDto

/**
  * Created by Dawid on 02.08.2016.
  */
trait EventDao {
  def findByUsername(username: String): List[EventDto]

  def add(eventDto: EventDto): Long
}
