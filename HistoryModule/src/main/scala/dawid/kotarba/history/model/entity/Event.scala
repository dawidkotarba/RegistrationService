package dawid.kotarba.history.model.entity

import java.util.Date
import javax.persistence._

import dawid.kotarba.shared.model.entities.AbstractEntity

/**
  * Created by Dawid on 02.08.2016.
  */

@Entity
@Table(name = "EVENTS")
@SequenceGenerator(name = "PK", sequenceName = "EVENT_SEQ", allocationSize = 1)
class Event extends AbstractEntity {

  @Column(name = "USERNAME", nullable = false, unique = true)
  var username: String = null

  @Column(name = "EVENT_DATE", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  var eventDate: Date = null

  @OneToOne(cascade = Array(CascadeType.ALL))
  @JoinColumn(name = "EVENT")
  var eventType: EventType = null

  @Column(name = "DESCRIPTION")
  var description: String = null
}