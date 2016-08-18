package dawid.kotarba.authentication.service

import java.net.URI
import java.util

import dawid.kotarba.common.annotation.UnitTest
import dawid.kotarba.common.exceptions.impl.BadCredentialsException
import dawid.kotarba.common.service.RestTemplateService
import dawid.kotarba.common.service.impl.ModulesPropertiesService
import org.junit.{Before, Test}
import org.mockito.Mockito._
import org.mockito.{Mock, MockitoAnnotations}
import org.springframework.cloud.client.ServiceInstance
import org.springframework.security.core.{Authentication, GrantedAuthority}

/**
  * Created by Dawid on 17.07.2016.
  */

@UnitTest
class UserAuthenticationManagerServiceTest {

  private var underTest: UserAuthenticationManagerService = null

  @Mock
  private val restTemplateService: RestTemplateService = null

  @Mock
  private val modulesPropertiesService: ModulesPropertiesService = null


  @Before
  def setUp(): Unit = {
    MockitoAnnotations.initMocks(this)
    underTest = new UserAuthenticationManagerService(restTemplateService, modulesPropertiesService)
  }

  @Test(expected = classOf[BadCredentialsException])
  def authenticateForEmptyResponse(): Unit = {
    // given:
    val usersModuleName = "Users_Module"
    when(modulesPropertiesService.usersModuleName).thenReturn(usersModuleName)
    val serviceInstances = new util.ArrayList[ServiceInstance]()
    serviceInstances.add(new ServiceInstance {
      override def getMetadata: util.Map[String, String] = new util.HashMap[String, String]()

      override def isSecure: Boolean = false

      override def getHost: String = "localhost"

      override def getPort: Int = new Integer("9999")

      override def getServiceId: String = usersModuleName

      override def getUri: URI = new URI("")
    })

    val authentication = new Authentication {
      override def getDetails: AnyRef = null

      override def getPrincipal: AnyRef = "test"

      override def isAuthenticated: Boolean = true

      override def getAuthorities: util.Collection[_ <: GrantedAuthority] = null

      override def getCredentials: AnyRef = "test"

      override def setAuthenticated(isAuthenticated: Boolean): Unit = ???

      override def getName: String = null
    }

    // when:
    underTest.authenticate(authentication)
  }

  @Test(expected = classOf[NullPointerException])
  def authenticateWithNullAuthentication(): Unit = {
    // given:
    val authentication = null

    // when:
    underTest.authenticate(authentication)
  }

  @Test(expected = classOf[BadCredentialsException])
  def authenticateWithEmptyUsername(): Unit = {
    // given:
    val authentication = new Authentication {
      override def getDetails: AnyRef = null

      override def getPrincipal: AnyRef = ""

      override def isAuthenticated: Boolean = true

      override def getAuthorities: util.Collection[_ <: GrantedAuthority] = null

      override def getCredentials: AnyRef = ""

      override def setAuthenticated(isAuthenticated: Boolean): Unit = ???

      override def getName: String = null
    }

    // when:
    underTest.authenticate(authentication)
  }

  @Test(expected = classOf[BadCredentialsException])
  def authenticateWithEmptyPassword(): Unit = {
    // given:
    val authentication = new Authentication {
      override def getDetails: AnyRef = null

      override def getPrincipal: AnyRef = ""

      override def isAuthenticated: Boolean = true

      override def getAuthorities: util.Collection[_ <: GrantedAuthority] = null

      override def getCredentials: AnyRef = ""

      override def setAuthenticated(isAuthenticated: Boolean): Unit = ???

      override def getName: String = null
    }

    // when:
    underTest.authenticate(authentication)
  }
}
