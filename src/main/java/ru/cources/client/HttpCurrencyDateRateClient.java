package ru.cources.client;

import java.time.LocalDate;

public interface HttpCurrencyDateRateClient {

    String requestByData(LocalDate date);
}
