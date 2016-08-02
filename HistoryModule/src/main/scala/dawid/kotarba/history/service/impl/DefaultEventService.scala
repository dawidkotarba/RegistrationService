package dawid.kotarba.history.service.impl

import javax.inject.{Inject, Named}
import javax.transaction.Transactional
import javax.validation.Valid

import dawid.kotarba.history.dao.EventDao
import dawid.kotarba.history.dto.EventDto
import dawid.kotarba.history.service.EventService
import dawid.kotarba.shared.utils.PreconditionsUtils

/**
  * Created by Dawid on 02.08.2016.
  */
@Named
@Transactional
class DefaultEventService @Inject()(eventDao: EventDao) extends EventService {
  override def findByUsername(username: String): List[EventDto] = {
    PreconditionsUtils.checkNotNull(username, "username")
    eventDao.findByUsername(username)
  }

  override def add(@Valid eventDto: EventDto): Long = {
    PreconditionsUtils.checkNotNull(eventDto, "eventDto")
    eventDao.add(eventDto)
  }
}
