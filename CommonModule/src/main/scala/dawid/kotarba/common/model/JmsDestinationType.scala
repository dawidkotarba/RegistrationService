package dawid.kotarba.common.model

/**
  * Created by Dawid on 26.07.2016.
  */
object JmsDestinationType extends Enumeration {
  type JmsDestinationType = Value
  val QUEUE, TOPIC = Value
}