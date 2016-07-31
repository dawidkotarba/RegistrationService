package dawid.kotarba.ui

import dawid.kotarba.ui.config.MainConfig
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.{IntegrationTest, SpringApplicationConfiguration}
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by Dawid on 01.07.2016.
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[MainConfig]))
@ActiveProfiles(Array("test"))
@IntegrationTest
class UserInterfaceModuleITest {
  @Test def contextLoads {
  }
}
