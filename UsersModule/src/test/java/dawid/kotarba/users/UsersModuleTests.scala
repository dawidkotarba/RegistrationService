package dawid.kotarba.users

import dawid.kotarba.users.config.MainConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.context.annotation.Profile
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by Dawid on 01.07.2016.
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[MainConfiguration]))
@Profile(Array("test"))
class UsersModuleTests {
  @Test def contextLoads {
  }
}
