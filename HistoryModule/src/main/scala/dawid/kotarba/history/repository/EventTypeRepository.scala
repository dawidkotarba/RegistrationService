package dawid.kotarba.history.repository

import dawid.kotarba.history.model.entity.EventType
import org.springframework.data.jpa.repository.JpaRepository

/**
  * Created by Dawid on 03.08.2016.
  */
trait EventTypeRepository extends JpaRepository[EventType, java.lang.Long] {
  def findByEventType(eventType: String): java.util.List[EventType]
}
