package dawid.kotarba.users.config

import dawid.kotarba.shared.config.extendable.CommonMockDbConfig
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
  * Created by Dawid on 03.07.2016.
  */

@Configuration
@EnableTransactionManagement
class MockDbConfig extends CommonMockDbConfig