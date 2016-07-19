package dawid.kotarba.users.integration

 import javax.inject.Inject

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

@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[MainConfig]))
@ActiveProfiles(Array("test"))
class DefaultUserDaoTest {

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

  @Test(expected = classOf[NullPointerException])
  def findByUsernameForNull(): Unit =
    underTest.findByUsername(null)

}
