package dawid.kotarba.users.service

import dawid.kotarba.common.annotation.UnitTest
import dawid.kotarba.common.exceptions.impl.NotFoundException
import dawid.kotarba.users.model.User
import dawid.kotarba.users.repository.UserRepository
import dawid.kotarba.users.service.impl.DefaultUserService
import org.junit.Assert._
import org.junit.{Before, Test}
import org.mockito.Mockito._
import org.mockito.{ArgumentCaptor, Captor, Mock, MockitoAnnotations}

/**
  * Created by Dawid on 20.07.2016.
  */

@UnitTest
class DefaultUserServiceTest {

  var underTest: DefaultUserService = null

  @Mock
  val userRepository: UserRepository = null

  @Captor
  val usernameCaptor = ArgumentCaptor.forClass(classOf[String])

  @Before
  def setUp(): Unit = {
    MockitoAnnotations.initMocks(this)
    underTest = new DefaultUserService(userRepository)
  }

  @Test(expected = classOf[NotFoundException])
  def findByUsernameForNoUsers(): Unit = {
    // given:
    val testUserName = "testUser"
    val users = new java.util.ArrayList[User]
    when(userRepository.findByUsername(usernameCaptor.capture())).thenReturn(users)

    // when:
    val result = underTest.findByUsername(testUserName)
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
    assertEquals(testUserName, usernameCaptor.getValue)
    assertEquals(testUserName, result.username)
  }

  @Test(expected = classOf[NullPointerException])
  def findByUsernameForNull(): Unit =
    underTest.findByUsername(null)
}
