package dawid.kotarba.history.service.impl

import java.util.Collections

import dawid.kotarba.history.dto.EventDto
import dawid.kotarba.history.model.{Event, EventType}
import dawid.kotarba.history.repository.{EventRepository, EventTypeRepository}
import dawid.kotarba.shared.annotation.UnitTest
import dawid.kotarba.shared.model.enums.EventTypeEnum
import org.junit.Assert._
import org.junit.{Before, Test}
import org.mockito.Mockito._
import org.mockito._
import org.springframework.test.util.ReflectionTestUtils

/**
  * Created by Dawid on 14.08.2016.
  */
@UnitTest
class DefaultEventServiceTest {

  private var underTest: DefaultEventService = null

  @Mock
  private val eventRepository: EventRepository = null

  @Mock
  private val eventTypeRepository: EventTypeRepository = null

  @Captor
  private val eventCaptor: ArgumentCaptor[Event] = null

  @Captor
  private val eventTypeCaptor: ArgumentCaptor[EventType] = null

  @Captor
  private val stringCaptor: ArgumentCaptor[String] = null

  private val TEST_USERNAME = "username"
  private val TEST_DESCRIPTION = "desc"
  private val TEST_ID = 1L
  private val TEST_EVENT_TYPE_ENUM = EventTypeEnum.LOG_IN

  @Before
  def setUp(): Unit = {
    MockitoAnnotations.initMocks(this)
    underTest = new DefaultEventService(eventRepository, eventTypeRepository)
  }

  @Test
  def add(): Unit = {
    // given:
    val eventDto = EventDto(TEST_USERNAME, EventTypeEnum.LOG_IN, TEST_DESCRIPTION)
    val savedEvent = new Event
    ReflectionTestUtils.setField(savedEvent, "id", TEST_ID)
    when(eventRepository.save(eventCaptor.capture())).thenReturn(savedEvent)

    // when:
    val result = underTest.add(eventDto)

    // then:
    assertEquals(TEST_ID, result)
    assertEquals(TEST_USERNAME, eventCaptor.getValue.username)
    assertEquals(TEST_DESCRIPTION, eventCaptor.getValue.description)
    assertNotNull(eventCaptor.getValue.eventDate)
  }

  @Test
  def getEventTypeForEmptySavedType(): Unit = {
    // given:
    val savedEventType = new EventType
    savedEventType.eventType = TEST_EVENT_TYPE_ENUM.toString
    when(eventTypeRepository.findByEventType(stringCaptor.capture())).thenReturn(Collections.emptyList[EventType])
    when(eventTypeRepository.save(eventTypeCaptor.capture())).thenReturn(savedEventType)

    // when:
    val result = underTest.getEventType(TEST_EVENT_TYPE_ENUM)

    // then:
    assertEquals(TEST_EVENT_TYPE_ENUM.toString, result.eventType)
    assertEquals(TEST_EVENT_TYPE_ENUM.toString, eventTypeCaptor.getValue.eventType)
    assertEquals(TEST_EVENT_TYPE_ENUM.toString, stringCaptor.getValue)
  }

  @Test
  def findByUsername(): Unit = {
    // given:
    val resultEvent = new Event
    val resultEventType = new EventType
    resultEventType.eventType = TEST_EVENT_TYPE_ENUM.toString
    resultEvent.eventType = resultEventType
    resultEvent.username = TEST_USERNAME
    when(eventRepository.findByUsername(stringCaptor.capture())).thenReturn(Collections.singletonList(resultEvent))

    // when:
    val result = underTest.findByUsername(TEST_USERNAME)

    // then:
    assertTrue(result.size == 1)
    assertEquals(TEST_USERNAME, result(0).username)
    assertEquals(TEST_EVENT_TYPE_ENUM, result(0).eventType)
  }
}
