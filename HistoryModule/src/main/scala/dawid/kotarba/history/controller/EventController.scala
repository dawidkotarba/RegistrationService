package dawid.kotarba.history.controller

import javax.inject.Inject
import javax.validation.Valid

import dawid.kotarba.history.dto.EventDto
import dawid.kotarba.history.service.EventService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation._

/**
  * Created by Dawid on 02.08.2016.
  */

@RestController
@RequestMapping(value = Array("/events"), produces = Array(MediaType.APPLICATION_JSON_VALUE))
class EventController @Inject()(eventService: EventService) {

  @RequestMapping(value = Array("/{username}"), method = Array(RequestMethod.GET))
  def findByUsername(@PathVariable username: String): List[EventDto] = eventService.findByUsername(username)

  @RequestMapping(method = Array(RequestMethod.POST))
  def add(@RequestBody @Valid eventDto: EventDto): Long = eventService.add(eventDto)
}
