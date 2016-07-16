package dawid.kotarba.shared.annotation;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Created by Dawid on 03.07.2016.
 */

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@ComponentScan("dawid.kotarba")
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SpringBootConfiguration {

}
