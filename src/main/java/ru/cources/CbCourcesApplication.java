package ru.cources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.cources.config.CurrencyClientConfig;

@SpringBootApplication
@EnableConfigurationProperties(CurrencyClientConfig.class)
public class CbCourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbCourcesApplication.class, args);
    }

}
