package dawid.kotarba.ui

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
