package org.akkuratnov.arbina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:spring.propertis")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
