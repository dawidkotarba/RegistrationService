package dawid.kotarba.shared.service.impl

import java.util.concurrent.atomic.AtomicLong
import javax.inject.Named
import javax.management.Notification

import org.springframework.jmx.export.annotation.ManagedResource
import org.springframework.jmx.export.notification.{NotificationPublisher, NotificationPublisherAware}

/**
  * Created by Dawid on 23.07.2016.
  */
@Named
@ManagedResource
class JmxNotificationPublisherService extends NotificationPublisherAware {

  private val notificationSequence: AtomicLong = new AtomicLong
  private var notificationPublisher: NotificationPublisher = null

  override def setNotificationPublisher(notificationPublisher: NotificationPublisher): Unit =
    this.notificationPublisher = notificationPublisher

  def notify(message: String, source: String): Unit = {
    if (notificationPublisher != null) {
      val notification = new Notification("type", source, notificationSequence.getAndIncrement(), message)
      notificationPublisher.sendNotification(notification)
    }
  }
}