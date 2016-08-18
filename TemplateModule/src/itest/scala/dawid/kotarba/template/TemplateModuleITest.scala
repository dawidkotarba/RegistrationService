package dawid.kotarba.template

import javax.transaction.Transactional

import dawid.kotarba.ui.config.MainConfig
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

/**
  * Created by Dawid on 01.07.2016.
  */
@SpringBootTest(classes = Array(classOf[MainConfig]))
@RunWith(classOf[SpringRunner])
@ActiveProfiles(Array("test"))
@Transactional
class UserInterfaceModuleITest {
  @Test def contextLoads {
  }
}