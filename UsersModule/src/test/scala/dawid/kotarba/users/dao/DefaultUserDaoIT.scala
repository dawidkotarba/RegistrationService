package dawid.kotarba.users.dao

import javax.inject.Inject

import dawid.kotarba.shared.annotation.IntegrationTest
import dawid.kotarba.users.config.MainConfig
import dawid.kotarba.users.dao.impl.DefaultUserDao
import org.junit.runner.RunWith
import org.junit.{Assert, Test}
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by Dawid on 09.07.2016.
  */

@IntegrationTest
@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[MainConfig]))
@ActiveProfiles(Array("test"))
class DefaultUserDaoIT {

  @Inject
  val underTest: DefaultUserDao = null

  @Test
  def findByUsername(): Unit = {
    // given:
    val username: String = "user"

    // when:
    val result = underTest.findByUsername(username)

    // then:
    Assert.assertNotNull(result.get)
    Assert.assertEquals(username, result.get.username)
    Assert.assertNotNull(result.get.password)
    Assert.assertNotNull(result.get.enabled)
    Assert.assertNotNull(result.get.role)
  }
}
