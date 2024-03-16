package ru.cources.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties("currency.client.url")
public class CurrencyClientConfig {

    private String url;

}
