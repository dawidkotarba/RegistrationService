package dawid.kotarba.users.dao

import javax.inject.Inject

import dawid.kotarba.users.config.MainConfig
import dawid.kotarba.users.dao.impl.DefaultUserDao
import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.{IntegrationTest, SpringApplicationConfiguration}
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner


/**
  * Created by Dawid on 09.07.2016.
  */

@IntegrationTest
@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[MainConfig]))
@ActiveProfiles(Array("test"))
class DefaultUserDaoITest {

  @Inject
  val underTest: DefaultUserDao = null

  @Test
  def findByUsername(): Unit = {
    // given:
    val username: String = "user"

    // when:
    val result = underTest.findByUsername(username)

    // then:
    assertNotNull(result.get)
    assertEquals(username, result.get.username)
    assertNotNull(result.get.password)
    assertNotNull(result.get.enabled)
    assertNotNull(result.get.role)
  }
}
