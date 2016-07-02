package dawid.kotarba.template

/**
  * Created by Dawid on 01.07.2016.
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[MainConfiguration]))
@ActiveProfiles(Array("test"))
class TemplateModuleTests {
  @Test def contextLoads {
  }
}
