package dawid.kotarba.history.repository


import dawid.kotarba.history.model.entity.EventType
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.repository.JpaRepository

/**
  * Created by Dawid on 03.08.2016.
  */
trait EventTypeRepository extends JpaRepository[EventType, java.lang.Long] {

//  @Cacheable(cacheNames = Array("eventTypeCache")) //testing purpose, cannot cache that
  def findByEventType(eventType: String): java.util.List[EventType]
}
