package dawid.kotarba.shared.service

import javax.jms._

import dawid.kotarba.shared.model.JmsDestinationType

/**
  * Created by Dawid on 26.07.2016.
  */
trait JmsService {
  def createConnection(address: String): Connection

  def createSession(connection: Connection): Session

  def createDestination(session: Session, destinationType: JmsDestinationType.Value, endpointName: String): Destination

  def createConsumer(session: Session, destinationType: JmsDestinationType.Value, endpointName: String): MessageConsumer

  def createProducer(session: Session, destinationType: JmsDestinationType.Value, endpointName: String): MessageProducer

  def close(session: Session, connection: Connection): Unit = {
    session.close()
    connection.close()
  }

  def close(consumer: MessageConsumer, session: Session, connection: Connection): Unit = {
    consumer.close()
    close(session, connection)
  }
}
