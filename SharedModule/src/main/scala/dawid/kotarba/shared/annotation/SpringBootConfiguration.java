package dawid.kotarba.shared.annotation;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Created by Dawid on 03.07.2016.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan("dawid.kotarba")
@Retention(RetentionPolicy.RUNTIME)
public @interface SpringBootConfiguration {

}
