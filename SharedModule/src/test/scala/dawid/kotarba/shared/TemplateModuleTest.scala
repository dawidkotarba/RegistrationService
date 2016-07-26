package dawid.kotarba.template

import javax.jms.TextMessage

import dawid.kotarba.shared.annotation.UnitTest
import dawid.kotarba.shared.model.JmsDestinationType
import dawid.kotarba.shared.service.impl.DefaultJmsService
import org.apache.activemq.command.ActiveMQQueue
import org.junit.{Assert, Test}

/**
  * Created by Dawid on 01.07.2016.
  */
@UnitTest
class DefaultJmsServiceTest {

  val underTest = new DefaultJmsService

  @Test
  def test(): Unit = {

    val queueName = "testQ"
    val queue = new ActiveMQQueue(queueName)
    val connection = underTest.createConnection("vm://localhost")
    val session = underTest.createSession(connection)
    val producer = underTest.createProducer(session, JmsDestinationType.QUEUE, queueName)

    val testMessageStr = "test message"
    val testMessage = session.createTextMessage(testMessageStr)
    producer.send(testMessage)

    val consumer = underTest.createConsumer(session, JmsDestinationType.QUEUE, queueName)
    val receivedMessage = consumer.receive(1000)

    if (receivedMessage.isInstanceOf[TextMessage]) {
      val message = receivedMessage.asInstanceOf[TextMessage]
      Assert.assertEquals(testMessage, message.getText)
    }
    else {
      Assert.fail()
    }
  }

}
