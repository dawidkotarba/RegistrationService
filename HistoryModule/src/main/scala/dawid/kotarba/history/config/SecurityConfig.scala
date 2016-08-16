package dawid.kotarba.history.config

import dawid.kotarba.common.config.optional.{OAuthResourceServerConfig, OAuthSecurityConfig}
import org.springframework.context.annotation.Configuration


@Configuration
class SecurityConfig extends OAuthSecurityConfig

@Configuration
class ResourceServerConfig extends OAuthResourceServerConfig