package ru.cources.client;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CbrCurrencyRateRateClient implements HttpCurrencyDateRateClient {

    public static String DATER_PATTERN = "dd/MM/yyyy";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATER_PATTERN);

    @Override
    public String requestByData(LocalDate date) {
        String BASE_URL = "https://cbr.ru/scripts/XML_daily.asp";
        HttpClient client = HttpClient.newHttpClient();
        String url = buildUrlRequest(BASE_URL, date);

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode() + "OK");

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
