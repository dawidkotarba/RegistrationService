package dawid.kotarba.users.dao

import dawid.kotarba.shared.annotation.UnitTest
import dawid.kotarba.users.dao.impl.DefaultUserDao
import dawid.kotarba.users.model.User
import dawid.kotarba.users.repository.UserRepository
import org.junit.Assert._
import org.junit.{Before, Test}
import org.mockito.Mockito._
import org.mockito.{ArgumentCaptor, Captor, Mock, MockitoAnnotations}

/**
  * Created by Dawid on 20.07.2016.
  */

@UnitTest
class DefaultUserDaoTest {

  var underTest: DefaultUserDao = null

  @Mock
  val userRepository: UserRepository = null

  @Captor
  val usernameCaptor = ArgumentCaptor.forClass(classOf[String])

  @Before
  def setUp(): Unit = {
    MockitoAnnotations.initMocks(this)
    underTest = new DefaultUserDao(userRepository)
  }

  @Test
  def findByUsernameForNoUsers(): Unit = {
    // given:
    val testUserName = "testUser"
    val users = new java.util.ArrayList[User]
    when(userRepository.findByUsername(usernameCaptor.capture())).thenReturn(users)

    // when:
    val result = underTest.findByUsername(testUserName)

    // then:
    assertTrue(result.isEmpty)
    assertEquals(testUserName, usernameCaptor.getValue)
  }

  @Test
  def findByUsernameForValidUser(): Unit = {
    // given:
    val testUserName = "testUser"
    val user = new User
    user.username = testUserName

    val users = new java.util.ArrayList[User]
    users.add(user)
    when(userRepository.findByUsername(usernameCaptor.capture())).thenReturn(users)

    // when:
    val result = underTest.findByUsername(testUserName)

    // then:
    assertTrue(result.isDefined)
    assertEquals(testUserName, usernameCaptor.getValue)
    assertEquals(testUserName, result.get.username)
  }

  @Test(expected = classOf[NullPointerException])
  def findByUsernameForNull(): Unit =
    underTest.findByUsername(null)
}
