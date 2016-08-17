package dawid.kotarba.users.service

import javax.inject.Inject
import javax.transaction.Transactional

import dawid.kotarba.users.config.MainConfig
import dawid.kotarba.users.model.User
import dawid.kotarba.users.repository.UserRepository
import dawid.kotarba.users.service.impl.DefaultUserService
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
@Transactional
class DefaultUserServiceITest {

  @Inject
  val underTest: DefaultUserService = null

  @Inject
  val userRepository: UserRepository = null

  val TEST_USERNAME = "username"
  val TEST_IS_ENABLED = true
  val TEST_PASSWORD = "test"
  val TEST_ROLE = "role"

  @Test
  def findByUsername(): Unit = {
    // given:
    val testUser = new User
    testUser.username = TEST_USERNAME
    testUser.enabled = TEST_IS_ENABLED
    testUser.password = TEST_PASSWORD
    testUser.role = TEST_ROLE
    assertTrue(userRepository.findByUsername(TEST_USERNAME).isEmpty)
    userRepository.save(testUser)

    // when:
    val result = underTest.findByUsername(TEST_USERNAME)

    // then:
    assertNotNull(result)
    assertEquals(TEST_USERNAME, result.username)
    assertEquals(TEST_PASSWORD, result.password)
    assertEquals(TEST_IS_ENABLED, result.enabled)
    assertEquals(TEST_ROLE, result.role)
  }
}