package dawid.kotarba.history.service.impl

import javax.inject.Inject

import dawid.kotarba.history.config.MainConfig
import dawid.kotarba.history.dto.EventDto
import dawid.kotarba.history.repository.EventRepository
import dawid.kotarba.shared.model.enums.EventTypeEnum
import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.{IntegrationTest, SpringApplicationConfiguration}
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by Dawid on 14.08.2016.
  */

@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[MainConfig]))
@ActiveProfiles(Array("test"))
@IntegrationTest
class DefaultEventServiceITest {

  @Inject
  val underTest: DefaultEventService = null

  @Inject
  val eventRepository: EventRepository = null

  private val TEST_ID = 1L
  private val TEST_USERNAME = "username"
  private val TEST_EVENT_TYPE_ENUM = EventTypeEnum.LOG_IN
  private val TEST_DESCRIPTION = "desc"

  @Test
  def add(): Unit = {
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

}
