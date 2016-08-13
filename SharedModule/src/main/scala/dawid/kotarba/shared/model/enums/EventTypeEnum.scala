package dawid.kotarba.shared.model.enums

import com.fasterxml.jackson.core.`type`.TypeReference

/**
  * Created by Dawid on 04.08.2016.
  */

object EventTypeEnum extends Enumeration {
  type EventTypeEnum = Value
  val LOG_IN, LOG_OUT = Value
}

class EventTypeEnumType extends TypeReference[EventTypeEnum.type]
