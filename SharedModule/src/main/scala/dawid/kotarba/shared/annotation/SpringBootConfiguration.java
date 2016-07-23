package dawid.kotarba.shared.annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;


/**
 * Created by Dawid on 03.07.2016.
 */

@SpringBootApplication
@ComponentScan("dawid.kotarba")
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SpringBootConfiguration {

}
