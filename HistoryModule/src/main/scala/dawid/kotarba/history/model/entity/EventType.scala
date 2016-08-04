package dawid.kotarba.history.model.entity

import javax.persistence._

import dawid.kotarba.history.model.enums.EventTypeEnum.EventTypeEnum
import dawid.kotarba.shared.model.entities.AbstractEntity

/**
  * Created by Dawid on 02.08.2016.
  */

@Entity
@Table(name = "EVENT_TYPES")
@SequenceGenerator(name = "PK", sequenceName = "EVENT_TYPE_SEQ", allocationSize = 1)
class EventType extends AbstractEntity {

  @Column(name = "TYPE", nullable = false, unique = true)
  var eventType: EventTypeEnum = null
}