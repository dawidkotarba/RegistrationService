package dawid.kotarba.history.repository

import dawid.kotarba.history.model.entity.Event
import org.springframework.data.jpa.repository.JpaRepository

/**
  * Created by Dawid on 02.08.2016.
  */
trait EventRepository extends JpaRepository[Event, java.lang.Long] {
  def findByUsername(username: String): java.util.List[Event]
}