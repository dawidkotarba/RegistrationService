package dawid.kotarba.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UsersModule {
    public static void main(String[] args) {
        SpringApplication.run(UsersModule.class, args);
    }
}
