package dawid.kotarba.history.service.impl

import java.time.LocalDateTime
import javax.inject.Inject
import javax.transaction.Transactional

import dawid.kotarba.common.model.enums.EventTypeEnum
import dawid.kotarba.history.config.MainConfig
import dawid.kotarba.history.dto.EventDto
import dawid.kotarba.history.model.Event
import dawid.kotarba.history.repository.{EventRepository, EventTypeRepository}
import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

/**
  * Created by Dawid on 14.08.2016.
  */

@SpringBootTest(classes = Array(classOf[MainConfig]))
@RunWith(classOf[SpringRunner])
@ActiveProfiles(Array("test"))
@Transactional
class DefaultEventServiceITest {

  @Inject
  private val underTest: DefaultEventService = null

  @Inject
  private val eventRepository: EventRepository = null

  @Inject
  private val eventTypeRepository: EventTypeRepository = null

  private val TEST_ID = 1L
  private val TEST_USERNAME = "username"
  private val TEST_EVENT_TYPE_ENUM = EventTypeEnum.LOG_IN
  private val TEST_DESCRIPTION = "desc"

  @Test
  def add: Unit = {
    // given:
    assertTrue(eventRepository.findAll().isEmpty)
    val eventDto = EventDto(TEST_USERNAME, TEST_EVENT_TYPE_ENUM, TEST_DESCRIPTION)

    // when:
    val result = underTest.add(eventDto)

    // then:
    assertEquals(1L, result)
    assertFalse(eventRepository.findAll().isEmpty)

    val savedEvent = eventRepository.findOne(result)
    assertEquals(TEST_USERNAME, savedEvent.username)
    assertEquals(TEST_EVENT_TYPE_ENUM.toString, savedEvent.eventType.eventType)
    assertEquals(TEST_DESCRIPTION, savedEvent.description)
    assertNotNull(savedEvent.eventDate)
  }

  @Test
  def getEventType: Unit = {
    // given:
    val logInEnum = EventTypeEnum.LOG_IN

    // when:
    val eventType = underTest.getEventType(logInEnum)

    // then:
    assertEquals(logInEnum.toString, eventType.eventType)
  }

  @Test
  def findByUsername: Unit = {
    // given:
    val testEvent = new Event
    testEvent.eventType = eventTypeRepository.findByEventType(TEST_EVENT_TYPE_ENUM.toString).get(0)
    testEvent.username = TEST_USERNAME
    testEvent.description = TEST_DESCRIPTION
    testEvent.eventDate = LocalDateTime.now()
    assertTrue(eventRepository.findByUsername(TEST_USERNAME).isEmpty)
    eventRepository.save(testEvent)

    // when:
    val result = eventRepository.findByUsername(TEST_USERNAME)

    // then:
    assertEquals(1, eventRepository.findByUsername(TEST_USERNAME).size())
    assertEquals(TEST_DESCRIPTION, eventRepository.findByUsername(TEST_USERNAME).get(0).description)
  }
}
