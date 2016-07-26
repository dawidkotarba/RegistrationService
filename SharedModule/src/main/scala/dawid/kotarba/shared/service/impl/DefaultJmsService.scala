package dawid.kotarba.shared.service.impl

import javax.inject.Named
import javax.jms._

import dawid.kotarba.shared.model.JmsDestinationType
import dawid.kotarba.shared.service.JmsService
import org.apache.activemq.ActiveMQConnectionFactory

/**
  * Created by Dawid on 26.07.2016.
  */

@Named
class DefaultJmsService extends JmsService {

  override def createConnection(address: String): Connection = {
    val connectionFactory = new ActiveMQConnectionFactory(address)
    connectionFactory.createConnection()
  }

  override def createSession(connection: Connection): Session = {
    connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
  }

  override def createDestination(session: Session, destinationType: JmsDestinationType.Value, endpointName: String): Destination = {
    val destination = destinationType match {
      case JmsDestinationType.QUEUE => session.createQueue(endpointName)
      case JmsDestinationType.TOPIC => session.createTopic(endpointName)
    }
    destination
  }

  override def createConsumer(session: Session, destinationType: JmsDestinationType.Value, endpointName: String): MessageConsumer = {
    val destination: Destination = createDestination(session, destinationType, endpointName)
    session.createConsumer(destination)
  }

  override def createProducer(session: Session, destinationType: JmsDestinationType.Value, endpointName: String): MessageProducer = {
    val destination: Destination = createDestination(session, destinationType, endpointName)
    session.createProducer(destination)
  }
}

