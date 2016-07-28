package dawid.kotarba.shared.service.impl

import javax.jms.TextMessage

import dawid.kotarba.shared.annotation.UnitTest
import dawid.kotarba.shared.model.JmsDestinationType
import org.junit.{Assert, Test}

/**
  * Created by Dawid on 01.07.2016.
  */
@UnitTest
class DefaultJmsServiceTest {

  val underTest = new DefaultJmsService

  @Test
  def test(): Unit = {
    // given:
    val testQueueName = "testQueue"
    val connection = underTest.createConnection("vm://localhost?broker.persistent=false")
    connection.start()
    val session = underTest.createSession(connection)
    val producer = underTest.createProducer(session, JmsDestinationType.QUEUE, testQueueName)
    val consumer = underTest.createConsumer(session, JmsDestinationType.QUEUE, testQueueName)

    val testMessageStr = "test message"
    val testMessage = session.createTextMessage(testMessageStr)

    // when:
    producer.send(testMessage)
    val receivedMessage = consumer.receive(100)

    // then:
    if (receivedMessage.isInstanceOf[TextMessage]) {
      val message = receivedMessage.asInstanceOf[TextMessage]
      underTest.close(consumer, session, connection)
      Assert.assertEquals(testMessage.getText, message.getText)
    }
    else {
      underTest.close(consumer, session, connection)
      Assert.fail()
    }
  }
}
