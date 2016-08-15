package dawid.kotarba.shared.service

import javax.jms._

import dawid.kotarba.shared.model.JmsDestinationType.JmsDestinationType

/**
  * Created by Dawid on 26.07.2016.
  */
trait JmsService {
  def createConnection(address: String): Connection

  def createSession(connection: Connection): Session

  def createDestination(session: Session, destinationType: JmsDestinationType, endpointName: String): Destination

  def createConsumer(session: Session, destinationType: JmsDestinationType, endpointName: String): MessageConsumer

  def createProducer(session: Session, destinationType: JmsDestinationType, endpointName: String): MessageProducer

  def close(session: Session, connection: Connection): Unit = {
    if (session != null) {
      session.close()
    }

    if (connection != null) {
      connection.close()
    }
  }

  def close(consumer: MessageConsumer, session: Session, connection: Connection): Unit = {
    if (consumer != null) {
      consumer.close()
    }
    close(session, connection)
  }
}
