package dawid.kotarba.shared.annotation;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.lang.annotation.*;


/**
 * Created by Dawid on 03.07.2016.
 */

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@ComponentScan("dawid.kotarba")
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SpringBootConfiguration {

}
