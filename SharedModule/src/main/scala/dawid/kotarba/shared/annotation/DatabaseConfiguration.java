package dawid.kotarba.shared.annotation;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Dawid on 09.07.2016.
 */

@Configuration
@EnableJpaRepositories("dawid.kotarba")
@EntityScan("dawid.kotarba")
@EnableTransactionManagement
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseConfiguration {
}
