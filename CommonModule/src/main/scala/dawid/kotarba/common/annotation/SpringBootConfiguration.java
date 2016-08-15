package dawid.kotarba.common.annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.lang.annotation.*;


/**
 * Created by Dawid on 03.07.2016.
 */

@SpringBootApplication
@ComponentScan("dawid.kotarba")
@EnableWebSecurity
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SpringBootConfiguration {

}
