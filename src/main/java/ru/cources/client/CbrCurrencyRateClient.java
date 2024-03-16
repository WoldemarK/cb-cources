package ru.cources.client;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import ru.cources.config.CurrencyClientConfig;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CbrCurrencyRateClient implements HttpCurrencyDateRateClient {

    public static String DATER_PATTERN = "dd/MM/yyyy";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATER_PATTERN);
    private final CurrencyClientConfig config;

    public CbrCurrencyRateClient(CurrencyClientConfig config) {
        this.config = config;
    }

    @Override
    public String requestByData(LocalDate date) {
        HttpClient client = HttpClient.newHttpClient();
        String url = buildUrlRequest(config.getUrl(), date);

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url)).build();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String buildUrlRequest(String url, LocalDate date) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("date_req", DATE_TIME_FORMATTER.format(date))
                .build().toString();
    }
}
