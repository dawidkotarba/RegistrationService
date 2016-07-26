package dawid.kotarba.eventbus.config

import javax.jms.{Queue, Topic}

import org.apache.activemq.command.{ActiveMQQueue, ActiveMQTopic}
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * Created by Dawid on 26.07.2016.
  */

@Configuration
class QueuesConfig {

  @Bean
  def eventQueue: Queue = {
    new ActiveMQQueue("EventQueue")
  }

  @Bean
  def eventTopic: Topic = {
    new ActiveMQTopic("EventTopic")
  }
}
